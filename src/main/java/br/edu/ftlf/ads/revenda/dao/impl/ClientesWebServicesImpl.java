package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.ClientesDao;
import br.edu.ftlf.ads.revenda.model.Cliente;
import br.edu.ftlf.ads.revenda.webservice.ClienteDto;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

@RequestScoped
public class ClientesWebServicesImpl implements ClientesDao {

	private RevendaServices services;

	/**
	 * @deprecated cdi eyes only
	 */
	protected ClientesWebServicesImpl() {
		this(null);
	}
	
	@Inject
	public ClientesWebServicesImpl( RevendaServices services ) {
		this.services = services;
	}

	@Override
	public List<Cliente> list() {
		return services.listaClientes().stream()
									   .map(d -> DtoParser.parse(d))
									   .collect(Collectors.toList());
	}

	@Override
	public Cliente find(Integer id) {
		ClienteDto dto = services.consultaCliente(id);
		return DtoParser.parse(dto);
	}

	@Override
	public void save(Cliente cliente) {
		ClienteDto dto = DtoParser.from(cliente);
		services.salvaCliente(new Holder<ClienteDto>(dto));
	}

	@Override
	public void delete(Cliente cliente) {
		services.deletaCliente(cliente.getId());
	}
	
}