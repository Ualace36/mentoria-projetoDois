package com.ualacesantos.apirestmarcacaoconsulta.service.serviceImpl;

import com.ualacesantos.apirestmarcacaoconsulta.model.MedicoEntity;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IConsultaRepository;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IMedicoRepository;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IPacienteRepository;
import com.ualacesantos.apirestmarcacaoconsulta.service.IService;
import org.hibernate.engine.spi.ManagedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class MedicoService implements IService<MedicoEntity> {
    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IConsultaRepository consultaRepository;

    @Override
    public MedicoEntity getById(@PathVariable Long id) {
        Optional<MedicoEntity> medicoEntity = medicoRepository.findById(id);
        return medicoEntity.get();
    }

    @Override
    public Iterable<MedicoEntity> getByAll() {
        return medicoRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        medicoRepository.deleteById(id);
    }

    public MedicoEntity atualizar(Long id, MedicoEntity medicoEntity) {
        Optional<MedicoEntity> medicodb = medicoRepository.findById(id);
        if (medicodb.isPresent()) {
            medicoRepository.save(medicoEntity);
        }
        return medicoEntity;
    }

    public MedicoEntity create(MedicoEntity medico){
        medicoRepository.save(medico);
        return medico;
    }

}
