package Enunciado2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReader2 {
    public static void main(String[] args) {
        File file = new File("resources/enunciado2_actividad_5_2.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element elementoRaiz = document.getDocumentElement();
            NodeList listaUsuarios = elementoRaiz.getElementsByTagName("usuario");

            System.out.println("Usuarios:");
            for (int i = 0; i < listaUsuarios.getLength(); i++){

                String idUsuario = ((Element)listaUsuarios.item(i)).getAttribute("id");
                System.out.println("\n    Usuario " + idUsuario + ": ");

                Element elementoNombreU = (Element)(((Element)listaUsuarios.item(i)).getElementsByTagName("nombre").item(0));
                String apellidoNombre = elementoNombreU.getAttribute("apellido");
                String edadNombre = elementoNombreU.getAttribute("edad");
                System.out.print("        ");
                System.out.println("Nombre: " + elementoNombreU.getTextContent() + apellidoNombre);
                System.out.print("        ");
                System.out.println("Edad: " + edadNombre);

                Element elementoContacto = (Element)((Element)listaUsuarios.item(i)).getElementsByTagName("contacto").item(0);
                Element elementoEmailContacto = (Element) elementoContacto.getElementsByTagName("email").item(0);
                System.out.print("        ");
                System.out.println("Email: " + elementoEmailContacto.getTextContent());

                Element elementoTelefonoContacto = (Element) elementoContacto.getElementsByTagName("telefono").item(0);
                System.out.print("        ");
                System.out.println("Teléfono: " + elementoTelefonoContacto.getTextContent());



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
