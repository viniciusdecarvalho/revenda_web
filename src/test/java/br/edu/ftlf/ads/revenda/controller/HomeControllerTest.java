package br.edu.ftlf.ads.revenda.controller;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.ftlf.ads.revenda.dao.FuncionariosDao;
import br.edu.ftlf.ads.revenda.interceptor.UserInfo;
import br.edu.ftlf.ads.revenda.model.UsuarioWeb;

public class HomeControllerTest {

	private HomeController controller;
	private Result result;
	private Validator validator;
	@Mock private FuncionariosDao usuariosService;
	@Mock private UserInfo info;
	private UsuarioWeb usuario;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		result = new MockResult();
		validator = new MockValidator();
		usuario = new UsuarioWeb();
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		info.setUsuario(usuario);

		controller = new HomeController(result, validator, usuariosService, info);

	}

	@Test
	public void deveriaLogarQuandoUsuarioExistir() {
		when(usuariosService.contains(usuario)).thenReturn(true);
		controller.login(usuario);
	
		assertThat(validator.getErrors(), empty());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void naoDeveriaLogarQuandoUsuarioNaoExistir() {
		when(usuariosService.contains(usuario)).thenReturn(false);
		controller.login(usuario);
		
		assertThat((List<Message>)result.included().get("errors"), not(empty()));
	}

}
