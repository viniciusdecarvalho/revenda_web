
package br.edu.ftlf.ads.revenda.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaGastosResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaGastosResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gasto" type="{http://webservice.revenda.ads.ftlf.edu.br/}gastoDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaGastosResponse", propOrder = {
    "gasto"
})
public class ConsultaGastosResponse {

    protected List<GastoDto> gasto;

    /**
     * Gets the value of the gasto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gasto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGasto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GastoDto }
     * 
     * 
     */
    public List<GastoDto> getGasto() {
        if (gasto == null) {
            gasto = new ArrayList<GastoDto>();
        }
        return this.gasto;
    }

}
