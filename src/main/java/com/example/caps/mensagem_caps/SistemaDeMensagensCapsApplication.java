package com.example.caps.mensagem_caps;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import com.example.caps.mensagem_caps.model.MensagemModel;
import com.example.caps.mensagem_caps.repository.MensagemRepository;
import com.example.caps.mensagem_caps.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaDeMensagensCapsApplication{

	public static void main(String[] args) {
		SpringApplication.run(SistemaDeMensagensCapsApplication.class, args);
	}

}
