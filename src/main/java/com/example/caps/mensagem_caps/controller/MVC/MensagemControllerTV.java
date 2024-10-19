package com.example.caps.mensagem_caps.controller.MVC;

import com.example.caps.mensagem_caps.model.MensagemModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tv")

public class MensagemControllerTV {
    @GetMapping("/show")
    public String showScreem(Model model) {
        return "pacoteTV/showtv";
    }
}
