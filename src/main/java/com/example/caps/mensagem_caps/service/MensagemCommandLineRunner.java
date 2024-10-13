package com.example.caps.mensagem_caps.service;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MensagemCommandLineRunner implements CommandLineRunner {

    private final MensagemRepository mensagemRepository;

    public MensagemCommandLineRunner(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    @Override
    public void run(String... args) {
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Mês de Outubro", "Falta do mês")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("teste2", "teste teste2")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("teste3", "teste teste3")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("teste4", "teste teste4")));

        System.out.println("Mensagens inseridas com sucesso!");
    }
}
