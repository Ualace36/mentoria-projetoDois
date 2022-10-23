package com.ualacesantos.apirestmarcacaoconsulta.model;

import javax.persistence.*;

@Entity
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paciente", nullable = false)
    private Long idPaciente;

    private String nome;
    private String sobrenome;
    private String cpf;
    @OneToOne
    @JoinColumn(name = "endereco_entity_cep")
    private EnderecoEntity enderecoEntity;

    public EnderecoEntity getEnderecoEntity() {
        return enderecoEntity;
    }

    public void setEnderecoEntity(EnderecoEntity enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
