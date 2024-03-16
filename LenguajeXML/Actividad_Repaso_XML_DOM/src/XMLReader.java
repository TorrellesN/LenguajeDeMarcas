import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReader {
    public static void main(String[] args) {
        File file = new File("resources/Ejercicio_de_repaso.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        String nombreTaller;
        String categoriaTaller = null;
        String duracionTaller = null;
        Instructor instructor;

        try {

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element elementoRaiz = document.getDocumentElement();

            Element elementoNombreTaller = (Element)elementoRaiz.getElementsByTagName("elementoNombreTaller").item(0);
            nombreTaller = elementoNombreTaller.getTextContent();
            categoriaTaller = elementoNombreTaller.getAttribute("categoria");
            duracionTaller = elementoNombreTaller.getAttribute("duracion");

            Element elementoInstructor = (Element)elementoNombreTaller.getElementsByTagName("instructor").item(0);
            Element elementoNombreInstructor = (Element)elementoInstructor.getElementsByTagName("Nombre");
            Element elementoEspecialidadInstructor = (Element)elementoInstructor.getElementsByTagName("especialidad");
            String nombreInstructor = elementoNombreInstructor.getTextContent();
            String especialidad = elementoEspecialidadInstructor.getAttribute("categoria");
            String experiencia = elementoEspecialidadInstructor.getAttribute("experiencia");
            instructor = new Instructor(nombreInstructor, especialidad, experiencia);

            NodeList listaParticipantes = elementoRaiz.getElementsByTagName("participantes");
            for (int i = 0; i < listaParticipantes.getLength(); i++){

                Element elementoParticipante = (Element)listaParticipantes.item(i);
                String idParticipante = elementoParticipante.getAttribute("id");
                String nombreParticipante = elementoParticipante.getAttribute("nombre");
                String apellidosParticipante = elementoParticipante.getAttribute("apellidos");

                Element elementoEquipo = (Element)(((Element)listaParticipantes.item(i)).getElementsByTagName("equipo").item(0));
                String categoriaEquipo = elementoEquipo.getAttribute("categoria");
                NodeList listaHerramientasEquipo = (NodeList) ((Element)listaParticipantes.item(i)).getElementsByTagName("equipo").item(0);

            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


    }
}