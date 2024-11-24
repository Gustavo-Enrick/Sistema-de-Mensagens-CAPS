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
        dadosMap.put("Plantão", "Plantão acontece todas as quartas e sextas. Nas quartas as senhas são distribuídas às 12:00 e o atendimento começa às 13:00. Nas sextas as senhas são distribuídas às 7:00 e o atendimento começa às 8:00. São 10 (DEZ) SENHAS POR PLANTÃO!");
        dadosMap.put("Acolhimento", "Acolhimento acontece todos os dias. Segunda e Terça as senhas são distribuídas às 12:00 e o atendimento começa às 13:00. Quarta, Quinta e Sexta as senhas são distribuídas às 7:00 e o atendimento começa às 8:00. São 8 (OITO) SENHAS POR ACOLHIMENTO!");
        dadosMap.put("Silêncio", "Mantenha o silêncio no local");

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