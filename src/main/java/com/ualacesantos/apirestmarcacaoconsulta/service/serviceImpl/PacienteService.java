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
public class PacienteService implements IService {
    @Autowired
    private IViaCepService viaCepService;

    @Autowired
    private IEnderecoRepository ienderecoRepository;

    @Autowired
    private IPacienteRepository ipacienteRepository;

    @Override
    public PacienteEntity getById(@PathVariable Long id) {
        Optional<PacienteEntity> pacienteEntity = ipacienteRepository.findById(id);
        return pacienteEntity.get();
    }

    @Override
    public Iterable<PacienteEntity> getByAll() {
        return ipacienteRepository.findAll();
    }

    @Override
    public void delete(@PathVariable Long id) {
        ipacienteRepository.deleteById(id);
    }

    @Override
    public PacienteEntity atualizar(Long id, PacienteEntity pacienteEntity) {
        Optional<PacienteEntity> pacientedb = ipacienteRepository.findById(id);
        if(pacientedb.isPresent()){
            String cep = pacienteEntity.getEndereco().getCep();
            EnderecoEntity enderecoEntity = ienderecoRepository.findById(cep).orElseGet(() -> {
                EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
                ienderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            pacienteEntity.setEnderecoEntity(enderecoEntity);
            ienderecoRepository.save(enderecoEntity);
        }
        return pacienteEntity;
    }

    @Override
    public PacienteEntity create(PacienteEntity pacienteEntity) {
        String cep = pacienteEntity.getEndereco().getCep();
        EnderecoEntity enderecoEntity = ienderecoRepository.findById(cep).orElseGet(() -> {
           EnderecoEntity novoEndereco = viaCepService.consultarCep(cep);
           ienderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pacienteEntity.setEnderecoEntity(enderecoEntity);
         ipacienteRepository.save(pacienteEntity);
        return pacienteEntity;
    }

}
