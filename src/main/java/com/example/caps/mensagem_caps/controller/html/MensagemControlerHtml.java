package com.example.caps.mensagem_caps.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MensagemControlerHtml {
    @GetMapping("/mensagens/show")
    public String mostrarMensagem() {
        return "pacoteTv/tv";
    }
}
