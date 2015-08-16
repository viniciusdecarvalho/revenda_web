package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.VendasDao;
import br.edu.ftlf.ads.revenda.model.Venda;
import br.edu.ftlf.ads.revenda.webservice.VendaDto;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

@RequestScoped
public class VendasServiceImpl implements VendasDao {

	private RevendaServices services;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected VendasServiceImpl() {
		this(null);
	}

	@Inject
	public VendasServiceImpl(RevendaServices services) {
		this.services = services;
	}

	@Override
	public List<Venda> list() {
		return services.listaVendas().stream()
										.map(DtoParser::parse)
										.collect(Collectors.toList());
	}

	@Override
	public Venda find(Integer id) {
		VendaDto vendaDto = services.consultaVenda(id);
		return DtoParser.parse(vendaDto);
	}

	@Override
	public void save(Venda venda) {
		VendaDto dto = new VendaDto();
		services.salvaVenda(new Holder<VendaDto>(dto));
	}

	@Override
	public void delete(Venda venda) {
		services.cancelaVenda(DtoParser.from(venda));
	}
	
}
