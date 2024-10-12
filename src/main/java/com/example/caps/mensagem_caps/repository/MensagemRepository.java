package com.example.caps.mensagem_caps.repository;

import com.example.caps.mensagem_caps.model.MensagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemModel, BigInteger> {
}
