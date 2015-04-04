package br.edu.ftlf.ads.revenda.controller;

import static org.junit.Assert.assertThat;

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
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.interceptor.UserInfo;
import br.edu.ftlf.ads.revenda.model.Usuario;
import br.edu.ftlf.ads.revenda.service.FuncionariosService;

public class HomeControllerTest {

	private HomeController controller;
	private Result result;
	private Validator validator;
	@Mock
	private FuncionariosService usuariosService;
	@Mock
	private UserInfo info;
	private Usuario usuario;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		result = new MockResult();
		validator = new MockValidator();
		usuario = new Usuario();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		info.setUsuario(usuario);

		controller = new HomeController(result, validator, usuariosService,
				info);

	}

	@Test
	public void deveriaLogarQuandoUsuarioExistir() {
		Mockito.when(usuariosService.contains(usuario)).thenReturn(true);
		controller.login(usuario);

		assertThat(validator.getErrors(), Matchers.empty());
	}

	@Test
	public void naoDeveriaLogarQuandousuarioNaoExistir() {
		Mockito.when(usuariosService.contains(usuario)).thenReturn(false);
		controller.login(usuario);
		
		assertThat((List<Message>)result.included().get("errors"), Matchers.not(Matchers.empty()));
	}

}
