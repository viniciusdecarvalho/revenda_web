
package br.edu.ftlf.ads.revenda.webservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de aquisicaoDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="aquisicaoDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.revenda.ads.ftlf.edu.br/}dto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cidade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="combustivel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="km" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="obs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="valorComissao" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="valorPedido" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="cliente" type="{http://webservice.revenda.ads.ftlf.edu.br/}clienteDto"/>
 *         &lt;element name="funcionario" type="{http://webservice.revenda.ads.ftlf.edu.br/}funcionarioDto"/>
 *         &lt;element name="veiculo" type="{http://webservice.revenda.ads.ftlf.edu.br/}veiculoDto"/>
 *         &lt;element name="situacao" type="{http://webservice.revenda.ads.ftlf.edu.br/}situacaoAquisicao" minOccurs="0"/>
 *         &lt;element name="pagamentos" type="{http://webservice.revenda.ads.ftlf.edu.br/}pagamentoDto" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aquisicaoDto", propOrder = {
    "id",
    "cidade",
    "combustivel",
    "cor",
    "data",
    "km",
    "obs",
    "uf",
    "valor",
    "valorComissao",
    "valorPedido",
    "cliente",
    "funcionario",
    "veiculo",
    "situacao",
    "pagamentos"
})
public class AquisicaoDto
    extends Dto
{

    protected Integer id;
    @XmlElement(required = true)
    protected String cidade;
    @XmlElement(required = true)
    protected String combustivel;
    @XmlElement(required = true)
    protected String cor;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar data;
    protected int km;
    protected String obs;
    @XmlElement(required = true)
    protected String uf;
    @XmlElement(required = true)
    protected BigDecimal valor;
    protected BigDecimal valorComissao;
    @XmlElement(required = true)
    protected BigDecimal valorPedido;
    @XmlElement(required = true)
    protected ClienteDto cliente;
    @XmlElement(required = true)
    protected FuncionarioDto funcionario;
    @XmlElement(required = true)
    protected VeiculoDto veiculo;
    @XmlSchemaType(name = "string")
    protected SituacaoAquisicao situacao;
    @XmlElement(required = true)
    protected List<PagamentoDto> pagamentos;

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade cidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define o valor da propriedade cidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidade(String value) {
        this.cidade = value;
    }

    /**
     * Obtém o valor da propriedade combustivel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCombustivel() {
        return combustivel;
    }

    /**
     * Define o valor da propriedade combustivel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCombustivel(String value) {
        this.combustivel = value;
    }

    /**
     * Obtém o valor da propriedade cor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define o valor da propriedade cor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCor(String value) {
        this.cor = value;
    }

    /**
     * Obtém o valor da propriedade data.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getData() {
        return data;
    }

    /**
     * Define o valor da propriedade data.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setData(XMLGregorianCalendar value) {
        this.data = value;
    }

    /**
     * Obtém o valor da propriedade km.
     * 
     */
    public int getKm() {
        return km;
    }

    /**
     * Define o valor da propriedade km.
     * 
     */
    public void setKm(int value) {
        this.km = value;
    }

    /**
     * Obtém o valor da propriedade obs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObs() {
        return obs;
    }

    /**
     * Define o valor da propriedade obs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObs(String value) {
        this.obs = value;
    }

    /**
     * Obtém o valor da propriedade uf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define o valor da propriedade uf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUf(String value) {
        this.uf = value;
    }

    /**
     * Obtém o valor da propriedade valor.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Define o valor da propriedade valor.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValor(BigDecimal value) {
        this.valor = value;
    }

    /**
     * Obtém o valor da propriedade valorComissao.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorComissao() {
        return valorComissao;
    }

    /**
     * Define o valor da propriedade valorComissao.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorComissao(BigDecimal value) {
        this.valorComissao = value;
    }

    /**
     * Obtém o valor da propriedade valorPedido.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    /**
     * Define o valor da propriedade valorPedido.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorPedido(BigDecimal value) {
        this.valorPedido = value;
    }

    /**
     * Obtém o valor da propriedade cliente.
     * 
     * @return
     *     possible object is
     *     {@link ClienteDto }
     *     
     */
    public ClienteDto getCliente() {
        return cliente;
    }

    /**
     * Define o valor da propriedade cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteDto }
     *     
     */
    public void setCliente(ClienteDto value) {
        this.cliente = value;
    }

    /**
     * Obtém o valor da propriedade funcionario.
     * 
     * @return
     *     possible object is
     *     {@link FuncionarioDto }
     *     
     */
    public FuncionarioDto getFuncionario() {
        return funcionario;
    }

    /**
     * Define o valor da propriedade funcionario.
     * 
     * @param value
     *     allowed object is
     *     {@link FuncionarioDto }
     *     
     */
    public void setFuncionario(FuncionarioDto value) {
        this.funcionario = value;
    }

    /**
     * Obtém o valor da propriedade veiculo.
     * 
     * @return
     *     possible object is
     *     {@link VeiculoDto }
     *     
     */
    public VeiculoDto getVeiculo() {
        return veiculo;
    }

    /**
     * Define o valor da propriedade veiculo.
     * 
     * @param value
     *     allowed object is
     *     {@link VeiculoDto }
     *     
     */
    public void setVeiculo(VeiculoDto value) {
        this.veiculo = value;
    }

    /**
     * Obtém o valor da propriedade situacao.
     * 
     * @return
     *     possible object is
     *     {@link SituacaoAquisicao }
     *     
     */
    public SituacaoAquisicao getSituacao() {
        return situacao;
    }

    /**
     * Define o valor da propriedade situacao.
     * 
     * @param value
     *     allowed object is
     *     {@link SituacaoAquisicao }
     *     
     */
    public void setSituacao(SituacaoAquisicao value) {
        this.situacao = value;
    }

    /**
     * Gets the value of the pagamentos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pagamentos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPagamentos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PagamentoDto }
     * 
     * 
     */
    public List<PagamentoDto> getPagamentos() {
        if (pagamentos == null) {
            pagamentos = new ArrayList<PagamentoDto>();
        }
        return this.pagamentos;
    }

}
