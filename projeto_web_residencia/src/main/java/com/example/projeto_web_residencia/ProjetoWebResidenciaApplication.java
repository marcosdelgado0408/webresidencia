package com.example.projeto_web_residencia;

import com.example.projeto_web_residencia.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ProjetoWebResidenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoWebResidenciaApplication.class, args);
	}

}
