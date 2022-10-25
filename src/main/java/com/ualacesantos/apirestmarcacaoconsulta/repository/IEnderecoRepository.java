package com.ualacesantos.apirestmarcacaoconsulta.repository;

import com.ualacesantos.apirestmarcacaoconsulta.model.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, String> {
}
