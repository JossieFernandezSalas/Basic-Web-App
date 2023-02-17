/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Georges Alfaro S.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cedula",
    "clave",
    "apellidos",
    "nombre",
    "tarjeta"
})
@XmlRootElement(name = "usuario")
public class Usuario {

    public Usuario(String cedula,
            String clave,
            String apellidos,
            String nombre,
            Tarjeta tarjeta,
            boolean administrador) {
        this.cedula = cedula;
        this.clave = clave;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.administrador = administrador;
    }

    public Usuario() {
        this(null, null, null, null, null, false);
    }
    
       @Override
    public String toString() {
        return String.format("{%s, %s, %s, %d}",
                cedula, nombre,apellidos, tarjeta.getValue() );
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%s</td>\n",cedula));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", nombre));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", apellidos));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", tarjeta.getValue()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @XmlElement(name = "cédula", required = true)
    private String cedula;
    @XmlElement(required = true)
    private String clave;
    @XmlElement(required = true)
    private String apellidos;
    @XmlElement(required = true)
    private String nombre;
    private Tarjeta tarjeta;
    @XmlAttribute(name = "administrador")
    private boolean administrador;
}
