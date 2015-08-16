
package br.edu.ftlf.ads.revenda.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de listaAquisicoesResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="listaAquisicoesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aquisicao" type="{http://webservice.revenda.ads.ftlf.edu.br/}aquisicaoDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaAquisicoesResponse", propOrder = {
    "aquisicao"
})
public class ListaAquisicoesResponse {

    protected List<AquisicaoDto> aquisicao;

    /**
     * Gets the value of the aquisicao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aquisicao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAquisicao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AquisicaoDto }
     * 
     * 
     */
    public List<AquisicaoDto> getAquisicao() {
        if (aquisicao == null) {
            aquisicao = new ArrayList<AquisicaoDto>();
        }
        return this.aquisicao;
    }

}
