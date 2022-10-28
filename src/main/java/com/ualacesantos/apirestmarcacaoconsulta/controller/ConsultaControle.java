package com.ualacesantos.apirestmarcacaoconsulta.controller;

import com.ualacesantos.apirestmarcacaoconsulta.model.ConsultaEntity;
import com.ualacesantos.apirestmarcacaoconsulta.service.serviceImpl.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaControle {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<Iterable<ConsultaEntity>> getAll(){
        return ResponseEntity.ok(consultaService.getByAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaEntity> getById(@PathVariable Long id){
        return ResponseEntity.ok(consultaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaEntity> criar(@RequestBody ConsultaEntity consulta){
        consultaService.create(consulta);
        return ResponseEntity.ok(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaEntity> update(@PathVariable Long id, @RequestBody ConsultaEntity consulta){
        consultaService.atualizar(id, consulta);
        return ResponseEntity.ok(consulta);
    }
}
