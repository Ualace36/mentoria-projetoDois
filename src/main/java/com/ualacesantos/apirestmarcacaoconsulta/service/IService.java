package com.ualacesantos.apirestmarcacaoconsulta.service;

import com.ualacesantos.apirestmarcacaoconsulta.model.PacienteEntity;

import java.util.List;

public interface IService <T> {

    T getById(Long id);

    Iterable<T> getByAll();


    void delete(Long id);
}
