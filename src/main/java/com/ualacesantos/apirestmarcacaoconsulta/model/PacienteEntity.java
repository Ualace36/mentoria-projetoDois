package com.ualacesantos.apirestmarcacaoconsulta.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

    @OneToOne
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    private EnderecoEntity endereco;
    @Column(nullable = false)
    private String rg;
    private LocalDateTime dataDeAlta;
    @OneToMany(mappedBy = "idConsulta")
    private Set<ConsultaEntity> consultas;

    public PacienteEntity() {
    }

    public PacienteEntity(Long idPaciente, String nome, String sobrenome, String cpf, EnderecoEntity enderecoEntity, EnderecoEntity endereco, String rg, LocalDateTime dataDeAlta, Set<ConsultaEntity> consultas) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.enderecoEntity = enderecoEntity;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
        this.consultas = consultas;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoEntity getEnderecoEntity() {
        return enderecoEntity;
    }

    public void setEnderecoEntity(EnderecoEntity enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDateTime getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(LocalDateTime dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public Set<ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<ConsultaEntity> consultas) {
        this.consultas = consultas;
    }
}
