package com.Ej63.xml63.controller;


import com.Ej63.xml63.classes.Gasto;
import com.Ej63.xml63.classes.Profesor;
import com.Ej63.xml63.classes.TipoDeGasto;
import com.Ej63.xml63.repositories.GastoRepository;
import com.Ej63.xml63.repositories.ProfesorRepository;
import com.Ej63.xml63.repositories.TipoDeGastoRepository;
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
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

@Controller
public class InstitutoController {

    @Autowired
    GastoRepository gastoRepository;
    @Autowired
    TipoDeGastoRepository tipoDeGastoRepository;
    @Autowired
    ProfesorRepository profesorRepository;
    @GetMapping("/")
    public String generarInstitutoXML(){

        List<TipoDeGasto> tipoDeGastoList = tipoDeGastoRepository.findAll();
        List<Profesor> profesorList = profesorRepository.findAll();
        List<Gasto> gastoList = gastoRepository.findAll();

        File file = new File("./src/main/resources/templates/instituto_xml.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element elementoInstituto = document.createElement("instituto");
            document.appendChild(elementoInstituto);

            //TIPODEGASTOS
            Element elementTipoDeGastos = document.createElement("tipo_de_gastos");
            elementoInstituto.appendChild(elementTipoDeGastos);

            for (TipoDeGasto tipoDeGasto : tipoDeGastoList) {
                Element elementTipoGasto = document.createElement("tipo_de_gasto");
                elementTipoGasto.setAttribute("id", String.valueOf(tipoDeGasto.getId()));
                elementTipoDeGastos.appendChild(elementTipoGasto);

                Element elementoNombreGasto = document.createElement("nombre_gasto");
                elementoNombreGasto.setTextContent(tipoDeGasto.getNombre());
                elementTipoGasto.appendChild(elementoNombreGasto);
            }

            //PROFESORES
            Element elementoProfesores = document.createElement("profesores");
            elementoInstituto.appendChild(elementoProfesores);

            for (Profesor profesor : profesorList) {
                Element elementoProfesor = document.createElement("profesor");
                elementoProfesor.setAttribute("id", String.valueOf(profesor.getId()));
                elementoProfesor.setAttribute("nombre", profesor.getNombre());
                elementoProfesores.appendChild(elementoProfesor);
            }

            //GASTOS
            Element elementoGastos = document.createElement("gastos");
            elementoInstituto.appendChild(elementoGastos);

            for (Gasto gasto : gastoList){
                Element elementoGasto = document.createElement("gasto");
                elementoGasto.setAttribute("id", String.valueOf(gasto.getId()));
                elementoGastos.appendChild(elementoGasto);

                Element elementoPrecioGasto = document.createElement("precio");
                elementoPrecioGasto.setTextContent(String.valueOf(gasto.getPrecio()));
                elementoGasto.appendChild(elementoPrecioGasto);

                Element elementoTipoGasto = document.createElement("tipo_de_gasto");
                elementoTipoGasto.setTextContent(gasto.getTipoDeGasto().getNombre());
                elementoGasto.appendChild(elementoTipoGasto);

                Element elementoProfesorGasto = document.createElement("profesor");
                elementoProfesorGasto.setTextContent(gasto.getProfesor().getNombre());
                elementoGasto.appendChild(elementoProfesorGasto);

            }

            //CONSTRUIR DOCUMENTO
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, streamResult);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "index";
    }
}
