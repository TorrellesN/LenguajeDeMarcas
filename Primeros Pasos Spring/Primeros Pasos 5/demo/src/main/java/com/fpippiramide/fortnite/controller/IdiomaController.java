package com.fpippiramide.fortnite.controller;

import com.fpippiramide.fortnite.classes.Idioma;
import com.fpippiramide.fortnite.classes.Juego;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class IdiomaController {
    @GetMapping("/create_idioma")
    public String crear_idioma (Model model){

        Idioma idioma = new Idioma();
        model.addAttribute("idioma", idioma);

        return "create_idioma";

    }
}
