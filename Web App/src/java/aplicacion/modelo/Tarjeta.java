/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 *
 * @author Georges Alfaro S.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "tarjeta")
public class Tarjeta {

    public Tarjeta(long value, String tipo) {
        this.value = value;
        this.tipo = tipo;
    }

    public Tarjeta() {
        this(0, null);
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String value) {
        this.tipo = value;
    }

    @XmlValue
    private long value;
    @XmlAttribute(name = "tipo", required = true)
    private String tipo;
}
