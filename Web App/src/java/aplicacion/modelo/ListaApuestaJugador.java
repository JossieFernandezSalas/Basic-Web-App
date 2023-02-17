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

/**
 *
 * @author jossi
 */
public class ListaApuestaJugador implements Serializable{
    
        private final List<ApuestaJugador> apuestasJugador;

    public ListaApuestaJugador() {
        apuestasJugador = new  ArrayList<>();
    }

    public ListaApuestaJugador(List<ApuestaJugador> apuestasJugador) {
        this.apuestasJugador = apuestasJugador;
    }
    
    
    public void agregar(ApuestaJugador apuesta) {
        apuestasJugador.add(apuesta);
    }

    public List<ApuestaJugador> getApuestasJugador() {
        return apuestasJugador;
    }
    

    public void borrarTodos() {
        apuestasJugador.clear();
    }

@Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        for (ApuestaJugador a : apuestasJugador) {
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
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Motivo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Fecha"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Retorno"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Ganador"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Casas"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Premio"));

        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        for (ApuestaJugador a : apuestasJugador) {
            r.append(a.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public String getTabla() {
        return toStringHTML();
    }

    
}
