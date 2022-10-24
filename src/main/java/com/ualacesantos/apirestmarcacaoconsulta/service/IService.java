package com.ualacesantos.apirestmarcacaoconsulta.service;

import com.ualacesantos.apirestmarcacaoconsulta.model.PacienteEntity;

import java.util.List;

public interface IService <T>{

    PacienteEntity getById(Long id);

    Iterable<PacienteEntity> getByAll();


    void delete(PacienteEntity pacienteEntity);

    PacienteEntity atualizar (Long id, PacienteEntity pacienteEntity);
    PacienteEntity create(PacienteEntity pacienteEntity);

}
