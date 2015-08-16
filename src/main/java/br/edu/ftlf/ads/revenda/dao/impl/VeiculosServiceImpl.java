package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.VeiculosDao;
import br.edu.ftlf.ads.revenda.model.Veiculo;
import br.edu.ftlf.ads.revenda.webservice.VeiculoDto;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

@RequestScoped
public class VeiculosServiceImpl implements VeiculosDao {

	private RevendaServices services;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected VeiculosServiceImpl() {
		this(null);
	}

	@Inject
	public VeiculosServiceImpl(RevendaServices services) {
		this.services = services;
	}

	@Override
	public List<Veiculo> list() {
		return services.listaVeiculos().stream().map(d -> DtoParser.parse(d)).collect(Collectors.toList());
	}

	@Override
	public Veiculo find(Integer id) {
		VeiculoDto dto = services.consultaVeiculo(id);
		return DtoParser.parse(dto);
	}

	@Override
	public void save(Veiculo veiculo) {
		VeiculoDto dto = DtoParser.from(veiculo);
		services.salvaVeiculo(new Holder<VeiculoDto>(dto));
	}

	@Override
	public void delete(Veiculo veiculo) {
		services.deletaVeiculo(veiculo.getId());
	}

	@Override
	public List<Veiculo> stock() {
		return services.listaVeiculosEmEstoque().stream().map(d -> DtoParser.parse(d)).collect(Collectors.toList());
	}
	
}
