
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaVeiculoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaVeiculoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="veiculo" type="{http://webservice.revenda.ads.ftlf.edu.br/}veiculoDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaVeiculoResponse", propOrder = {
    "veiculo"
})
public class ConsultaVeiculoResponse {

    protected VeiculoDto veiculo;

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

}
