package br.edu.ftlf.ads.revenda.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


import static org.mockito.Mockito.when;

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
import br.edu.ftlf.ads.revenda.conversation.Compra;
import br.edu.ftlf.ads.revenda.dao.AquisicoesDao;
import br.edu.ftlf.ads.revenda.dao.ClientesDao;
import br.edu.ftlf.ads.revenda.dao.FormasPagamentosDao;
import br.edu.ftlf.ads.revenda.dao.FuncionariosDao;
import br.edu.ftlf.ads.revenda.dao.VeiculosDao;
import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Veiculo;
import br.edu.ftlf.ads.revenda.view.VeiculoModelView;

public class AquisicoesControllerTest {

	private static final int VEICULO_ID = 1;
	private AquisicoesController controller;
	private Result result;
	private Validator validator;
	
	@Mock private AquisicoesDao aquisicoesService;
	@Mock private ClientesDao clientesService;
	@Mock private FuncionariosDao funcionariosService;
	@Mock private VeiculosDao veiculosService;
	@Mock private FormasPagamentosDao formasPagamentosService;
	@Mock private Compra compra;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		result = new MockResult();
		validator = new MockValidator();
		
		controller = new AquisicoesController(result, validator, aquisicoesService, funcionariosService, clientesService, veiculosService, formasPagamentosService, compra);
		
	}
	
	@Test
	public void deveriaIniciarConversationComDadosDosVeiculos() {
		
		List<Veiculo> veiculos = getVeiculos();
		when(veiculosService.list()).thenReturn(veiculos);
		
		controller.veiculo();
		
		assertThat(veiculos, Matchers.not(Matchers.empty()));
		
	}

	private VeiculoModelView getVeiculoView() {
		VeiculoModelView modelView = new VeiculoModelView();
		modelView.setVeiculo(getVeiculos().get(0));
		modelView.setCidade("FORTALEZA");
		modelView.setCombustivel(Combustivel.GASOLINA);
		modelView.setCor("BRANCA");
		modelView.setKm(90000L);
		modelView.setUf("CE");
		return modelView;
	}

	private List<Veiculo> getVeiculos() {
		Veiculo veiculo = new Veiculo();
		veiculo.setAno("2012");
		veiculo.setChassi("9BZ12788734616532");
		veiculo.setEspecie("AUTOMOVEL");
		veiculo.setId(VEICULO_ID);
		veiculo.setMarca("FIAT");
		veiculo.setModelo("PALIO");
		veiculo.setPlaca("NUO1090");
		veiculo.setRenavan("90801234");
		return Arrays.asList(veiculo);
	}

}
