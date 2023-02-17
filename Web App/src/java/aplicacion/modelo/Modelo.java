/*
Name: Jossie Esteban Fernández Salas
Email: jossie.fernandez.salas@gmail.com
Linkedin: linkedin.com/in/jossiefernandez/
 */

package aplicacion.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Georges Alfaro S.
 */
@XmlRootElement(name = "información")
public class Modelo {

    public Modelo(){
        sorteos = new ArrayList<>();
        usuarios = new ArrayList<>();
        apuestas = new ArrayList<>();
    }

    /*public static void main(String[] args) {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Modelo.class);

            Unmarshaller umrs = ctx.createUnmarshaller();
            Modelo m = (Modelo) umrs.unmarshal(new FileInputStream("../info-spj.xml"));

            Marshaller mrs = ctx.createMarshaller();
            mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mrs.marshal(m, System.out);

        } catch (FileNotFoundException | JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }*/
    
    public Modelo cargar(InputStream entrada){
            Modelo m = null;
            try {
            JAXBContext ctx = JAXBContext.newInstance(Modelo.class);

            Unmarshaller umrs = ctx.createUnmarshaller();
             m = (Modelo) umrs.unmarshal(entrada);

            /*Marshaller mrs = ctx.createMarshaller();
            mrs.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mrs.marshal(m, System.out);*/
            
        } catch (JAXBException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
                        
        return m;
    }

    public List<Sorteo> getSorteos() {
        return sorteos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    @XmlElementWrapper(name = "lista-sorteos")
    @XmlElement(name = "sorteo")
    private final List<Sorteo> sorteos;

    @XmlElementWrapper(name = "lista-usuarios")
    @XmlElement(name = "usuario")
    private final List<Usuario> usuarios;

    @XmlElementWrapper(name = "lista-apuestas")
    @XmlElement(name = "apuesta")
    private final List<Apuesta> apuestas;
}
