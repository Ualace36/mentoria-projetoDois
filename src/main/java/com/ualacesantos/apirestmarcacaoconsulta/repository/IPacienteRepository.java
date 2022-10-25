package com.ualacesantos.apirestmarcacaoconsulta.repository;

import com.ualacesantos.apirestmarcacaoconsulta.model.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
