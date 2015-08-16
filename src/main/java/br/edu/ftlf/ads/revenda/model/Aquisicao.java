package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.edu.ftlf.ads.revenda.model.Enums.SituacaoAquisicao;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class Aquisicao extends Model {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_DATA = "data";

	public enum Combustivel { GASOLINA, ALCOOL, DIESEL, FLEX, GAS_NATURAL }
	
	@NotNull
	private String cidade;

	@NotNull
	private Combustivel combustivel;

	@NotNull
	private String cor;

	@NotNull
	private Date data;

	@Min(0)
	private long km;

	private String obs;

	@NotEmpty
	private String uf;

	@NotNull
	@Min(0)
	private BigDecimal valor;
	
	@NotNull
	@Min(0)
	private BigDecimal valorComissao;

	@NotNull
	@Min(0)
	private BigDecimal valorPedido;

	@NotNull
	private Cliente cliente;

	@NotNull
	private Funcionario funcionario;

	@NotNull
	private Veiculo veiculo;

	@NotEmpty
	private List<Pagamento> pagamentos;

	private List<Gasto> gastos;

	private SituacaoAquisicao situacao;

	public Aquisicao() {
		pagamentos = Lists.newArrayList();
		gastos = Lists.newArrayList();
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Combustivel getCombustivel() {
		return this.combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public long getKm() {
		return this.km;
	}

	public void setKm(long km) {
		this.km = km;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorComissao() {
		return this.valorComissao;
	}

	public void setValorComissao(BigDecimal valorComissao) {
		this.valorComissao = valorComissao;
	}

	public BigDecimal getValorPedido() {
		return this.valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}
	
	public BigDecimal getTotalPagamentos() {
		if (getPagamentos().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return getPagamentos().stream().map(Pagamento::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public BigDecimal getTotalGastos() {
		if (getGastos().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return getGastos().stream().map(Gasto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	public BigDecimal getCustoTotal() {
		return getTotalPagamentos().add(getTotalGastos());
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return this.veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public SituacaoAquisicao getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoAquisicao situacao) {
		this.situacao = situacao;
	}

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setAquisicao(this);

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setAquisicao(null);

		return pagamento;
	}
	
	public List<Gasto> getGastos() {
		return gastos;
	}
	
	public void setGastos(List<Gasto> gastos) {
		this.gastos = gastos;
	}
	
	public Gasto addGasto(Gasto gasto) {
		getGastos().add(gasto);
		gasto.setAquisicao(this);

		return gasto;
	}

	public Gasto removeGasto(Gasto gasto) {
		getGastos().remove(gasto);
		gasto.setAquisicao(null);

		return gasto;
	}
	
	public void cancelar() {
		situacao = Enums.SituacaoAquisicao.CANCELADO;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("veiculo", veiculo)
				.add("uf", uf)
				.add("cidade", cidade)
				.add("cor", cor)
				.add("combustivel", combustivel)
				.add("km", km)
				.add("cliente", cliente)
				.add("vendedor", funcionario)
				.add("valorComissao", valorComissao)
				.add("data", data)
				.add("valor", valor)
				.add("valorPedido", valorPedido)
				.add("obs", obs)
				.add("pagamentos", pagamentos)
				.add("situacao", situacao).omitNullValues().toString();
	}

	
}