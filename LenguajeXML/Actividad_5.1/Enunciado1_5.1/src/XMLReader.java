import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.sound.midi.Soundbank;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.SQLOutput;

public class XMLReader {


    public static void main(String[] args) {
        //hacemos un objeto de la clase DocumentBuilderFactory (lo "instanciamos)
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try{
            //hacemos un document builder con nuestra fábrica, con el método propio de la clase documentBuilderFactory
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            //creamos objeto de la clase File para nuestro documento XML
            File file = new File("resources/5.1_1.xml");
            //parseamos nuestro file a un document. Document es una interfaz capaz de representar archivos xml enteros
            Document document = documentBuilder.parse(file);

            //primero recogemos el elemento raíz
            Element elementoRaiz = document.getDocumentElement();
            System.out.println("Noticia:");

            //en un objeto de tipo elemento, recoge el elemento titulo, que está dentro del elemento Raíz
            Element elementoTitulo = (Element) elementoRaiz.getElementsByTagName("titulo").item(0);
            System.out.println("Titulo: " + elementoTitulo.getTextContent());

            Element elementoCategoria = (Element) elementoRaiz.getElementsByTagName("categoria").item(0);
            System.out.println("Categoría: " + elementoCategoria.getTextContent());

            Element elementoDescripcion = (Element) elementoRaiz.getElementsByTagName("descripcion").item(0);
            System.out.println("Descripción: " + elementoDescripcion.getTextContent());

            Element elementoAutor = (Element) elementoRaiz.getElementsByTagName("autor").item(0);

            //los atributos se obtienen de los elementos como un string y el método getAtribute
            String atributoTwitter = elementoAutor.getAttribute("twitter");
            String atributoEmail = elementoAutor.getAttribute("email");
            System.out.println("Autor: " + elementoAutor.getTextContent() + " | Twitter: " + atributoTwitter + " | Email: " + atributoEmail);


            Noticia noticia = new Noticia(elementoTitulo.getTextContent(),
                    elementoCategoria.getTextContent(), elementoDescripcion.getTextContent(), elementoAutor.getTextContent());




            Element elementoficherosAdjuntos = (Element) elementoRaiz.getElementsByTagName("ficheros_adjuntos").item(0);
            NodeList ficherosAdjuntos = elementoficherosAdjuntos.getElementsByTagName("fichero_adjunto");

            System.out.println(ficherosAdjuntos.getLength());
            for (int i=0; i < ficherosAdjuntos.getLength(); i++){

                //String valorficheroAdjunto = ((Element) ficherosAdjuntos.item(i).getElementsByTagName("fichero_adjunto").item(0)).getTextContent();

                Element elementoNombreFicheroAdjunto = ((Element) ficherosAdjuntos.item(i)).getElementsByTagName("nombre").item(0);
                String elementoNombre = elementoNombreFicheroAdjunto.getTextContent();

            }

        }catch (Exception e){
            e.printStackTrace();
        }





    }
}