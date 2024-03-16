package Enunciado4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLReader4 {
    public static void main(String[] args) {
        File file = new File("resources/enunciado4_actividad_5_2.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        Perro pepe = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element elementoRaiz = document.getDocumentElement();
            Element elementoNombre = (Element) elementoRaiz.getElementsByTagName("nombre").item(0);
            Element elementoEdad = (Element) elementoRaiz.getElementsByTagName("edad").item(0);
            Element elementoVacunado = (Element) elementoRaiz.getElementsByTagName("vacunado").item(0);
            Element elementoPeso = (Element) elementoRaiz.getElementsByTagName("peso").item(0);
            Element elementoColorDePelo = (Element) elementoRaiz.getElementsByTagName("color_de_pelo").item(0);

            Boolean atributoVacunado;
            if (elementoVacunado.getTextContent().equals("Sí")) {
                atributoVacunado = true;
            } else {
                atributoVacunado = false;
            }

            pepe = new Perro(elementoNombre.getTextContent(), Integer.parseInt(elementoEdad.getTextContent()),
                    atributoVacunado, Float.parseFloat(elementoPeso.getTextContent()), elementoColorDePelo.getTextContent());


        } catch (ParserConfigurationException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
            throw new RuntimeException(e);
        } catch (SAXException e) {
            e.getMessage();
        }

        System.out.println(pepe);


    }
}
