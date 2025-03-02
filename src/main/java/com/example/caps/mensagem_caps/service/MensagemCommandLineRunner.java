package com.example.caps.mensagem_caps.service;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Component
public class MensagemCommandLineRunner implements CommandLineRunner {

    @Autowired
    private MensagemRepository mensagemRepository;

    @Override
    @Transactional
    public void run(String... args) {
        HashMap<String, String> dadosMap = new HashMap<>();
        dadosMap.put("Plantão", "Plantão às quartas e sextas: senhas às 7h, atendimento às 8h. Limitado a 10 senhas por dia!");
        dadosMap.put("Acolhimento", "Acolhimento: Segunda, Quarta,Quinta e Sexta. Senhas às 7h, atendimento às 8h; Terça: senhas às 12h, atendimento às 13h. Limite de 8 senhas por dia!");
        dadosMap.put("Silêncio", "Mantenha o silêncio no local !");

        for (String nome : dadosMap.keySet()) {
            try {
                mensagemRepository.save(new MensagemModel(new MensagemDTO(nome, dadosMap.get(nome))));
                System.out.println("Mensagem inserida com sucesso");
            } catch (Exception e) {
                System.err.println("Erro ao salvar mensagem: " + e.getMessage());
            }

        }
    }
}