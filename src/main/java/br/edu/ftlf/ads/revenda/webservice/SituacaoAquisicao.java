
package br.edu.ftlf.ads.revenda.webservice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de situacaoAquisicao.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="situacaoAquisicao">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OK"/>
 *     &lt;enumeration value="CANCELADO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "situacaoAquisicao")
@XmlEnum
public enum SituacaoAquisicao {

    OK,
    CANCELADO;

    public String value() {
        return name();
    }

    public static SituacaoAquisicao fromValue(String v) {
        return valueOf(v);
    }

}
