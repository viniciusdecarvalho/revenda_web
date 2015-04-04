package br.edu.ftlf.ads.revenda.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.interceptor.UserInfo;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.service.ClientesService;

public class ClientesControllerTest {

	private ClientesController controller;
	private Result result;
	private Validator validator;
	@Mock
	private ClientesService clientesService;
	@Mock
	private UserInfo info;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		result = new MockResult();
		validator = new MockValidator();
		
		controller = new ClientesController(result, validator, clientesService);
		
	}

	
	@SuppressWarnings("unchecked")
	@Test
	public void deveriaRetornarListaDeClientes() {
		List<Cliente> clientes = getClientes();
		Mockito.when(clientesService.list()).thenReturn(clientes);

		controller.lista();
		
		assertNotNull(result.included().get("clientes"));
		assertThat((List<Cliente>)result.included().get("clientes"), Matchers.is(clientes));
		
	}
	
	@Test
	public void deveriaSalvarCliente() {
		
		Cliente cliente = getClientes().get(0);
		
		controller.salva(cliente);
		
		assertTrue(validator.getErrors().isEmpty());		
		assertNotNull(result.included().get("notice"));
	}
	
	@Test
	public void deveriaDeletarCliente() {
		controller.deleta(getClientes().get(0));
		
		assertTrue(validator.getErrors().isEmpty());		
		assertNotNull(result.included().get("notice"));
	}

	private List<Cliente> getClientes() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		cliente.setRazaoSocial("VINICIUS");
		cliente.setCpfCnpj("12345678900");
		cliente.setAtivo(true);
		return Arrays.asList(cliente);
	}

}
