
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de funcionarioDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="funcionarioDto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice.revenda.ads.ftlf.edu.br/}dto">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ativo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="gerente" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="vendedor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cpf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "funcionarioDto", propOrder = {
    "id",
    "ativo",
    "gerente",
    "usuario",
    "vendedor",
    "cpf",
    "nome"
})
public class FuncionarioDto
    extends Dto
{

    protected Integer id;
    protected boolean ativo;
    protected boolean gerente;
    protected boolean usuario;
    protected boolean vendedor;
    @XmlElement(required = true)
    protected String cpf;
    @XmlElement(required = true)
    protected String nome;

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade ativo.
     * 
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Define o valor da propriedade ativo.
     * 
     */
    public void setAtivo(boolean value) {
        this.ativo = value;
    }

    /**
     * Obtém o valor da propriedade gerente.
     * 
     */
    public boolean isGerente() {
        return gerente;
    }

    /**
     * Define o valor da propriedade gerente.
     * 
     */
    public void setGerente(boolean value) {
        this.gerente = value;
    }

    /**
     * Obtém o valor da propriedade usuario.
     * 
     */
    public boolean isUsuario() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     */
    public void setUsuario(boolean value) {
        this.usuario = value;
    }

    /**
     * Obtém o valor da propriedade vendedor.
     * 
     */
    public boolean isVendedor() {
        return vendedor;
    }

    /**
     * Define o valor da propriedade vendedor.
     * 
     */
    public void setVendedor(boolean value) {
        this.vendedor = value;
    }

    /**
     * Obtém o valor da propriedade cpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpf(String value) {
        this.cpf = value;
    }

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

}
