package com.ualacesantos.apirestmarcacaoconsulta.controller;

import com.ualacesantos.apirestmarcacaoconsulta.model.PacienteEntity;
import com.ualacesantos.apirestmarcacaoconsulta.service.serviceImpl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Iterable<PacienteEntity>> getAll(){
        return ResponseEntity.ok(pacienteService.getByAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PacienteEntity> inserir(@RequestBody PacienteEntity pacienteEntity){
        pacienteService.create(pacienteEntity);
        return ResponseEntity.ok(pacienteEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteEntity> atualizar(@PathVariable Long id, @RequestBody PacienteEntity pacienteEntity){
      pacienteService.atualizar( id, pacienteEntity);
      return ResponseEntity.ok(pacienteEntity);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
