package br.edu.ftlf.ads.revenda.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the veiculos database table.
 * 
 */
@Entity
@Table(name="veiculos")
public class Veiculo extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_MARCA = "marca";
	public static final String PROPERTY_MODELO = "modelo";
	public static final String PROPERTY_ANO = "ano";

	@NotEmpty
	@Column(nullable=false)
	private String ano;

	@NotEmpty
	@Column(nullable=false)
	private String chassi;

	@NotEmpty
	@Column(nullable=false)
	private String especie;

	@NotEmpty
	@Column(nullable=false)
	private String marca;

	@NotEmpty
	@Column(nullable=false)
	private String modelo;

	@NotEmpty
	@Column(nullable=false)
	private String placa;

	@NotEmpty
	@Column(nullable=false)
	private String renavan;

	@OneToMany(mappedBy="veiculo")
	private List<Aquisicao> aquisicoes;

	public Veiculo() {
	}

	public Veiculo(Integer id) {
		setId(id);
	}

	public String getAno() {
		return this.ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getChassi() {
		return this.chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavan() {
		return this.renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public List<Aquisicao> getAquisicoes() {
		return this.aquisicoes;
	}

	public void setAquisicoes(List<Aquisicao> aquisicoes) {
		this.aquisicoes = aquisicoes;
	}

	public Aquisicao addAquisicao(Aquisicao aquisicao) {
		getAquisicoes().add(aquisicao);
		aquisicao.setVeiculo(this);

		return aquisicao;
	}

	public Aquisicao removeAquisicoe(Aquisicao aquisicao) {
		getAquisicoes().remove(aquisicao);
		aquisicao.setVeiculo(null);

		return aquisicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result
				+ ((aquisicoes == null) ? 0 : aquisicoes.hashCode());
		result = prime * result + ((chassi == null) ? 0 : chassi.hashCode());
		result = prime * result + ((especie == null) ? 0 : especie.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((renavan == null) ? 0 : renavan.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s %s", marca, modelo, ano, placa);
	}

	
}