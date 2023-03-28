package com.alinequeiroz.workshopmongo.config;

import com.alinequeiroz.workshopmongo.domain.User;
import com.alinequeiroz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User mariah = new User(null, "Mariah Carrey", "mariah@gmail.com");
        User alef = new User(null, "Joseph Alef", "alef@gmail.com");
        User tobby = new User(null, "Tobby Miguire", "Tobby@gmail.com");
        userRepository.saveAll(Arrays.asList(mariah, alef, tobby));
    }
}
