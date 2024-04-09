package com.fpippiramide.fortnite.controller;

import com.fpippiramide.fortnite.classes.Juego;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController{

    @GetMapping ("/")
    public String index (Model model){

        ArrayList <Juego> juegos = new ArrayList<>();
        juegos.add(new Juego("LEGO Fortnite", "87,7", "images/lego.jpg"));
        juegos.add(new Juego("Roquet Racing", "10,7", "images/rocket.jpg"));
        juegos.add(new Juego("Escenario Principal de Festival", "18,5", "images/festival.jpg"));
        juegos.add(new Juego("Escenario de improvisación",  "1,6", "images/impro.jpg"));

        model.addAttribute("juegos", juegos);

        return "index";

    }

}
