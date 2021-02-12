package com.example.mss;

import com.example.mss.entity.Client;
import com.example.mss.restrepository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientMssApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientMssApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, RepositoryRestConfiguration repositoryRestConfigurer) {
        return args -> {
            repositoryRestConfigurer.exposeIdsFor(Client.class);
            clientRepository.save(new Client(null, "yasser", "yasser@gmail.com"));
            clientRepository.save(new Client(null, "achraf", "achraf@gmail.com"));
            clientRepository.save(new Client(null, "ali", "ali@gmail.com"));

        };
    }
}
