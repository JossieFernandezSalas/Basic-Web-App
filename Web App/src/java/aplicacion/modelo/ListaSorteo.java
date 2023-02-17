/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lista-sorteos")
public class ListaSorteo implements Serializable{
    
    @XmlElement(name = "sorteo")
    private final List<Sorteo> sorteos;

    public ListaSorteo() {
        sorteos = new ArrayList<>();
    }
 
    public ListaSorteo(List<Sorteo> sorteos) {
        this.sorteos = sorteos;
    }
   

    public void agregar(Sorteo sorteo) {
        sorteos.add(sorteo);
    }

    public void borrarTodos() {
        sorteos.clear();
    }

@Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        for (Sorteo s : sorteos) {
            r.append(String.format("\t%s,%n", s));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaSorteos\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Motivo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Retorno"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Fecha"));

        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        for (Sorteo s : sorteos) {
            r.append(s.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
        public String toStringHTMLAdmin() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaSorteos\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Motivo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Retorno"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Fecha"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero Ganador"));

        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        for (Sorteo s : sorteos) {
            r.append(s.toStringHTMLAdmin());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public List<Sorteo> getListaSorteos() {
        return Collections.unmodifiableList(sorteos);
    }

    public String getTabla() {
        return toStringHTML();
    }
    
     public String getTablaAdmin() {
        return toStringHTMLAdmin();
    }

}
