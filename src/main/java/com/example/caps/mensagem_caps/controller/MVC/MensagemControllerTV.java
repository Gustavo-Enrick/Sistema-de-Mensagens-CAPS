package com.example.caps.mensagem_caps.controller.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tv")

public class MensagemControllerTV {
    @GetMapping("/show")
    public String showScreem(Model model) {
        return "pacoteTV/showtv";
    }
}
