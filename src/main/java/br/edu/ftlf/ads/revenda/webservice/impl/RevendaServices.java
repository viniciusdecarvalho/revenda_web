
package br.edu.ftlf.ads.revenda.webservice.impl;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import br.edu.ftlf.ads.revenda.webservice.AquisicaoDto;
import br.edu.ftlf.ads.revenda.webservice.ClienteDto;
import br.edu.ftlf.ads.revenda.webservice.FormaPagamentoDto;
import br.edu.ftlf.ads.revenda.webservice.FornecedorDto;
import br.edu.ftlf.ads.revenda.webservice.FuncionarioDto;
import br.edu.ftlf.ads.revenda.webservice.GastoDto;
import br.edu.ftlf.ads.revenda.webservice.ObjectFactory;
import br.edu.ftlf.ads.revenda.webservice.Usuario;
import br.edu.ftlf.ads.revenda.webservice.VeiculoDto;
import br.edu.ftlf.ads.revenda.webservice.VendaDto;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RevendaServices", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RevendaServices {


    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.AquisicaoDto>
     */
    @WebMethod
    @WebResult(name = "aquisicao", targetNamespace = "")
    @RequestWrapper(localName = "listaAquisicoes", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaAquisicoes")
    @ResponseWrapper(localName = "listaAquisicoesResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaAquisicoesResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaAquisicoesRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaAquisicoesResponse")
    public List<AquisicaoDto> listaAquisicoes();

    /**
     * 
     * @param aquisicao
     */
    @WebMethod
    @RequestWrapper(localName = "cancelaAquisicao", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.CancelaAquisicao")
    @ResponseWrapper(localName = "cancelaAquisicaoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.CancelaAquisicaoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/cancelaAquisicaoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/cancelaAquisicaoResponse")
    public void cancelaAquisicao(
        @WebParam(name = "aquisicao", targetNamespace = "")
        AquisicaoDto aquisicao);

    /**
     * 
     * @param aquisicao
     */
    @WebMethod
    @RequestWrapper(localName = "salvaAquisicao", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaAquisicao")
    @ResponseWrapper(localName = "salvaAquisicaoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaAquisicaoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaAquisicaoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaAquisicaoResponse")
    public void salvaAquisicao(
        @WebParam(name = "aquisicao", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<AquisicaoDto> aquisicao);

    /**
     * 
     * @param cliente
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.AquisicaoDto>
     */
    @WebMethod
    @WebResult(name = "aquisicao", targetNamespace = "")
    @RequestWrapper(localName = "consultaAquisicoesPorCliente", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaAquisicoesPorCliente")
    @ResponseWrapper(localName = "consultaAquisicoesPorClienteResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaAquisicoesPorClienteResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaAquisicoesPorClienteRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaAquisicoesPorClienteResponse")
    public List<AquisicaoDto> consultaAquisicoesPorCliente(
        @WebParam(name = "cliente", targetNamespace = "")
        ClienteDto cliente);

    /**
     * 
     * @param dataInicial
     * @param dataFinal
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.AquisicaoDto>
     */
    @WebMethod
    @WebResult(name = "aquisicao", targetNamespace = "")
    @RequestWrapper(localName = "listaAquisicoesPorData", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaAquisicoesPorData")
    @ResponseWrapper(localName = "listaAquisicoesPorDataResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaAquisicoesPorDataResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaAquisicoesPorDataRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaAquisicoesPorDataResponse")
    public List<AquisicaoDto> listaAquisicoesPorData(
        @WebParam(name = "dataInicial", targetNamespace = "")
        XMLGregorianCalendar dataInicial,
        @WebParam(name = "dataFinal", targetNamespace = "")
        XMLGregorianCalendar dataFinal);

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.AquisicaoDto
     */
    @WebMethod
    @WebResult(name = "aquisicao", targetNamespace = "")
    @RequestWrapper(localName = "consultaAquisicao", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaAquisicao")
    @ResponseWrapper(localName = "consultaAquisicaoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaAquisicaoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaAquisicaoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaAquisicaoResponse")
    public AquisicaoDto consultaAquisicao(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.ClienteDto
     */
    @WebMethod
    @WebResult(name = "cliente", targetNamespace = "")
    @RequestWrapper(localName = "consultaCliente", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaCliente")
    @ResponseWrapper(localName = "consultaClienteResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaClienteResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaClienteRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaClienteResponse")
    public ClienteDto consultaCliente(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deletaCliente", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaCliente")
    @ResponseWrapper(localName = "deletaClienteResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaClienteResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaClienteRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaClienteResponse")
    public void deletaCliente(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.ClienteDto>
     */
    @WebMethod
    @WebResult(name = "cliente", targetNamespace = "")
    @RequestWrapper(localName = "listaClientes", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaClientes")
    @ResponseWrapper(localName = "listaClientesResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaClientesResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaClientesRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaClientesResponse")
    public List<ClienteDto> listaClientes();

    /**
     * 
     * @param cliente
     */
    @WebMethod
    @RequestWrapper(localName = "salvaCliente", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaCliente")
    @ResponseWrapper(localName = "salvaClienteResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaClienteResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaClienteRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaClienteResponse")
    public void salvaCliente(
        @WebParam(name = "cliente", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<ClienteDto> cliente);

    /**
     * 
     * @param formaPagamento
     */
    @WebMethod
    @RequestWrapper(localName = "salvaFormaPagamento", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaFormaPagamento")
    @ResponseWrapper(localName = "salvaFormaPagamentoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaFormaPagamentoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaFormaPagamentoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaFormaPagamentoResponse")
    public void salvaFormaPagamento(
        @WebParam(name = "formaPagamento", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<FormaPagamentoDto> formaPagamento);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deletaFormaPagamento", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaFormaPagamento")
    @ResponseWrapper(localName = "deletaFormaPagamentoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaFormaPagamentoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaFormaPagamentoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaFormaPagamentoResponse")
    public void deletaFormaPagamento(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.FormaPagamentoDto>
     */
    @WebMethod
    @WebResult(name = "formaPagamento", targetNamespace = "")
    @RequestWrapper(localName = "listaFormasPagamentos", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaFormasPagamentos")
    @ResponseWrapper(localName = "listaFormasPagamentosResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaFormasPagamentosResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaFormasPagamentosRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaFormasPagamentosResponse")
    public List<FormaPagamentoDto> listaFormasPagamentos();

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.FormaPagamentoDto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaFormaPagamento", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaFormaPagamento")
    @ResponseWrapper(localName = "consultaFormaPagamentoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaFormaPagamentoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaFormaPagamentoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaFormaPagamentoResponse")
    public FormaPagamentoDto consultaFormaPagamento(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param fornecedor
     */
    @WebMethod
    @RequestWrapper(localName = "salvarFornecedor", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvarFornecedor")
    @ResponseWrapper(localName = "salvarFornecedorResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvarFornecedorResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvarFornecedorRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvarFornecedorResponse")
    public void salvarFornecedor(
        @WebParam(name = "fornecedor", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<FornecedorDto> fornecedor);

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.FornecedorDto>
     */
    @WebMethod
    @WebResult(name = "fornecedor", targetNamespace = "")
    @RequestWrapper(localName = "listarFornecedores", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListarFornecedores")
    @ResponseWrapper(localName = "listarFornecedoresResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListarFornecedoresResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listarFornecedoresRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listarFornecedoresResponse")
    public List<FornecedorDto> listarFornecedores();

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.FornecedorDto
     */
    @WebMethod
    @WebResult(name = "fornecedor", targetNamespace = "")
    @RequestWrapper(localName = "consultaFornecedor", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaFornecedor")
    @ResponseWrapper(localName = "consultaFornecedorResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaFornecedorResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaFornecedorRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaFornecedorResponse")
    public FornecedorDto consultaFornecedor(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deletarFornecedor", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletarFornecedor")
    @ResponseWrapper(localName = "deletarFornecedorResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletarFornecedorResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletarFornecedorRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletarFornecedorResponse")
    public void deletarFornecedor(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param usuario
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.FuncionarioDto
     */
    @WebMethod
    @WebResult(name = "funcionario", targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.LoginResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/loginRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/loginResponse")
    public FuncionarioDto login(
        @WebParam(name = "usuario", targetNamespace = "")
        Usuario usuario);

    /**
     * 
     * @param funcionario
     */
    @WebMethod
    @RequestWrapper(localName = "salvaFuncionario", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaFuncionario")
    @ResponseWrapper(localName = "salvaFuncionarioResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaFuncionarioResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaFuncionarioRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaFuncionarioResponse")
    public void salvaFuncionario(
        @WebParam(name = "funcionario", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<FuncionarioDto> funcionario);

    /**
     * 
     * @param usuario
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "autentica", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.Autentica")
    @ResponseWrapper(localName = "autenticaResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.AutenticaResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/autenticaRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/autenticaResponse")
    public boolean autentica(
        @WebParam(name = "usuario", targetNamespace = "")
        Usuario usuario);

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.FuncionarioDto>
     */
    @WebMethod
    @WebResult(name = "funcionario", targetNamespace = "")
    @RequestWrapper(localName = "listaFuncionarios", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaFuncionarios")
    @ResponseWrapper(localName = "listaFuncionariosResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaFuncionariosResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaFuncionariosRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaFuncionariosResponse")
    public List<FuncionarioDto> listaFuncionarios();

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.FuncionarioDto
     */
    @WebMethod
    @WebResult(name = "funcionario", targetNamespace = "")
    @RequestWrapper(localName = "consultaFuncionario", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaFuncionario")
    @ResponseWrapper(localName = "consultaFuncionarioResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaFuncionarioResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaFuncionarioRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaFuncionarioResponse")
    public FuncionarioDto consultaFuncionario(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deletaFuncionario", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaFuncionario")
    @ResponseWrapper(localName = "deletaFuncionarioResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaFuncionarioResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaFuncionarioRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaFuncionarioResponse")
    public void deletaFuncionario(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deletaGasto", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaGasto")
    @ResponseWrapper(localName = "deletaGastoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaGastoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaGastoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaGastoResponse")
    public void deletaGasto(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param gasto
     */
    @WebMethod
    @RequestWrapper(localName = "salvaGasto", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaGasto")
    @ResponseWrapper(localName = "salvaGastoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaGastoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaGastoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaGastoResponse")
    public void salvaGasto(
        @WebParam(name = "gasto", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<GastoDto> gasto);

    /**
     * 
     * @param aquisicao
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.GastoDto>
     */
    @WebMethod
    @WebResult(name = "gasto", targetNamespace = "")
    @RequestWrapper(localName = "consultaGastos", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaGastos")
    @ResponseWrapper(localName = "consultaGastosResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaGastosResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaGastosRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaGastosResponse")
    public List<GastoDto> consultaGastos(
        @WebParam(name = "aquisicao", targetNamespace = "")
        AquisicaoDto aquisicao);

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.GastoDto
     */
    @WebMethod
    @WebResult(name = "gasto", targetNamespace = "")
    @RequestWrapper(localName = "consultaGasto", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaGasto")
    @ResponseWrapper(localName = "consultaGastoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaGastoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaGastoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaGastoResponse")
    public GastoDto consultaGasto(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.GastoDto>
     */
    @WebMethod
    @WebResult(name = "gasto", targetNamespace = "")
    @RequestWrapper(localName = "listaGastos", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaGastos")
    @ResponseWrapper(localName = "listaGastosResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaGastosResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaGastosRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaGastosResponse")
    public List<GastoDto> listaGastos();

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.VeiculoDto>
     */
    @WebMethod
    @WebResult(name = "veiculo", targetNamespace = "")
    @RequestWrapper(localName = "listaVeiculos", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaVeiculos")
    @ResponseWrapper(localName = "listaVeiculosResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaVeiculosResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaVeiculosRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaVeiculosResponse")
    public List<VeiculoDto> listaVeiculos();

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.VeiculoDto
     */
    @WebMethod
    @WebResult(name = "veiculo", targetNamespace = "")
    @RequestWrapper(localName = "consultaVeiculo", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaVeiculo")
    @ResponseWrapper(localName = "consultaVeiculoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaVeiculoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaVeiculoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaVeiculoResponse")
    public VeiculoDto consultaVeiculo(
        @WebParam(name = "id", targetNamespace = "")
        Integer id);

    /**
     * 
     * @param veiculo
     */
    @WebMethod
    @RequestWrapper(localName = "salvaVeiculo", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaVeiculo")
    @ResponseWrapper(localName = "salvaVeiculoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaVeiculoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaVeiculoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaVeiculoResponse")
    public void salvaVeiculo(
        @WebParam(name = "veiculo", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<VeiculoDto> veiculo);

    /**
     * 
     * @param id
     */
    @WebMethod
    @RequestWrapper(localName = "deletaVeiculo", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaVeiculo")
    @ResponseWrapper(localName = "deletaVeiculoResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.DeletaVeiculoResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaVeiculoRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/deletaVeiculoResponse")
    public void deletaVeiculo(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.VeiculoDto>
     */
    @WebMethod
    @WebResult(name = "veiculo", targetNamespace = "")
    @RequestWrapper(localName = "listaVeiculosEmEstoque", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaVeiculosEmEstoque")
    @ResponseWrapper(localName = "listaVeiculosEmEstoqueResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaVeiculosEmEstoqueResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaVeiculosEmEstoqueRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaVeiculosEmEstoqueResponse")
    public List<VeiculoDto> listaVeiculosEmEstoque();

    /**
     * 
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.VendaDto>
     */
    @WebMethod
    @WebResult(name = "venda", targetNamespace = "")
    @RequestWrapper(localName = "listaVendas", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaVendas")
    @ResponseWrapper(localName = "listaVendasResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ListaVendasResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaVendasRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/listaVendasResponse")
    public List<VendaDto> listaVendas();

    /**
     * 
     * @param venda
     */
    @WebMethod
    @RequestWrapper(localName = "salvaVenda", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaVenda")
    @ResponseWrapper(localName = "salvaVendaResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.SalvaVendaResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaVendaRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/salvaVendaResponse")
    public void salvaVenda(
        @WebParam(name = "venda", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<VendaDto> venda);

    /**
     * 
     * @param id
     * @return
     *     returns br.edu.ftlf.ads.revenda.webservice.VendaDto
     */
    @WebMethod
    @WebResult(name = "venda", targetNamespace = "")
    @RequestWrapper(localName = "consultaVenda", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaVenda")
    @ResponseWrapper(localName = "consultaVendaResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaVendaResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaVendaRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaVendaResponse")
    public VendaDto consultaVenda(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param venda
     */
    @WebMethod
    @RequestWrapper(localName = "cancelaVenda", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.CancelaVenda")
    @ResponseWrapper(localName = "cancelaVendaResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.CancelaVendaResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/cancelaVendaRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/cancelaVendaResponse")
    public void cancelaVenda(
        @WebParam(name = "venda", targetNamespace = "")
        VendaDto venda);

    /**
     * 
     * @param cliente
     * @return
     *     returns java.util.List<br.edu.ftlf.ads.revenda.webservice.VendaDto>
     */
    @WebMethod
    @WebResult(name = "venda", targetNamespace = "")
    @RequestWrapper(localName = "consultaVendasPorCliente", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaVendasPorCliente")
    @ResponseWrapper(localName = "consultaVendasPorClienteResponse", targetNamespace = "http://webservice.revenda.ads.ftlf.edu.br/", className = "br.edu.ftlf.ads.revenda.webservice.ConsultaVendasPorClienteResponse")
    @Action(input = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaVendasPorClienteRequest", output = "http://webservice.revenda.ads.ftlf.edu.br/RevendaServices/consultaVendasPorClienteResponse")
    public List<VendaDto> consultaVendasPorCliente(
        @WebParam(name = "cliente", targetNamespace = "")
        ClienteDto cliente);

}
