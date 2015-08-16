
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaGastoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaGastoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gasto" type="{http://webservice.revenda.ads.ftlf.edu.br/}gastoDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaGastoResponse", propOrder = {
    "gasto"
})
public class ConsultaGastoResponse {

    protected GastoDto gasto;

    /**
     * Obtém o valor da propriedade gasto.
     * 
     * @return
     *     possible object is
     *     {@link GastoDto }
     *     
     */
    public GastoDto getGasto() {
        return gasto;
    }

    /**
     * Define o valor da propriedade gasto.
     * 
     * @param value
     *     allowed object is
     *     {@link GastoDto }
     *     
     */
    public void setGasto(GastoDto value) {
        this.gasto = value;
    }

}
