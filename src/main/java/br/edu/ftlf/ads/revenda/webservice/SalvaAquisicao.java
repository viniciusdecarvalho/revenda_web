
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de salvaAquisicao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="salvaAquisicao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aquisicao" type="{http://webservice.revenda.ads.ftlf.edu.br/}aquisicaoDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvaAquisicao", propOrder = {
    "aquisicao"
})
public class SalvaAquisicao {

    @XmlElement(required = true)
    protected AquisicaoDto aquisicao;

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

}
