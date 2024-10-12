package com.example.caps.mensagem_caps.controller.REST;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;


@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping()
    public ResponseEntity<List<MensagemModel>> getMensagem(){
        return ResponseEntity.ok(mensagemService.getAll());
    }

    @PostMapping("/create")
    public HttpStatus createMensagem(@RequestBody MensagemDTO mensagemDTO){
        mensagemService.createMensagem(mensagemDTO);
        return HttpStatus.CREATED;
    }

    @PutMapping("/edit/{id}")
    public HttpStatus updateMensagem(@PathVariable BigInteger id, @RequestBody MensagemDTO mensagemDTO){
        mensagemService.updateMensagem(id,mensagemDTO);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/destroy/{id}")
    public HttpStatus deleteMensagem(@PathVariable BigInteger id){
        return mensagemService.deleteMensagem(id);
    }
}
