package com.cpifppiramide.noticias.Controller;

import com.cpifppiramide.noticias.Classes.Noticia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

    @GetMapping("/index")
    public String noticia (Model model){
        Noticia noticia = new Noticia("Los 25 móviles con los diseños más locos que se han visto", "Aunque casi todos los móviles nos parezcan iguales, hay algunos que se salen de la norma...", "Benito Pérez Galdós", "15 de Marzo de 2024");
        model.addAttribute("noticia", noticia);
        return "noticia";
    }

}
