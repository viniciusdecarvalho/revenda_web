package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.model.Aquisicao.Combustivel;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.model.Contato;
import br.edu.ftlf.ads.revenda.model.Endereco;
import br.edu.ftlf.ads.revenda.model.Enums;
import br.edu.ftlf.ads.revenda.model.Enums.SituacaoVenda;
import br.edu.ftlf.ads.revenda.model.Enums.TipoPagamento;
import br.edu.ftlf.ads.revenda.model.FormaPagamento;
import br.edu.ftlf.ads.revenda.model.Funcionario;
import br.edu.ftlf.ads.revenda.model.Pagamento;
import br.edu.ftlf.ads.revenda.model.Veiculo;
import br.edu.ftlf.ads.revenda.model.Venda;
import br.edu.ftlf.ads.revenda.webservice.AquisicaoDto;
import br.edu.ftlf.ads.revenda.webservice.ClienteDto;
import br.edu.ftlf.ads.revenda.webservice.FormaPagamentoDto;
import br.edu.ftlf.ads.revenda.webservice.FuncionarioDto;
import br.edu.ftlf.ads.revenda.webservice.PagamentoDto;
import br.edu.ftlf.ads.revenda.webservice.SituacaoAquisicao;
import br.edu.ftlf.ads.revenda.webservice.VeiculoDto;
import br.edu.ftlf.ads.revenda.webservice.VendaDto;

public class DtoParser {

	private DtoParser() {} 
	
	static Cliente parse(ClienteDto dto) {
		Cliente cliente = new Cliente();
		if (dto != null) {
			cliente.setId(dto.getId());
			cliente.setAtivo(dto.isAtivo());
			cliente.setRazaoSocial(dto.getRazaoSocial());
			cliente.setCpfCnpj(dto.getCpfCnpj());
			
			Endereco endereco = new Endereco();
			endereco.setLogradouro(dto.getLogradouro());
			endereco.setCep(dto.getCep());
			endereco.setCidade(dto.getCidade());
			endereco.setEstado(dto.getEstado());
			endereco.setComplemento(dto.getComplemento());
			cliente.setEndereco(endereco);
			
			Contato contato = new Contato();
			contato.setEmail(dto.getEmail());
			contato.setFone(dto.getFone());
			contato.setCelular(dto.getCelular());
			cliente.setContato(contato);
			
		}
		return cliente;
	}
	
	static ClienteDto from(Cliente cliente) {
		ClienteDto dto = new ClienteDto();
		dto.setId(cliente.getId());
		dto.setAtivo(cliente.isAtivo());
		dto.setCpfCnpj(cliente.getCpfCnpj());
		dto.setRazaoSocial(cliente.getRazaoSocial());
		
		Endereco endereco = cliente.getEndereco();
		if (endereco != null) {
			dto.setCep(endereco.getCep());
			dto.setLogradouro(endereco.getLogradouro());
			dto.setEstado(endereco.getEstado());
			dto.setCidade(endereco.getCidade());
			dto.setComplemento(endereco.getComplemento());
		}
		Contato contato = cliente.getContato();
		if (contato != null) {
			dto.setFone(contato.getFone());
			dto.setCelular(contato.getCelular());
			dto.setEmail(contato.getEmail());
		}
		return dto;
	}
	
	static Aquisicao parse(AquisicaoDto dto) {
		Aquisicao aquisicao = new Aquisicao();
		aquisicao.setCidade(dto.getCidade());
		aquisicao.setCliente(parse(dto.getCliente()));
		aquisicao.setCombustivel(Combustivel.valueOf(dto.getCombustivel().toString()));
		aquisicao.setCor(dto.getCor());
		Date data = getDate(dto.getData());
		aquisicao.setData(data);
		aquisicao.setFuncionario(parse(dto.getFuncionario()));
		aquisicao.setId(dto.getId());
		aquisicao.setKm(dto.getKm());
		aquisicao.setObs(dto.getObs());
		aquisicao.setSituacao(Enums.SituacaoAquisicao.valueOf(dto.getSituacao().toString()));
		aquisicao.setUf(dto.getUf());
		aquisicao.setValor(dto.getValor());
		aquisicao.setValorComissao(dto.getValorComissao());
		aquisicao.setValorPedido(dto.getValorPedido());
		aquisicao.setVeiculo(parse(dto.getVeiculo()));
		dto.getPagamentos().forEach(p -> aquisicao.addPagamento(parse(p)));
		return aquisicao;
	}
	
