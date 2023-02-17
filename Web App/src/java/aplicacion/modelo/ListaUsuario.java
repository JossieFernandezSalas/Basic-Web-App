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

@XmlRootElement(name = "lista-usuarios")
public class ListaUsuario implements Serializable{
    
    @XmlElement(name = "usuario")
    private final List<Usuario> usuarios;

    public ListaUsuario() {
        usuarios = new ArrayList<>();
    }
    
    

    public ListaUsuario(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
     public void cargar(InputStream entrada) throws JAXBException {
        JAXBContext ctx = JAXBContext.newInstance(ListaUsuario.class);
        Unmarshaller mrs = ctx.createUnmarshaller();
        usuarios.clear();

        List<Usuario> tmp = ((ListaUsuario) mrs.unmarshal(entrada)).getListaUsuarios();
        for (Usuario u : tmp) {
            usuarios.add(u);
        }

    }

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void borrarTodos() {
        usuarios.clear();
    }

@Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        for (Usuario u : usuarios) {
            r.append(String.format("\t%s,%n", u));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaUsuarios\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Cedula"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellidos"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Tarjeta"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        for (Usuario u : usuarios) {
            r.append(u.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public List<Usuario> getListaUsuarios() {
        return Collections.unmodifiableList(usuarios);
    }

    public String getTabla() {
        return toStringHTML();
    }

}
