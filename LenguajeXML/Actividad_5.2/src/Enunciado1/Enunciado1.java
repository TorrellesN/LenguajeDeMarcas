package Enunciado1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class Enunciado1 {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        File file = new File("resources/enunciado1_actividad_5_2.xml");
        ArrayList<Libro> listaObjetosLibro = new ArrayList<>();

        try{

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element elementoRaiz = document.getDocumentElement();

            //Element elementoLibro = (Element)elementoRaiz.getElementsByTagName("libro").item(0);

            NodeList listaLibro = elementoRaiz.getElementsByTagName("libro");

            //variables de los atributos de libro para no tener que crearlas en cada bucle del for
            String titulo;
            String autor = null;
            String genero;
            String anio;

            for (int i = 0; i < listaLibro.getLength(); i++){

                Element elementoTituloLibro = (Element)(((Element)listaLibro.item(i)).getElementsByTagName("titulo").item(0));
                titulo = elementoTituloLibro.getTextContent();

                Element elementoAutorLibro = (Element)(((Element)listaLibro.item(i)).getElementsByTagName("autor").item(0));
                autor = elementoAutorLibro.getTextContent();

                Element elementoGeneroLibro = (Element)(((Element)listaLibro.item(i)).getElementsByTagName("genero").item(0));
                genero = elementoGeneroLibro.getTextContent();

                Element elementoAnioLibro = (Element)(((Element)listaLibro.item(i)).getElementsByTagName("anio").item(0));
                anio = elementoAnioLibro.getTextContent();

                //Se crea un elemento libro en el arraylist a partir de todos los valores
                listaObjetosLibro.add(new Libro(titulo, autor, genero, anio));
            }

        }catch (Exception e){
            e.getMessage();
        }


        //imprimimos libro. también se podía imprimir al mismo tiempo que se ejecutaba el for del try catch anterior
        System.out.println("Biblioteca\n");
        for (Libro libro : listaObjetosLibro){
            System.out.println("Titulo: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Genero: " + libro.getGenero());
            System.out.println("Año de publicación: " + libro.getAnio() + "\n");

        }

    }


}
