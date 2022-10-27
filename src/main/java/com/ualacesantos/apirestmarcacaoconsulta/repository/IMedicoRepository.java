package com.ualacesantos.apirestmarcacaoconsulta.repository;

import com.ualacesantos.apirestmarcacaoconsulta.model.MedicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface IMedicoRepository extends JpaRepository<MedicoEntity, Long> {
    @Query(value="SELECT * FROM Medico WHERE nome LIKE ?1 AND sobrenome LIKE ?2", nativeQuery=true)
    Optional<List<MedicoEntity>> findNameFull(String nome, String sobrenome);
}
