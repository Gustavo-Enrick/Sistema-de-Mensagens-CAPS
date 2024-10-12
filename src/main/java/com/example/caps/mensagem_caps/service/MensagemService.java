package com.example.caps.mensagem_caps.service;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {
    @Autowired
    private MensagemRepository mensagemRepository;
    //Testar aplicação

    public HttpStatus createMensagem(MensagemDTO mensagemDTO) {
        boolean exists = mensagemRepository.findAll().stream()
                .anyMatch(mensagem -> mensagem.getNameMensagem().equals(mensagemDTO.nameMensagem()));

        if (!exists) {
            var mensagem = new MensagemModel(mensagemDTO);
            mensagemRepository.save(mensagem);
            return HttpStatus.CREATED;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus updateMensagem(BigInteger id, MensagemDTO mensagemDTO) {
        if (existsMensagemById(id)) {
            Optional<MensagemModel> optionalMensagem = getByIdMensagem(id);
            MensagemModel mensagem = optionalMensagem.get();
            mensagem.setNameMensagem(mensagemDTO.nameMensagem());
            mensagem.setDescricaoMensagem(mensagemDTO.descricaoMensagem());
            mensagemRepository.save(mensagem);
            return HttpStatus.ACCEPTED;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public HttpStatus deleteMensagem(BigInteger id) {
        if (existsMensagemById(id)) {
            mensagemRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    private Optional<MensagemModel> getByIdMensagem(BigInteger id) {
        return mensagemRepository.findById(id);
    }

    private boolean existsMensagemById(BigInteger id) {
        return mensagemRepository.existsById(id);
    }

    public List<MensagemModel> getAll() {
        return mensagemRepository.findAll();
    }
}