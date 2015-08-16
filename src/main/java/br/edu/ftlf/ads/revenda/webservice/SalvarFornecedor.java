
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de salvarFornecedor complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="salvarFornecedor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fornecedor" type="{http://webservice.revenda.ads.ftlf.edu.br/}fornecedorDto"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "salvarFornecedor", propOrder = {
    "fornecedor"
})
public class SalvarFornecedor {

    @XmlElement(required = true)
    protected FornecedorDto fornecedor;

    /**
     * Obtém o valor da propriedade fornecedor.
     * 
     * @return
     *     possible object is
     *     {@link FornecedorDto }
     *     
     */
    public FornecedorDto getFornecedor() {
        return fornecedor;
    }

    /**
     * Define o valor da propriedade fornecedor.
     * 
     * @param value
     *     allowed object is
     *     {@link FornecedorDto }
     *     
     */
    public void setFornecedor(FornecedorDto value) {
        this.fornecedor = value;
    }

}
