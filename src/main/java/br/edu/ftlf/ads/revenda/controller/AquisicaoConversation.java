package br.edu.ftlf.ads.revenda.controller;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;

import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.view.ClienteModelView;
import br.edu.ftlf.ads.revenda.view.CompraModelView;
import br.edu.ftlf.ads.revenda.view.VeiculoModelView;

@ConversationScoped
public class AquisicaoConversation implements Serializable {

	private static final long serialVersionUID = 8931139070936694408L;

	private Aquisicao aquisicao;

	private VeiculoModelView veiculo;
	private ClienteModelView cliente;
	private CompraModelView compra;

	public void fill(VeiculoModelView modelView) {
		aquisicao.setVeiculo(modelView.getVeiculo());
		aquisicao.setUf(modelView.getUf());
		aquisicao.setCidade(modelView.getCidade());
		aquisicao.setCor(modelView.getCor());
		aquisicao.setCombustivel(modelView.getCombustivel());
		aquisicao.setKm(modelView.getKm());
	}

	public void fill(ClienteModelView modelView) {
		aquisicao.setCliente(modelView.getCliente());
		aquisicao.setFuncionario(modelView.getVendedor());
		aquisicao.setValorComissao(modelView.getValorComissao());
	}

	public void fill(CompraModelView compra) {
		aquisicao.setData(compra.getData());
		aquisicao.setValor(compra.getValor());
		aquisicao.setValorPedido(compra.getValorPedido());
	}
	
	public Aquisicao getAquisicao() {
		return aquisicao;
	}

	public void beginConversation(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public VeiculoModelView getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoModelView veiculo) {
		this.veiculo = veiculo;
		fill(veiculo);
	}

	public ClienteModelView getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModelView cliente) {
		this.cliente = cliente;
		fill(cliente);
	}

	public CompraModelView getCompra() {
		return compra;
	}

	public void setCompra(CompraModelView compra) {
		this.compra = compra;
		fill(compra);
	}

}
