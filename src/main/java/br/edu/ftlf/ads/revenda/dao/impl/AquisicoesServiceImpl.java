package br.edu.ftlf.ads.revenda.dao.impl;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.ws.Holder;

import br.edu.ftlf.ads.revenda.dao.AquisicoesDao;
import br.edu.ftlf.ads.revenda.model.Aquisicao;
import br.edu.ftlf.ads.revenda.webservice.AquisicaoDto;
import br.edu.ftlf.ads.revenda.webservice.PagamentoDto;
import br.edu.ftlf.ads.revenda.webservice.SituacaoAquisicao;
import br.edu.ftlf.ads.revenda.webservice.impl.RevendaServices;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

@RequestScoped
public class AquisicoesServiceImpl implements AquisicoesDao {

	private RevendaServices services;
	
	/**
	 * @deprecated cdi eyes only
	 */
	protected AquisicoesServiceImpl() {
		this(null);
	}

	@Inject
	public AquisicoesServiceImpl(RevendaServices services) {
		this.services = services;
	}

	@Override
	public List<Aquisicao> list() {
		return services.listaAquisicoes().stream()
										.map(DtoParser::parse)
										.collect(Collectors.toList());
	}

	@Override
	public Aquisicao find(Integer id) {
		AquisicaoDto aquisicaoDto = services.consultaAquisicao(id);
		return DtoParser.parse(aquisicaoDto);
	}

	@Override
	public void save(Aquisicao aquisicao) {
		AquisicaoDto dto = new AquisicaoDto();
		dto.setCidade(aquisicao.getCidade());
		dto.setCliente(DtoParser.from(aquisicao.getCliente()));
		dto.setCombustivel(aquisicao.getCombustivel().toString());
		dto.setCor(aquisicao.getCor());
		GregorianCalendar data = new GregorianCalendar();
		data.setTime(aquisicao.getData());
		dto.setData(new XMLGregorianCalendarImpl(data));
		dto.setFuncionario(DtoParser.from(aquisicao.getFuncionario()));
		dto.setId(aquisicao.getId());
		dto.setKm((int) aquisicao.getKm());
		dto.setObs(aquisicao.getObs());
		dto.setSituacao(SituacaoAquisicao.valueOf(aquisicao.getSituacao().toString()));
		dto.setUf(aquisicao.getUf());
		dto.setValor(aquisicao.getValor());
		dto.setValorComissao(aquisicao.getValorComissao());
		dto.setValorPedido(aquisicao.getValorPedido());
		dto.setVeiculo(DtoParser.from(aquisicao.getVeiculo()));
		List<PagamentoDto> pagamentos = aquisicao.getPagamentos().stream().map(p -> DtoParser.from(p)).collect(Collectors.toList());
		dto.getPagamentos().addAll(pagamentos);
		services.salvaAquisicao(new Holder<AquisicaoDto>(dto));
	}

	@Override
	public void delete(Aquisicao aquisicao) {
		services.cancelaAquisicao(DtoParser.from(aquisicao));
	}
	
}
