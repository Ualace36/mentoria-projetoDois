package com.ualacesantos.apirestmarcacaoconsulta.service.serviceImpl;

import com.ualacesantos.apirestmarcacaoconsulta.model.MedicoEntity;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IMedicoRepository;
import com.ualacesantos.apirestmarcacaoconsulta.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static javax.swing.text.html.HTML.Tag.S;
@Service
public class MedicoService implements IService<MedicoEntity> {
    @Autowired
    private IMedicoRepository medicoRepository;

    @Override
    public MedicoEntity getById(@PathVariable Long id) {
        Optional<MedicoEntity> medicoEntity = medicoRepository.findById(id);
        return medicoEntity.get();

    }

    @Override
    public Iterable <MedicoEntity>getByAll() {
        return medicoRepository.findAll();
    }

    @Override
    public void delete(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }


    public MedicoEntity atualizar(Long id, MedicoEntity medicoCriar) {
       MedicoEntity medicoUpdate = getById(id);
       medicoUpdate.setName(medicoCriar.getName());
       medicoUpdate.setSobrenome(medicoCriar.getSobrenome());
       medicoUpdate.setCrm(medicoCriar.getCrm());
        return medicoUpdate;
    }


    public MedicoEntity create(MedicoEntity medicoCriar) {
        Long idMedico = medicoCriar.getIdMedico();
        medicoCriar.setIdMedico(idMedico);
        medicoCriar.setCrm(medicoCriar.getCrm());
        medicoRepository.save(medicoCriar);
        return medicoCriar;


    }
}
