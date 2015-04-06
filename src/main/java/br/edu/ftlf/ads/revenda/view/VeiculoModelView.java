package br.edu.ftlf.ads.revenda.view;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Veiculo;

public class VeiculoModelView {

	@NotNull
	private Veiculo veiculo;
	
	@NotEmpty
	private String uf;
	
	@NotEmpty
	private String cidade;
	
	@NotEmpty
	private String cor;
	
	@NotNull
	private Combustivel combustivel;
	
	@NotNull
	private Long km;	
	
	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public Long getKm() {
		return km;
	}

	public void setKm(Long km) {
		this.km = km;
	}
	
}
