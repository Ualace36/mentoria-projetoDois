package com.ualacesantos.apirestmarcacaoconsulta.service.serviceImpl;

import com.ualacesantos.apirestmarcacaoconsulta.model.EnderecoEntity;
import com.ualacesantos.apirestmarcacaoconsulta.model.PacienteEntity;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IEnderecoRepository;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IPacienteRepository;
import com.ualacesantos.apirestmarcacaoconsulta.service.IService;
import com.ualacesantos.apirestmarcacaoconsulta.service.IViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class PacienteService implements IService<PacienteEntity>{
    @Autowired
    private IViaCepService viaCepService;

    @Autowired
    private IEnderecoRepository ienderecoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public PacienteEntity getById(@PathVariable Long id) {
        Optional<PacienteEntity> pacienteEntity =pacienteRepository.findById(id);
        return pacienteEntity.get();
    }

    @Override
    public Iterable<PacienteEntity> getByAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public void delete(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }


    public PacienteEntity atualizar(Long id, PacienteEntity pacienteEntity) {
        Optional<PacienteEntity> pacientedb = pacienteRepository.findById(id);
        if(pacientedb.isPresent()){
            String cep = pacienteEntity.getEndereco().getCep();
            EnderecoEntity enderecoEntity = ienderecoRepository.findById(cep).orElseGet(() -> {
                EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
                ienderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            pacienteEntity.setEndereco(enderecoEntity);
            pacienteRepository.save(pacienteEntity);
        }
        return pacienteEntity;
    }



    public PacienteEntity create(PacienteEntity pacienteEntity) {
        String cep = pacienteEntity.getEndereco().getCep();
        EnderecoEntity enderecoEntity = ienderecoRepository.findById(cep).orElseGet(() -> {
           EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
           ienderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pacienteEntity.setEndereco(enderecoEntity);
         pacienteRepository.save(pacienteEntity);
        return pacienteEntity;
    }

}
