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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "lista-apuestas")
public class ListaApuesta implements Serializable{
    private final List<Apuesta> apuestas;

    public ListaApuesta() {
        apuestas = new ArrayList<>();
    }
    
    public ListaApuesta(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public void agregar(Apuesta apuesta) {
        apuestas.add(apuesta);
    }

    public void borrarTodos() {
        apuestas.clear();
    }

@Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        for (Apuesta a : apuestas) {
            r.append(String.format("\t%s,%n", a));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaApuestas\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Cedula"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero de Sorteo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero de Juego"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apuesta"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Premio"));

        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        for (Apuesta aps : apuestas) {
            r.append(aps.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public List<Apuesta> getListaApuestas() {
        return apuestas;
    }

    public String getTabla() {
        return toStringHTML();
    }
}
