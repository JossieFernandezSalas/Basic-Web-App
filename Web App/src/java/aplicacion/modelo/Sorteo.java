/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Georges Alfaro S.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroSorteo",
    "fecha",
    "motivo",
    "retorno",
    "numeroGanador",
    "estado"
})
@XmlRootElement(name = "sorteo")
public class Sorteo {

    public Sorteo(long numeroSorteo,
            Date fecha,
            String motivo,
            int retorno,
            int numeroGanador,
            int estado) {
        this.numeroSorteo = numeroSorteo;
        this.fecha = fecha;
        this.motivo = motivo;
        this.retorno = retorno;
        this.numeroGanador = numeroGanador;
        this.estado = estado;
    }

    public Sorteo() {
        this(0, null, null, 0, 0, 0);
    }

        @Override
    public String toString() {
        return String.format("{%d, %s, %s, %d, %d}",
                numeroSorteo, new SimpleDateFormat("yyyy-MM-dd").format(fecha),
                motivo, retorno, numeroGanador, estado);
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%s</td>\n", motivo));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", retorno));
        r.append(String.format("\t\t\t\t<td>%s</td>\n",
                new SimpleDateFormat("yyyy-MM-dd").format(fecha)));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
        public String toStringHTMLAdmin() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%s</td>\n", motivo));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", retorno));
        r.append(String.format("\t\t\t\t<td>%s</td>\n",
                new SimpleDateFormat("yyyy-MM-dd").format(fecha)));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", numeroGanador));


        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    public long getNumeroSorteo() {
        return numeroSorteo;
    }

    public void setNumeroSorteo(long numeroSorteo) {
        this.numeroSorteo = numeroSorteo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getRetorno() {
        return retorno;
    }

    public void setRetorno(int retorno) {
        this.retorno = retorno;
    }

    public int getNumeroGanador() {
        return numeroGanador;
    }

    public void setNumeroGanador(int numeroGanador) {
        this.numeroGanador = numeroGanador;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlElement(name = "número-sorteo", required = true)
    private long numeroSorteo;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date fecha;
    @XmlElement(required = true)
    private String motivo;
    private int retorno;
    @XmlElement(name = "número-ganador")
    private int numeroGanador;
    @XmlElement(required = true)
    private int estado;
}
