
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cancelaVenda complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cancelaVenda">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="venda" type="{http://webservice.revenda.ads.ftlf.edu.br/}vendaDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelaVenda", propOrder = {
    "venda"
})
public class CancelaVenda {

    @XmlElement(required = true)
    protected VendaDto venda;

    /**
     * Obt�m o valor da propriedade venda.
     * 
     * @return
     *     possible object is
     *     {@link VendaDto }
     *     
     */
    public VendaDto getVenda() {
        return venda;
    }

    /**
     * Define o valor da propriedade venda.
     * 
     * @param value
     *     allowed object is
     *     {@link VendaDto }
     *     
     */
    public void setVenda(VendaDto value) {
        this.venda = value;
    }

}
