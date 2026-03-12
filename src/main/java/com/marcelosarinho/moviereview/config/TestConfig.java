package com.marcelosarinho.moviereview.config;

import com.marcelosarinho.moviereview.entity.Genre;
import com.marcelosarinho.moviereview.entity.User;
import com.marcelosarinho.moviereview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Usuário 1", "usuario1@email.com", passwordEncoder.encode("123456"), LocalDateTime.now(), LocalDateTime.now());
        User u2 = new User(null, "Usuário 2", "usuario2@email.com", passwordEncoder.encode("123456"), LocalDateTime.now(), LocalDateTime.now());
        User u3 = new User(null, "Usuário 3", "usuario3@email.com", passwordEncoder.encode("123456"), LocalDateTime.now(), LocalDateTime.now());

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

//        Genre g1 = new Genre(null, "Terror", LocalDateTime.now(), LocalDateTime.now());
//        Genre g2 = new Genre(null, "Aventura", LocalDateTime.now(), LocalDateTime.now());
//        Genre g3 = new Genre(null, "Ficção Científica", LocalDateTime.now(), LocalDateTime.now());
//        Genre g4 = new Genre(null, "Comédia", LocalDateTime.now(), LocalDateTime.now());
//        Genre g5 = new Genre(null, "Ação", LocalDateTime.now(), LocalDateTime.now());
//        Genre g6 = new Genre(null, "Suspense", LocalDateTime.now(), LocalDateTime.now());
    }
}
