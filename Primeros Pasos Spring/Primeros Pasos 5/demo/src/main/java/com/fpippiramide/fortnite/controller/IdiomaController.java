package com.fpippiramide.fortnite.controller;

import com.fpippiramide.fortnite.classes.Idioma;
import com.fpippiramide.fortnite.classes.Juego;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class IdiomaController {
    @GetMapping("/create_idioma")
    public String mostrar_crear_idioma (Model model){

        Idioma idioma = new Idioma();
        model.addAttribute("idioma", idioma);

        return "create_idioma";

    }
    @PostMapping("/create_idioma")
    public String crear_idioma(@ModelAttribute Idioma idioma, Model model){

        System.out.println(idioma.toString());

        return "create_idioma_confirmacion";
    }
}
