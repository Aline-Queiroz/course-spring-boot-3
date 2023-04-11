package com.alinequeiroz.workshopmongo.config;

import com.alinequeiroz.workshopmongo.domain.Post;
import com.alinequeiroz.workshopmongo.domain.User;
import com.alinequeiroz.workshopmongo.dto.AuthorDTO;
import com.alinequeiroz.workshopmongo.dto.CommentDTO;
import com.alinequeiroz.workshopmongo.repository.PostRepository;
import com.alinequeiroz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User mariah = new User(null, "Mariah Carrey", "mariah@gmail.com");
        User alef = new User(null, "Joseph Alef", "alef@gmail.com");
        User tobby = new User(null, "Tobby Miguire", "Tobby@gmail.com");

        userRepository.saveAll(Arrays.asList(mariah, alef, tobby));

        Post post1 = new Post(null, sdf.parse("09/04/2022"), "Partiu viagem", "Vou viajar para Serra Verde. Abraços!", new AuthorDTO(mariah));
        Post post2 = new Post(null, sdf.parse("05/04/2022"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(mariah));
        Post post3 = new Post(null, sdf.parse("06/04/2022"), "Boa noite", "hoje foi um dia muito especial!", new AuthorDTO(alef));

        CommentDTO c1 = new CommentDTO("Boa viagem Amiga!", sdf.parse("09/04/2022"), new AuthorDTO(tobby));
        CommentDTO c2 = new CommentDTO("Que Bom!", sdf.parse("05/04/2022"), new AuthorDTO(alef));
        CommentDTO c3 = new CommentDTO("Boa noite! que maravilha!", sdf.parse("05/04/2022"), new AuthorDTO(mariah));

        post1.getComments().add(c1);
        post2.getComments().add(c2);
        post3.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1,post2,post3));

        mariah.getPosts().addAll(Arrays.asList(post1,post2));
        alef.getPosts().add(post3);

        userRepository.save(mariah);
        userRepository.save(alef);
    }
}
