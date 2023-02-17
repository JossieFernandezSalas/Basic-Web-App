/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
    "numeroSorteo",
    "numeroJuego",
    "montoApuesta",
    "montoPremio"
})
@XmlRootElement(name = "apuesta")
public class Apuesta {

    public Apuesta(String cedula,
            long numeroSorteo,
            long numeroJuego,
            long montoApuesta,
            long montoPremio) {
        this.cedula = cedula;
        this.numeroSorteo = numeroSorteo;
        this.numeroJuego = numeroJuego;
        this.montoApuesta = montoApuesta;
        this.montoPremio = montoPremio;
    }

    public Apuesta() {
        this(null, 0, 0, 0, 0);
    }

    @Override
    public String toString() {
        return String.format("{%s, %d, %d, %d, %d}",
                cedula, numeroSorteo, numeroJuego, montoApuesta, montoPremio);
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<td>%s</td>\n", cedula));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", numeroSorteo));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", numeroJuego));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", montoApuesta));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", montoPremio));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public long getNumeroSorteo() {
        return numeroSorteo;
    }

    public void setNumeroSorteo(long numeroSorteo) {
        this.numeroSorteo = numeroSorteo;
    }

    public long getNumeroJuego() {
        return numeroJuego;
    }

    public void setNumeroJuego(long numeroJuego) {
        this.numeroJuego = numeroJuego;
    }

    public long getMontoApuesta() {
        return montoApuesta;
    }

    public void setMontoApuesta(long montoApuesta) {
        this.montoApuesta = montoApuesta;
    }

    public long getMontoPremio() {
        return montoPremio;
    }

    public void setMontoPremio(long montoPremio) {
        this.montoPremio = montoPremio;
    }

    @XmlElement(name = "cédula", required = true)
    private String cedula;
    @XmlElement(name = "número-sorteo", required = true)
    private long numeroSorteo;
    @XmlElement(name = "número-juego", required = true)
    private long numeroJuego;
    @XmlElement(name = "monto-apuesta", required = true)
    private long montoApuesta;
    @XmlElement(name = "monto-premio", required = true)
    private long montoPremio;
}
