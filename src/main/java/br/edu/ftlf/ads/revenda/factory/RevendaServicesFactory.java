package br.edu.ftlf.ads.revenda.factory;

import java.io.IOException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.caelum.vraptor.environment.Environment;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices_Service;

@Dependent
public class RevendaServicesFactory {

	private Environment environment;
	private RevendaServices_Service service;

	@Inject
	public RevendaServicesFactory(Environment environment) {
		this.environment = environment;
	}
	
	@PostConstruct
	private void init() {
		try {
			URL url = new URL(environment.get("wsdl"));
			url.openConnection().connect();
			service = new RevendaServices_Service(url);
		} catch (IOException  e) {
			throw new RuntimeException(e);
		} 
	}
	
	@Produces
	@Dependent
	public RevendaServices_Service getService() {
		return service;
	}
	
	@Produces
	@Dependent
	public RevendaServices getRevendaServicesPort() {
		return service.getRevendaServicesPort();
	}
	
}
