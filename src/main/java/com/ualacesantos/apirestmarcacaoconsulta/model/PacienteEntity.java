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
    @JoinColumn(name = "cep", referencedColumnName = "cep")
    @Embedded
    private EnderecoEntity endereco;
    @Column(nullable = false)
    private String rg;
//    @OneToMany(mappedBy = "idConsulta")
//    private Set<ConsultaEntity> consultas;

    public PacienteEntity() {
    }

    public PacienteEntity(Long idPaciente, String nome, String sobrenome, String cpf, EnderecoEntity endereco, String rg) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.rg = rg;
        //this.consultas = consultas;
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
}
//    public Set<ConsultaEntity> getConsultas() {
//        return consultas;
//    }
//
//    public void setConsultas(Set<ConsultaEntity> consultas) {
//        this.consultas = consultas;
//    }
//}
