
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de salvaVendaResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="salvaVendaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="venda" type="{http://webservice.revenda.ads.ftlf.edu.br/}vendaDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvaVendaResponse", propOrder = {
    "venda"
})
public class SalvaVendaResponse {

    protected VendaDto venda;

    /**
     * Obtém o valor da propriedade venda.
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
