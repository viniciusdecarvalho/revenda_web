package br.edu.ftlf.ads.revenda.interceptor;

import java.util.Arrays;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.BindingProvider;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.edu.ftlf.ads.revenda.controller.HomeController;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

/**
 * Interceptor to check if the user is in the session.
 */
@Intercepts
@RequestScoped
public class AutenticationInterceptor {

	private Result result;
	
	/**
	 * @deprecated cdi eyes only
	 */
	public AutenticationInterceptor() {}
	
	@Inject
	public AutenticationInterceptor(Result result) {
		this.result = result;
	}
	
	@Accepts
	public boolean accepts(ControllerMethod method) {
		return !method.containsAnnotation(Public.class);
	}

	/**
	 * Intercepts the request and checks if there is a user logged in.
	 */
	@AroundCall
	public void intercept(SimpleInterceptorStack stack, RevendaServices service, UserInfo info) {
		
		if (info.isLogged()) {
			BindingProvider provider = (BindingProvider)service;
			Map<String, Object> requestContext = provider.getRequestContext();
			requestContext.put(BindingProvider.USERNAME_PROPERTY, info.getUsuario().getLogin());
			requestContext.put(BindingProvider.PASSWORD_PROPERTY, info.getUsuario().getSenha());
			stack.next();
		} else {
			result.include("errors", Arrays.asList(notLoggedMessage()));
			result.redirectTo(HomeController.class).login();
		}
	}
	
	private Message notLoggedMessage() {
		return new SimpleMessage("usuario", "usuario nao logado");
	}

}