	static Date getDate(XMLGregorianCalendar data) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, data.getDay());
		calendar.set(Calendar.MONTH, data.getMonth());
		calendar.set(Calendar.YEAR, data.getYear());
		Date datta2 = calendar.getTime();
		return datta2;
	}
	
	static XMLGregorianCalendar getXMLDate(Date data) {		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(data);
		return new XMLGregorianCalendarImpl(calendar);
	}
	
	static Funcionario parse(FuncionarioDto dto) {
		Funcionario funcionario = new Funcionario();
		funcionario.setId(dto.getId());
		funcionario.setAtivo(dto.isAtivo());
		funcionario.setGerente(dto.isGerente());
		funcionario.setNormal(dto.isUsuario());
		funcionario.setVendedor(dto.isVendedor());
		funcionario.setNome(dto.getNome());
		funcionario.setCpf(dto.getCpf());
		return funcionario;
	}

	static Veiculo parse(VeiculoDto dto) {
		Veiculo veiculo = new Veiculo();
		veiculo.setAno(dto.getAno());
		veiculo.setChassi(dto.getChassi());
		veiculo.setEspecie(dto.getEspecie());
		veiculo.setId(dto.getId());
		veiculo.setMarca(dto.getMarca());
		veiculo.setModelo(dto.getModelo());
		veiculo.setPlaca(dto.getPlaca());
		veiculo.setRenavan(dto.getRenavan());
		return veiculo;
	}
	
	static Pagamento parse(PagamentoDto dto) {
		Pagamento pagamento = new Pagamento();
		pagamento.setDescricao(dto.getDescricao());
		pagamento.setFormaPagamento(parse(dto.getFormaspagamento()));
		pagamento.setId(dto.getId());
		pagamento.setTipo(TipoPagamento.valueOf(dto.getTipo()));
		pagamento.setValor(dto.getValor());
		return pagamento;
	}

	static FuncionarioDto from(Funcionario funcionario) {
		return new FuncionarioDto() {{
			setId(funcionario.getId());
			setNome(funcionario.getNome());
			setCpf(funcionario.getCpf());
			setAtivo(funcionario.isAtivo());
			setGerente(funcionario.isGerente());
			setVendedor(funcionario.isVendedor());
			setUsuario(funcionario.isNormal());
		}};
	}

	static VeiculoDto from(Veiculo veiculo) {
		VeiculoDto dto = new VeiculoDto();
		dto.setAno(veiculo.getAno());
		dto.setChassi(veiculo.getChassi());
		dto.setEspecie(veiculo.getEspecie());
		dto.setId(veiculo.getId());
		dto.setMarca(veiculo.getMarca());
		dto.setModelo(veiculo.getModelo());
		dto.setPlaca(veiculo.getPlaca());
		dto.setRenavan(veiculo.getRenavan());
		return dto;
	}
	
	static PagamentoDto from(Pagamento pagamento) {
		PagamentoDto dto = new PagamentoDto();
		dto.setDescricao(pagamento.getDescricao());
		dto.setFormaspagamento(from(pagamento.getFormaPagamento()));
		dto.setId(pagamento.getId());
		dto.setTipo(pagamento.getTipo().toString());
		dto.setValor(pagamento.getValor());
		return dto;
	}

	static AquisicaoDto from(Aquisicao aquisicao) {
		AquisicaoDto dto = new AquisicaoDto();
		dto.setCidade(aquisicao.getCidade());
		dto.setCliente(from(aquisicao.getCliente()));
		dto.setCombustivel(aquisicao.getCombustivel().toString());
		dto.setCor(aquisicao.getCor());
		dto.setData(getXMLDate(aquisicao.getData()));
		dto.setFuncionario(from(aquisicao.getFuncionario()));
		dto.setId(aquisicao.getId());
		dto.setKm((int) aquisicao.getKm());
		dto.setObs(aquisicao.getObs());
		dto.setSituacao(SituacaoAquisicao.valueOf(aquisicao.getSituacao().toString()));
		dto.setValor(aquisicao.getValor());
		dto.setUf(aquisicao.getUf());
		dto.setValorComissao(aquisicao.getValorComissao());
		dto.setValorPedido(aquisicao.getValorPedido());
		dto.setVeiculo(from(aquisicao.getVeiculo()));
		return dto;
	}
	
	static FormaPagamento parse(FormaPagamentoDto dto) {
		FormaPagamento fp = new FormaPagamento();
		fp.setId(dto.getId());
		fp.setAtivo(dto.isAtivo());
		fp.setCredito(dto.isCredito());
		fp.setDebito(dto.isDebito());
		fp.setNome(dto.getNome());
		return fp;
	}
	
	static FormaPagamentoDto from(FormaPagamento formaPagamento) {
		FormaPagamentoDto dto = new FormaPagamentoDto();
		dto.setAtivo(formaPagamento.isAtivo());
		dto.setCredito(formaPagamento.isCredito());
		dto.setDebito(formaPagamento.isDebito());
		dto.setId(formaPagamento.getId());
		dto.setNome(formaPagamento.getNome());
		return dto;
	}

	static Venda parse(VendaDto dto) {
		Venda venda = new Venda();
		venda.setAquisicao(parse(dto.getAquisicao()));
		venda.setCliente(parse(dto.getCliente()));
		venda.setData(getDate(dto.getData()));
		venda.setFuncionario(parse(dto.getVendedor()));
		venda.setId(dto.getId());
		venda.setObs(dto.getObs());
		venda.setSituacao(SituacaoVenda.OK);
		venda.setValor(dto.getValor());
		venda.setValorComissao(dto.getValorComissao());
		dto.getPagamentos().forEach(p -> venda.addPagamento(parse(p)));
		return null;
	}

	static VendaDto from(Venda venda) {
		VendaDto dto = new VendaDto();
		dto.setAquisicao(from(venda.getAquisicao()));
		dto.setCliente(from(venda.getCliente()));
		dto.setData(getXMLDate(venda.getData()));
		dto.setId(venda.getId());
		dto.setObs(venda.getObs());
		dto.setValor(venda.getValor());
		dto.setValorComissao(venda.getValorComissao());
		dto.setVendedor(from(venda.getFuncionario()));
		return dto;
	}
	
}
