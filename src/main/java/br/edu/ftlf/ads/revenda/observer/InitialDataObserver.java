package br.edu.ftlf.ads.revenda.observer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

import br.com.caelum.vraptor.events.VRaptorInitialized;

@Dependent
public class InitialDataObserver {
	
	public void insert(@Observes VRaptorInitialized event) {
		
	}

}