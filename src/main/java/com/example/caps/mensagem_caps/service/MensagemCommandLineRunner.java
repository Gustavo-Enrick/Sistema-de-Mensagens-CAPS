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
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Evento de Halloween", "Prepare-se para o Halloween!")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Promoção de Natal", "Descontos incríveis para o Natal!")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Ano Novo", "Boas festas e um próspero Ano Novo!")));

        System.out.println("Mensagens inseridas com sucesso!");
    }
}
