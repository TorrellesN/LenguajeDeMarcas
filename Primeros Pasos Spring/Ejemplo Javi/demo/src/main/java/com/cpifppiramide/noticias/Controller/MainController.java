package com.cpifppiramide.noticias.Controller;

import com.cpifppiramide.noticias.classes.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String index(Model model) {

        Persona persona = new Persona("Javi", "Fuertes");

        model.addAttribute("persona", persona);

        return "index";
    }

    @GetMapping("/usuario")
    public String usuario() {
        return "usuario";
    }
}