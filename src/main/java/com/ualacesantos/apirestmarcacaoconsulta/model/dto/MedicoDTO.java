package com.ualacesantos.apirestmarcacaoconsulta.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicoDTO {
    private Long idMedico;
    private String name;
    private String sobrenome;
    private String crm;

    public MedicoDTO() {
    }

    public MedicoDTO(Long idMedico, String name, String sobrenome, String crm) {
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
