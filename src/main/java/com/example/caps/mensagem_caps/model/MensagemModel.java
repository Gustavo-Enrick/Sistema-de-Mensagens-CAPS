package com.example.caps.mensagem_caps.model;

import com.example.caps.mensagem_caps.DTO.MensagemDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table(name = "MENSAGEM")
@SequenceGenerator(name = "seq_mensagem", sequenceName = "seq_mensagem", allocationSize = 1, initialValue = 1)
@NoArgsConstructor
public class MensagemModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mensagem")
    @Getter
    private BigInteger id;

    @Setter
    @Getter
    @Column(name = "nm_mensagem")
    private String nameMensagem;

    @Setter
    @Getter
    @Column(name = "ds_mensagem",length = 500)
    private String descricaoMensagem;

    public MensagemModel(MensagemDTO mensagemDTO){
        this.nameMensagem = mensagemDTO.nameMensagem();
        this.descricaoMensagem = mensagemDTO.descricaoMensagem();
    }

}
