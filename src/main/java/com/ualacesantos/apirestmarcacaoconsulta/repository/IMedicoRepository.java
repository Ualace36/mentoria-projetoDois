package com.ualacesantos.apirestmarcacaoconsulta.repository;

import com.ualacesantos.apirestmarcacaoconsulta.model.MedicoEntity;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoRepository extends JpaRepository<MedicoEntity, Long> {
}
