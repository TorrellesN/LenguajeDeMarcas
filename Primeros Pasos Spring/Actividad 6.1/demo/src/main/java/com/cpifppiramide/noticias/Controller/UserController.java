package com.cpifppiramide.noticias.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(Model model){

        return "login";
    }
    @GetMapping("/create_user")
    public String createUser(Model model){

        return "create_user";
    }
}
