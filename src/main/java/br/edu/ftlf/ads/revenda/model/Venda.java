package br.edu.ftlf.ads.revenda.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.google.common.collect.Lists;

import br.edu.ftlf.ads.revenda.model.Enums.SituacaoVenda;
import br.edu.ftlf.ads.revenda.model.Enums.TipoGasto;

public class Venda extends Model {
	private static final long serialVersionUID = 1L;


	@NotNull
	@Future
	private Date data;
	
	private String obs;
	
	@NotNull
	@Min(0)
	private BigDecimal valor;
	
	@Min(0)
	private BigDecimal valorComissao;
	
	@NotNull
	private Aquisicao aquisicao;
	
	@NotNull
	private Cliente cliente;
	
	@NotNull
	private Funcionario funcionario;
	
	private SituacaoVenda situacao;
	
	private List<Pagamento> pagamentos;
	
	public Venda() {
		pagamentos = Lists.newArrayList();
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
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

	public Aquisicao getAquisicao() {
		return aquisicao;
	}
	
	public void setAquisicao(Aquisicao aquisicao) {
		this.aquisicao = aquisicao;
	}
	
	public SituacaoVenda getSituacao() {
		return situacao;
	}
	
	public void setSituacao(SituacaoVenda situacao) {
		this.situacao = situacao;
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

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public Pagamento addPagamento(Pagamento pagamento) {
		getPagamentos().add(pagamento);
		pagamento.setAquisicao(this.getAquisicao());

		return pagamento;
	}

	public Pagamento removePagamento(Pagamento pagamento) {
		getPagamentos().remove(pagamento);
		pagamento.setAquisicao(null);

		return pagamento;
	}

	public BigDecimal getLucro() {
		BigDecimal valorCompra = aquisicao.getValor();
		BigDecimal valorGastos = aquisicao.getGastos().stream().map(Gasto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
		BigDecimal valorVenda = getValor();
		return valorVenda.subtract(valorCompra.add(valorGastos));
	}
	
	public void cancelar() {
		situacao = Enums.SituacaoVenda.CANCELADO;
		getAquisicao().getGastos().forEach(g -> {
			if (TipoGasto.VENDA.equals(g.getSituacao())) {
				g.cancelar();
			}
		});
	}

	public BigDecimal getCustoTotal() {
		return getPagamentos().stream().map(Pagamento::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}