package com.example.projeto_web_residencia;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.example.projeto_web_residencia.config.RsaKeyProperties;
//import ufrn.br.aulaspringrest.model.*;
//import ufrn.br.aulaspringrest.repository.*;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class AulaSpringRestApplication implements CommandLineRunner {


    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(AulaSpringRestApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
