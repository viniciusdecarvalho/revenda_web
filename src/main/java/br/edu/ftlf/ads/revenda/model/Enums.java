package br.edu.ftlf.ads.revenda.model;

public class Enums {

	public enum SituacaoAquisicao { 
		OK, 
		CANCELADO 
	}

	public enum Permissao {USUARIO, VENDEDOR, GERENTE}

	public enum TipoGasto {AQUISICAO, DESPESA, VENDA}

	public enum SituacaoGasto {
		ABERTO, PAGO, CANCELADO
	}

	public enum TipoPagamento {
		DEBITO, CREDITO
	}

	public enum SituacaoVenda { OK, CANCELADO }

}
