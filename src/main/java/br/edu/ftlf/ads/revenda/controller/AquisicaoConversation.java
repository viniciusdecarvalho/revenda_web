package br.edu.ftlf.ads.revenda.controller;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;

import br.edu.ftlf.ads.revenda.model.Aquisicao;

@ConversationScoped
public class AquisicaoConversation implements Serializable {

	private static final long serialVersionUID = 8931139070936694408L;
	
	private Aquisicao aquisicao;
	
	public Aquisicao getAquisicao() {
		return aquisicao;
	}
	
	public void beginConversation(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}
	
}
