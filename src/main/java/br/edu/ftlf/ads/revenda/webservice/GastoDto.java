
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de gastoDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="gastoDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.revenda.ads.ftlf.edu.br/}dto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="situacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aquisicaoId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fornecedorId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pagamento" type="{http://webservice.revenda.ads.ftlf.edu.br/}pagamentoDto"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gastoDto", propOrder = {
    "id",
    "situacao",
    "aquisicaoId",
    "fornecedorId",
    "pagamento"
})
public class GastoDto
    extends Dto
{

    protected Integer id;
    protected String situacao;
    protected int aquisicaoId;
    protected int fornecedorId;
    @XmlElement(required = true)
    protected PagamentoDto pagamento;

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
     * Obtém o valor da propriedade situacao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * Define o valor da propriedade situacao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSituacao(String value) {
        this.situacao = value;
    }

    /**
     * Obtém o valor da propriedade aquisicaoId.
     * 
     */
    public int getAquisicaoId() {
        return aquisicaoId;
    }

    /**
     * Define o valor da propriedade aquisicaoId.
     * 
     */
    public void setAquisicaoId(int value) {
        this.aquisicaoId = value;
    }

    /**
     * Obtém o valor da propriedade fornecedorId.
     * 
     */
    public int getFornecedorId() {
        return fornecedorId;
    }

    /**
     * Define o valor da propriedade fornecedorId.
     * 
     */
    public void setFornecedorId(int value) {
        this.fornecedorId = value;
    }

    /**
     * Obtém o valor da propriedade pagamento.
     * 
     * @return
     *     possible object is
     *     {@link PagamentoDto }
     *     
     */
    public PagamentoDto getPagamento() {
        return pagamento;
    }

    /**
     * Define o valor da propriedade pagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link PagamentoDto }
     *     
     */
    public void setPagamento(PagamentoDto value) {
        this.pagamento = value;
    }

}
