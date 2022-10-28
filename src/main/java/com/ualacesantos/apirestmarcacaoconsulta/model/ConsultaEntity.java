package com.ualacesantos.apirestmarcacaoconsulta.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_consulta", nullable = false)
    private Long idConsulta;

    @ManyToOne
    @JoinColumn(name = "paciente_id_paciente", nullable = false)
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id_medico",nullable = false)
    @Embedded
    private MedicoEntity medico;
    @Column(nullable = false)
    private LocalDateTime inicioCOnsulta;
    @Column(nullable = false)
    private LocalDateTime fimConsulta;

    public MedicoEntity getMedico() {
        return medico;
    }

    public ConsultaEntity() {
    }

    public ConsultaEntity(Long idConsulta, PacienteEntity paciente, MedicoEntity medico, LocalDateTime inicioCOnsulta, LocalDateTime fimConsulta) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.inicioCOnsulta = inicioCOnsulta;
        this.fimConsulta = fimConsulta;
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public LocalDateTime getInicioCOnsulta() {
        return inicioCOnsulta;
    }

    public void setInicioCOnsulta(LocalDateTime inicioCOnsulta) {
        this.inicioCOnsulta = inicioCOnsulta;
    }

    public LocalDateTime getFimConsulta() {
        return fimConsulta;
    }

    public void setFimConsulta(LocalDateTime fimConsulta) {
        this.fimConsulta = fimConsulta;
    }
}
