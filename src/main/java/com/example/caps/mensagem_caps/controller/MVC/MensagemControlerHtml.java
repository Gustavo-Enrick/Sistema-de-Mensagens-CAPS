package com.example.caps.mensagem_caps.controller.MVC;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
@RequestMapping("adm")
public class MensagemControlerHtml {
    @Autowired
    private MensagemRepository mensagemRepository;
    @GetMapping("/show")
    public String showListaMensagem(Model model) {
        List<MensagemModel> modelList =  mensagemRepository.findAll();
        model.addAttribute("mensagens",modelList);
        return "pacoteTv/tv";
    }

    @GetMapping("/create")
    public String createMensagem(Model model) {
        MensagemDTO mensagemDTO = new MensagemDTO("","");
        model.addAttribute("mensagemDTO",mensagemDTO);
        return "pacoteTv/createMensagem";
    }

    @GetMapping("/edit")
    public String editMensagem(Model model) {
        return "pacoteTv/editMensagem";
    }

    @GetMapping("/destroy")
    public String destroyMensagem(Model model) {
        return "pacoteTv/destroyMensagem";
    }
}
