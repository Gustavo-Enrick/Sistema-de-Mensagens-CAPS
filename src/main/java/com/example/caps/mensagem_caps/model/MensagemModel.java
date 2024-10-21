package com.example.caps.mensagem_caps.model;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "MENSAGEM")
@SequenceGenerator(name = "seq_mensagem", sequenceName = "seq_mensagem", allocationSize = 1, initialValue = 1)
public class MensagemModel implements Serializable {

    public MensagemModel(){}

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mensagem")
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    @Column(name = "nm_mensagem")
    private String nameMensagem;

    public String getNameMensagem() {
        return nameMensagem;
    }

    public void setNameMensagem(String nameMensagem) {
        this.nameMensagem = nameMensagem;
    }

    public String getDescricaoMensagem() {
        return descricaoMensagem;
    }

    public void setDescricaoMensagem(String descricaoMensagem) {
        this.descricaoMensagem = descricaoMensagem;
    }

    @Column(name = "ds_mensagem", length = 500)
    private String descricaoMensagem;

    public MensagemModel(MensagemDTO mensagemDTO) {
        this.nameMensagem = mensagemDTO.nameMensagem();
        this.descricaoMensagem = mensagemDTO.descricaoMensagem();
    }
}