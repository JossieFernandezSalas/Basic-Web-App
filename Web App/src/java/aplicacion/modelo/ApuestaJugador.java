/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import java.text.SimpleDateFormat;

/**
 *
 * @author jossi
 */
public class ApuestaJugador {
    
    private Sorteo sorteo;
    private Apuesta apuesta;

    public ApuestaJugador() {
    }
    

    public ApuestaJugador(Sorteo sorteo, Apuesta apuesta) {
        this.sorteo = sorteo;
        this.apuesta = apuesta;
    }

    @Override
    public String toString() {
        return "ApuestaJugador{" + "sorteo=" + sorteo + ", apuesta=" + apuesta + '}';
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%s</td>\n", sorteo.getMotivo()));
          r.append(String.format("\t\t\t\t<td>%s</td>\n",
                new SimpleDateFormat("yyyy-MM-dd").format(sorteo.getFecha())));
        r.append(String.format("\t\t\t\t<td>%s</td>\n",sorteo.getRetorno()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n",sorteo.getNumeroGanador()));
                r.append(String.format("\t\t\t\t<td>%s</td>\n",apuesta.getMontoApuesta()));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", calculaPremio()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    public int calculaPremio(){
        if(sorteo.getEstado() == 3){
            int premio = (int) (sorteo.getRetorno() * apuesta.getMontoApuesta());
            return premio;
        }else
            return 0;
    }

    public Sorteo getSorteo() {
        return sorteo;
    }

    public void setSorteo(Sorteo sorteo) {
        this.sorteo = sorteo;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }
    
    
    
}
