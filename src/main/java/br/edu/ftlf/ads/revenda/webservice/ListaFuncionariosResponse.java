
package br.edu.ftlf.ads.revenda.webservice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de listaFuncionariosResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="listaFuncionariosResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="funcionario" type="{http://webservice.revenda.ads.ftlf.edu.br/}funcionarioDto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaFuncionariosResponse", propOrder = {
    "funcionario"
})
public class ListaFuncionariosResponse {

    protected List<FuncionarioDto> funcionario;

    /**
     * Gets the value of the funcionario property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the funcionario property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFuncionario().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FuncionarioDto }
     * 
     * 
     */
    public List<FuncionarioDto> getFuncionario() {
        if (funcionario == null) {
            funcionario = new ArrayList<FuncionarioDto>();
        }
        return this.funcionario;
    }

}
