package com.example.caps.mensagem_caps.service;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class MensagemCommandLineRunner implements CommandLineRunner {
    @Autowired
    private MensagemRepository mensagemRepository;

    @Override
    public void run(String... args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("bdMensagensPrincipais/mensagens principais").getInputStream()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 2) {
                    String titulo = partes[0].trim();
                    String conteudo = partes[1].trim();

                    if (!titulo.isEmpty() && !conteudo.isEmpty()) {
                        mensagemRepository.save(new MensagemModel(new MensagemDTO(titulo, conteudo)));
                    }
                } else {
                    System.err.println("Formato inválido na linha: " + linha);
                }
            }
            System.out.println("Mensagens inseridas com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}