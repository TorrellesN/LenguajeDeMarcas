package Enunciado5;

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

public class XMLReader5 {
    public static void main(String[] args) {
        File file = new File ("resources/enunciado5_actividad_5_2.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        ArrayList<Perro> listaPerros = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element elementoRaiz = document.getDocumentElement();

            NodeList nodosPerros = elementoRaiz.getElementsByTagName("perro");

            for (int i = 0; i < nodosPerros.getLength(); i++){

                Element elementoNombre = (Element)(((Element)nodosPerros.item(i)).getElementsByTagName("nombre").item(0));
                String nombre = elementoNombre.getTextContent();

                Element elementoEdad = (Element)(((Element)nodosPerros.item(i)).getElementsByTagName("edad").item(0));
                int edad = Integer.parseInt(elementoEdad.getTextContent());

                Element elementoVacunado = (Element)(((Element)nodosPerros.item(i)).getElementsByTagName("vacunado").item(0));
                boolean vacunado;
                if (elementoVacunado.getTextContent().equals("Sí")){
                    vacunado = true;
                }else {vacunado = false;}

                Element elementoPeso = (Element)(((Element)nodosPerros.item(i)).getElementsByTagName("peso").item(0));
                Float peso = Float.parseFloat(elementoPeso.getTextContent());

                Element elementoColorPelo = (Element)(((Element)nodosPerros.item(i)).getElementsByTagName("color_de_pelo").item(0));
                String colorPelo = elementoColorPelo.getTextContent();

                listaPerros.add(new Perro(nombre, edad, vacunado, peso, colorPelo));

            }

        } catch (ParserConfigurationException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (SAXException e) {
            e.getMessage();
        }

        for (Perro perro : listaPerros){
            System.out.println(perro);
        }

    }


}
