package Enunciado3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class XMLReader3 {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        File file = new File("resources/enunciado2_actividad_5_2.xml");

        ArrayList<String>numerosTelefono = new ArrayList<>();
        HashMap<String, String> usuariosTelefono = new HashMap<>();

        try {

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            Element elementoRaiz = document.getDocumentElement();
            NodeList listaUsuarios = elementoRaiz.getElementsByTagName("usuario");

            for (int i = 0; i < listaUsuarios.getLength(); i++){
                Element elementoNombre = (Element)(((Element)listaUsuarios.item(i)).getElementsByTagName("nombre").item(0));
                String nombre = elementoNombre.getTextContent();
                Element elementoContacto = (Element)(((Element)listaUsuarios.item(i)).getElementsByTagName("contacto").item(0));
                Element elementoTelefono = (Element)elementoContacto.getElementsByTagName("telefono").item(0);

                numerosTelefono.add(elementoTelefono.getTextContent());
                usuariosTelefono.put(elementoTelefono.getTextContent(), nombre);

            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Introduce el número de teléfono del usuario");
        Scanner scanner = new Scanner(System.in);
        String telefonoBuscado = scanner.nextLine();
        boolean telefonoEncontrado = false;
        for(String telefono: numerosTelefono){
            if(telefono.equals(telefonoBuscado)){
                System.out.println("El número " + telefono + " pertenece al usuario " + usuariosTelefono.get(telefono));
                telefonoEncontrado = true;
            }
        }
        if(!telefonoEncontrado){
            System.out.println("El número " + telefonoBuscado + "no pertenece a ningún usuario");
        }

    }
}
