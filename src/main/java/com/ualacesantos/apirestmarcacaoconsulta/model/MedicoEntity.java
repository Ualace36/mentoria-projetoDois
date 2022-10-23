package com.ualacesantos.apirestmarcacaoconsulta.model;

import javax.persistence.*;

@Entity
@Table(name = "MEDICO")
public class MedicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medico", nullable = false)
    private Long idMedico;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique = true, nullable = false)
    private String crm;

    public MedicoEntity() {
    }

    public MedicoEntity(Long idMedico, String name, String sobrenome, String crm) {
        this.idMedico = idMedico;
        this.name = name;
        this.sobrenome = sobrenome;
        this.crm = crm;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
}
