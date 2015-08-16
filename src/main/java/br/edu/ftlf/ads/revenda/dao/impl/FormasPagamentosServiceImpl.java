package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.FormasPagamentosDao;
import br.edu.ftlf.ads.revenda.model.FormaPagamento;
import br.edu.ftlf.ads.revenda.webservice.FormaPagamentoDto;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

@RequestScoped
public class FormasPagamentosServiceImpl implements FormasPagamentosDao {

	private RevendaServices services;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected FormasPagamentosServiceImpl() {
		this(null);
	}

	@Inject
	public FormasPagamentosServiceImpl(RevendaServices services) {
		this.services = services;
	}

	@Override
	public List<FormaPagamento> list() {
		return services.listaFormasPagamentos().stream()
						.map(DtoParser::parse).collect(Collectors.toList());
	}

	@Override
	public FormaPagamento find(Integer id) {
		FormaPagamentoDto pagamentoDto = services.consultaFormaPagamento(id);
		return DtoParser.parse(pagamentoDto);
	}

	@Override
	public void save(FormaPagamento formaPagamento) {
		FormaPagamentoDto dto = DtoParser.from(formaPagamento);
		services.salvaFormaPagamento(new Holder<FormaPagamentoDto>(dto));
	}

	@Override
	public void delete(FormaPagamento formaPagamento) {
		services.deletaFormaPagamento(formaPagamento.getId());
	}
	
}
