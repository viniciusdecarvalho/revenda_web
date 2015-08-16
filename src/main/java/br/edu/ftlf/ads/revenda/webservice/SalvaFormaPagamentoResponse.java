
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de salvaFormaPagamentoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="salvaFormaPagamentoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="formaPagamento" type="{http://webservice.revenda.ads.ftlf.edu.br/}formaPagamentoDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvaFormaPagamentoResponse", propOrder = {
    "formaPagamento"
})
public class SalvaFormaPagamentoResponse {

    protected FormaPagamentoDto formaPagamento;

    /**
     * Obt�m o valor da propriedade formaPagamento.
     * 
     * @return
     *     possible object is
     *     {@link FormaPagamentoDto }
     *     
     */
    public FormaPagamentoDto getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * Define o valor da propriedade formaPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link FormaPagamentoDto }
     *     
     */
    public void setFormaPagamento(FormaPagamentoDto value) {
        this.formaPagamento = value;
    }

}
