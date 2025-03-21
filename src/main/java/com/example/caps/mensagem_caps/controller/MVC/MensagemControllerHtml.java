package com.example.caps.mensagem_caps.controller.MVC;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("adm")
public class MensagemControllerHtml {

    @Autowired
    private MensagemRepository mensagemRepository;

    @GetMapping("/show")
    public String showListaMensagem(Model model) {
        List<MensagemModel> modelList = mensagemRepository.findAll();
        model.addAttribute("mensagens", modelList);
        return "pacoteADM/showMensagem";
    }

    @GetMapping("/create")
    public String createMensagem(Model model) {
        MensagemDTO mensagemDTO = new MensagemDTO("", "");
        model.addAttribute("mensagemDTO", mensagemDTO);
        return "pacoteADM/createMensagem";
    }

    @GetMapping("/edit/{id}")
    public String editMensagem(Model model, @PathVariable BigInteger id) {
        try {
            var mensagem = mensagemRepository.findById(id).orElseThrow();
            model.addAttribute("mensagem", mensagem);
            MensagemDTO mensagemDTO = new MensagemDTO(mensagem.getNameMensagem(), mensagem.getDescricaoMensagem());
            model.addAttribute("mensagemDTO", mensagemDTO);
        } catch (Exception ignored) {
            return "redirect:/show";
        }
        return "pacoteADM/editMensagem";
    }

    @GetMapping("/destroy/{id}")
    public String destroyMensagem(Model model,@PathVariable BigInteger id) {
        try {
            var mensagem = mensagemRepository.findById(id).orElseThrow();
            model.addAttribute("mensagem", mensagem);
            MensagemDTO mensagemDTO = new MensagemDTO(mensagem.getNameMensagem(), mensagem.getDescricaoMensagem());
            model.addAttribute("mensagemDTO", mensagemDTO);
        } catch (Exception ignored) {
            return "redirect:/show";
        }
        return "pacoteADM/destroyMensagem";
    }

    //Retorna a logo da prefeitura
    @GetMapping("/image")
    public ResponseEntity<Resource> getImage() {
        Resource resource = new ClassPathResource("static/img/prefeituraLogo.png");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }

}
