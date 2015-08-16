package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.FornecedoresDao;
import br.edu.ftlf.ads.revenda.model.Fornecedor;
import br.edu.ftlf.ads.revenda.webservice.FornecedorDto;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

@RequestScoped
public class FornecedoresServiceImpl implements FornecedoresDao {

	private RevendaServices services;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected FornecedoresServiceImpl() {
		this(null);
	}

	@Inject
	public FornecedoresServiceImpl(RevendaServices services) {
		this.services = services;
	}

	@Override
	public List<Fornecedor> list() {
		return services.listarFornecedores().stream()
					   .map(d -> parseDto(d)).collect(Collectors.toList());
	}

	private Fornecedor parseDto(FornecedorDto dto) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setAtivo(dto.isAtivo());
		fornecedor.setCpfCnpj(dto.getCpfCnpj());
		fornecedor.setId(dto.getId());
		fornecedor.setRazaoSocial(dto.getRazaoSocial());
		return fornecedor;
	}

	@Override
	public Fornecedor find(Integer id) {
		FornecedorDto fornecedorDto = services.consultaFornecedor(id);
		return parseDto(fornecedorDto);
	}

	@Override
	public void save(Fornecedor fornecedor) {
		FornecedorDto dto = new FornecedorDto();
		dto.setCpfCnpj(fornecedor.getCpfCnpj());
		dto.setId(fornecedor.getId());
		dto.setAtivo(fornecedor.isAtivo());
		dto.setRazaoSocial(fornecedor.getRazaoSocial());
		services.salvarFornecedor(new Holder<FornecedorDto>(dto));
	}

	@Override
	public void delete(Fornecedor fornecedor) { 
		services.deletarFornecedor(fornecedor.getId());
	}
	
}