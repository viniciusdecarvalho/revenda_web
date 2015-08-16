package br.edu.ftlf.ads.revenda.model;

import java.io.Serializable;

public class VendaPagamento extends Model implements Serializable {
	private static final long serialVersionUID = 1L;

	private Venda venda;

	private Pagamento pagamento;

	public VendaPagamento() {
	}

	public VendaPagamento(Venda venda, Pagamento pagamento) {
		setVenda(venda);
		setPagamento(pagamento);
	}

	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Pagamento getPagamento() {
		return this.pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}