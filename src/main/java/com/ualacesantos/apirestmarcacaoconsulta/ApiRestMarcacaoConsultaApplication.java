package com.ualacesantos.apirestmarcacaoconsulta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiRestMarcacaoConsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestMarcacaoConsultaApplication.class, args);
	}

}
