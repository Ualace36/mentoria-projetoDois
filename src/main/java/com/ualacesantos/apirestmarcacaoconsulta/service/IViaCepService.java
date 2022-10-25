package com.ualacesantos.apirestmarcacaoconsulta.service;

import com.ualacesantos.apirestmarcacaoconsulta.model.EnderecoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface IViaCepService {
    @GetMapping("/{cep}/json")
    EnderecoEntity consultarCep(@PathVariable ("cep") String cep);
}
