
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
 * <p>Classe Java de vendaDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="vendaDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.revenda.ads.ftlf.edu.br/}dto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="obs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="valorComissao" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="aquisicao" type="{http://webservice.revenda.ads.ftlf.edu.br/}aquisicaoDto"/>
 *         &lt;element name="cliente" type="{http://webservice.revenda.ads.ftlf.edu.br/}clienteDto"/>
 *         &lt;element name="vendedor" type="{http://webservice.revenda.ads.ftlf.edu.br/}funcionarioDto"/>
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
@XmlType(name = "vendaDto", propOrder = {
    "id",
    "data",
    "obs",
    "valor",
    "valorComissao",
    "aquisicao",
    "cliente",
    "vendedor",
    "pagamentos"
})
public class VendaDto
    extends Dto
{

    protected Integer id;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar data;
    protected String obs;
    @XmlElement(required = true)
    protected BigDecimal valor;
    protected BigDecimal valorComissao;
    @XmlElement(required = true)
    protected AquisicaoDto aquisicao;
    @XmlElement(required = true)
    protected ClienteDto cliente;
    @XmlElement(required = true)
    protected FuncionarioDto vendedor;
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
     * Obtém o valor da propriedade aquisicao.
     * 
     * @return
     *     possible object is
     *     {@link AquisicaoDto }
     *     
     */
    public AquisicaoDto getAquisicao() {
        return aquisicao;
    }

    /**
     * Define o valor da propriedade aquisicao.
     * 
     * @param value
     *     allowed object is
     *     {@link AquisicaoDto }
     *     
     */
    public void setAquisicao(AquisicaoDto value) {
        this.aquisicao = value;
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
     * Obtém o valor da propriedade vendedor.
     * 
     * @return
     *     possible object is
     *     {@link FuncionarioDto }
     *     
     */
    public FuncionarioDto getVendedor() {
        return vendedor;
    }

    /**
     * Define o valor da propriedade vendedor.
     * 
     * @param value
     *     allowed object is
     *     {@link FuncionarioDto }
     *     
     */
    public void setVendedor(FuncionarioDto value) {
        this.vendedor = value;
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
