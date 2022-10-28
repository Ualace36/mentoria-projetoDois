package com.ualacesantos.apirestmarcacaoconsulta.service.serviceImpl;

import com.ualacesantos.apirestmarcacaoconsulta.model.ConsultaEntity;
import com.ualacesantos.apirestmarcacaoconsulta.model.EnderecoEntity;
import com.ualacesantos.apirestmarcacaoconsulta.model.MedicoEntity;
import com.ualacesantos.apirestmarcacaoconsulta.model.PacienteEntity;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IConsultaRepository;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IMedicoRepository;
import com.ualacesantos.apirestmarcacaoconsulta.repository.IPacienteRepository;
import com.ualacesantos.apirestmarcacaoconsulta.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static org.bouncycastle.asn1.x500.style.BCStyle.T;
@Service
public class ConsultaService implements IService<ConsultaEntity> {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private IConsultaRepository consultaRepository;


    @Override
    public ConsultaEntity getById(@PathVariable Long id) {
        Optional<ConsultaEntity> consultaEntity = consultaRepository.findById(id);
        return consultaEntity.get();
    }

    @Override
    public Iterable<ConsultaEntity> getByAll() {
        return consultaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
       consultaRepository.deleteById(id);
    }

    public ConsultaEntity atualizar(Long id, ConsultaEntity consultaEntity) {
        Optional<ConsultaEntity> consultadb = consultaRepository.findById(id);
        if(consultadb.isPresent()) {
            Long idMedico = consultaEntity.getMedico().getIdMedico();
            MedicoEntity medico = medicoRepository.findById(idMedico).orElseGet(() -> {
                medicoRepository.save(new MedicoEntity());
                return new MedicoEntity();
            });
            consultaEntity.setMedico(medico);
            consultaRepository.save((consultaEntity));

            Long idPaciente = consultaEntity.getPaciente().getIdPaciente();
            PacienteEntity pacienteEntity = pacienteRepository.findById(idPaciente).orElseGet(() -> {
                pacienteRepository.save(new PacienteEntity());
                return new PacienteEntity();
            });

            consultaEntity.setPaciente(pacienteEntity);
            consultaRepository.save(consultaEntity);

        }
        return consultaEntity;
    }

    public ConsultaEntity create(ConsultaEntity consulta) {
        Long idPaciente = consulta.getPaciente().getIdPaciente();
        PacienteEntity paciente = pacienteRepository.findById(idPaciente).orElseGet(() -> {

            pacienteRepository.save(new PacienteEntity());

            return new PacienteEntity();
        });
        consulta.setPaciente (paciente);
        consultaRepository.save(consulta);
        return consulta;
    }


}
