
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de consultaAquisicaoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="consultaAquisicaoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aquisicao" type="{http://webservice.revenda.ads.ftlf.edu.br/}aquisicaoDto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaAquisicaoResponse", propOrder = {
    "aquisicao"
})
public class ConsultaAquisicaoResponse {

    protected AquisicaoDto aquisicao;

    /**
     * Obt�m o valor da propriedade aquisicao.
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

}
