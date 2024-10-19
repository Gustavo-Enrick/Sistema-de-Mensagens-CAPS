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
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Mês de Outubro", "No mês de Outubro tivemos 60 faltas. Se não for conseguir vir,avise com antecedência,sua falta pode dar lugar a quem mais precisa.")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Acolhimento", "O acolhimento de hoje será feito pela Enfermeira Rosana.\n" +
                "                                                        Distribuição das senhas será feito às 8:00 EM PONTO.")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Promoção de Natal", "Descontos incríveis para o Natal!")));
        mensagemRepository.save(new MensagemModel(new MensagemDTO("Ano Novo", "Boas festas e um próspero Ano Novo!")));

        System.out.println("Mensagens inseridas com sucesso!");
    }
}
