package com.example.Ej62.controller;

import com.example.Ej62.classes.Cuenta;
import com.example.Ej62.classes.Editor;
import com.example.Ej62.classes.Video;
import com.example.Ej62.repositories.CuentaRepository;
import com.example.Ej62.repositories.EditorRepository;
import com.example.Ej62.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.yaml.snakeyaml.reader.StreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Set;

@Controller
public class YoutubeController {

    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    EditorRepository editorRepository;

    @GetMapping ("/youtube_xml")
    public String youtubeXML(){

        List<Cuenta> cuentas = cuentaRepository.findAll();
        /*for(Cuenta cuenta: cuentas){
            System.out.println(cuenta);
        }*/

        File file = new File("./src/main/resources/templates/youtube_xml.xml");


        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element elementYoutube = document.createElement("youtube");
            document.appendChild(elementYoutube);

            Element elementCuentas = document.createElement("cuentas");
            elementYoutube.appendChild(elementCuentas);

            for (int i = 0; i < cuentas.size(); i++){

                Element elementCuenta = document.createElement("cuenta");
                elementCuenta.setAttribute("nombre", cuentas.get(i).getNombre());
                elementCuentas.appendChild(elementCuenta);

                //EDITOR
                Editor editor = cuentas.get(i).getEditor();
                Element elementEditor = document.createElement("editor");
                elementEditor.setAttribute("edad", String.valueOf(editor.getEdad()));
                elementCuenta.appendChild(elementEditor);

                Element elementNombreEditor = document.createElement("nombre");
                elementNombreEditor.setTextContent(editor.getNombre());
                elementEditor.appendChild(elementNombreEditor);

                Element elementoEmailEditor = document.createElement("email");
                elementoEmailEditor.setTextContent(editor.getEmail());
                elementEditor.appendChild(elementoEmailEditor);

                //VIDEOS

                List<Video> videos = (cuentas.get(i)).getVideos();

                if(!videos.isEmpty()){
                    Element elementVideos = document.createElement("videos");
                    elementCuenta.appendChild(elementVideos);
                    //recorrer lista para generar cada info de videos
                    for(int g = 0; g < videos.size(); g++){
                        Video video = videos.get(g);

                        Element elementVideo = document.createElement("video");
                        elementVideo.setAttribute("nombre", video.getNombre());
                        elementVideo.setAttribute("likes", String.valueOf(video.getNumeroDeLikes()));
                        elementVideos.appendChild(elementVideo);

                        //elementos de video
                        Element elementDuracion = document.createElement("duracion");
                        elementDuracion.setTextContent(String.valueOf(video.getDuracion()));
                        elementVideo.appendChild(elementDuracion);

                        Element elementDescripcion = document.createElement("descripcion");
                        elementDescripcion.setTextContent(video.getDescripcion());
                        elementVideo.appendChild(elementDescripcion);
                    }
                }

            }

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, streamResult);





        } catch (Exception e) {
            e.printStackTrace();
        }


        return "youtube_xml.xml";
    }

}
