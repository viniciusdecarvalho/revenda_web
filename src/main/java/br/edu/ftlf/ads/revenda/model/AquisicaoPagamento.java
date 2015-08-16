package br.edu.ftlf.ads.revenda.model;

public class AquisicaoPagamento extends Model {
	private static final long serialVersionUID = 1L;

	private Aquisicao aquisicao;

	private Pagamento pagamento;

	public AquisicaoPagamento() {
	}

	public AquisicaoPagamento(Aquisicao aquisicao, Pagamento pagamento) {
		setAquisicao(aquisicao);
		setPagamento(pagamento);
	}

	public Aquisicao getAquisicao() {
		return this.aquisicao;
	}

	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}

	public Pagamento getPagamento() {
		return this.pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

}