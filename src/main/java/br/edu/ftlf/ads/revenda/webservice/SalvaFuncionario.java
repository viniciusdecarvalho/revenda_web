
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de salvaFuncionario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="salvaFuncionario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="funcionario" type="{http://webservice.revenda.ads.ftlf.edu.br/}funcionarioDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvaFuncionario", propOrder = {
    "funcionario"
})
public class SalvaFuncionario {

    @XmlElement(required = true)
    protected FuncionarioDto funcionario;

    /**
     * Obt�m o valor da propriedade funcionario.
     * 
     * @return
     *     possible object is
     *     {@link FuncionarioDto }
     *     
     */
    public FuncionarioDto getFuncionario() {
        return funcionario;
    }

    /**
     * Define o valor da propriedade funcionario.
     * 
     * @param value
     *     allowed object is
     *     {@link FuncionarioDto }
     *     
     */
    public void setFuncionario(FuncionarioDto value) {
        this.funcionario = value;
    }

}
