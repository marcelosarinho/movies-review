package com.marcelosarinho.moviereview.config;

import com.marcelosarinho.moviereview.entity.*;
import com.marcelosarinho.moviereview.entity.enums.Interest;
import com.marcelosarinho.moviereview.repository.*;
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
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private WatchlistRepository watchlistRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Usuário 1", "usuario1@email.com", passwordEncoder.encode("123456"), LocalDateTime.now(), LocalDateTime.now());
        User u2 = new User(null, "Usuário 2", "usuario2@email.com", passwordEncoder.encode("123456"), LocalDateTime.now(), LocalDateTime.now());
        User u3 = new User(null, "Usuário 3", "usuario3@email.com", passwordEncoder.encode("123456"), LocalDateTime.now(), LocalDateTime.now());
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Genre g1 = new Genre(null, "Terror", LocalDateTime.now(), LocalDateTime.now());
        Genre g2 = new Genre(null, "Aventura", LocalDateTime.now(), LocalDateTime.now());
        Genre g3 = new Genre(null, "Ficção Científica", LocalDateTime.now(), LocalDateTime.now());
        Genre g4 = new Genre(null, "Comédia", LocalDateTime.now(), LocalDateTime.now());
        Genre g5 = new Genre(null, "Ação", LocalDateTime.now(), LocalDateTime.now());
        Genre g6 = new Genre(null, "Suspense", LocalDateTime.now(), LocalDateTime.now());
        genreRepository.saveAll(Arrays.asList(g1, g2, g3, g4, g5, g6));

        Movie m1 = new Movie(null, "Halloween: A Noite do Terror", 1978, LocalDateTime.now(), LocalDateTime.now());
        Movie m2 = new Movie(null, "Transformers 3", 2011, LocalDateTime.now(), LocalDateTime.now());
        Movie m3 = new Movie(null, "Blade Runner 2049", 2017, LocalDateTime.now(), LocalDateTime.now());
        Movie m4 = new Movie(null, "Shaft", 2019, LocalDateTime.now(), LocalDateTime.now());
        Movie m5 = new Movie(null, "O Poderoso Chefão", 1972, LocalDateTime.now(), LocalDateTime.now());
        Movie m6 = new Movie(null, "Pulp Fiction: Tempo de Violência", 1994, LocalDateTime.now(), LocalDateTime.now());
        Movie m7 = new Movie(null, "Interestelar", 2014, LocalDateTime.now(), LocalDateTime.now());
        Movie m8 = new Movie(null, "Clube da Luta", 1999, LocalDateTime.now(), LocalDateTime.now());
        Movie m9 = new Movie(null, "Matrix", 1999, LocalDateTime.now(), LocalDateTime.now());
        Movie m10 = new Movie(null, "Gladiador", 2000, LocalDateTime.now(), LocalDateTime.now());

        m1.getGenres().add(g1);
        m2.getGenres().add(g5);
        m2.getGenres().add(g2);
        m3.getGenres().add(g3);
        m4.getGenres().add(g5);
        m4.getGenres().add(g6);
        m5.getGenres().add(g5);
        m5.getGenres().add(g6);
        m6.getGenres().add(g6);
        m6.getGenres().add(g4);
        m7.getGenres().add(g3);
        m7.getGenres().add(g2);
        m8.getGenres().add(g6);
        m8.getGenres().add(g4);
        m9.getGenres().add(g3);
        m9.getGenres().add(g5);
        m10.getGenres().add(g5);
        m10.getGenres().add(g2);
        movieRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9, m10));

        Review r1 = new Review(null, 5, "Clássico absoluto do terror.", u1, m1, LocalDateTime.now(), LocalDateTime.now());
        Review r2 = new Review(null, 3, "Bom entretenimento, mas exagerado nos efeitos.", u2, m2, LocalDateTime.now(), LocalDateTime.now());
        Review r3 = new Review(null, 5, "Visual incrível e história profunda.", u3, m3, LocalDateTime.now(), LocalDateTime.now());
        Review r4 = new Review(null, 4, "Filme de ação sólido.", u1, m4, LocalDateTime.now(), LocalDateTime.now());
        Review r5 = new Review(null, 5, "Uma obra-prima do cinema.", u2, m5, LocalDateTime.now(), LocalDateTime.now());
        Review r6 = new Review(null, 4, "Diálogos memoráveis.", u3, m6, LocalDateTime.now(), LocalDateTime.now());
        Review r7 = new Review(null, 5, "Uma das melhores ficções científicas já feitas.", u1, m7, LocalDateTime.now(), LocalDateTime.now());
        Review r8 = new Review(null, 4, "Muito provocativo e diferente.", u2, m8, LocalDateTime.now(), LocalDateTime.now());
        Review r9 = new Review(null, 5, "Revolucionário para a época.", u3, m9, LocalDateTime.now(), LocalDateTime.now());
        Review r10 = new Review(null, 4, "Grande épico histórico.", u1, m10, LocalDateTime.now(), LocalDateTime.now());
        Review r11 = new Review(null, 4, "Atmosfera muito boa.", u2, m1, LocalDateTime.now(), LocalDateTime.now());
        Review r12 = new Review(null, 2, "História meio fraca.", u3, m2, LocalDateTime.now(), LocalDateTime.now());
        Review r13 = new Review(null, 4, "", u1, m3, LocalDateTime.now(), LocalDateTime.now());
        Review r14 = new Review(null, 5, "", u2, m7, LocalDateTime.now(), LocalDateTime.now());

        reviewRepository.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14));

        Watchlist w1 = new Watchlist(null, m1, u1, Interest.HIGH, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w2 = new Watchlist(null, m3, u1, Interest.MEDIUM, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w3 = new Watchlist(null, m7, u1, Interest.HIGH, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w4 = new Watchlist(null, m2, u2, Interest.LOW, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w5 = new Watchlist(null, m5, u2, Interest.HIGH, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w6 = new Watchlist(null, m9, u2, Interest.MEDIUM, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w7 = new Watchlist(null, m4, u3, Interest.MEDIUM, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w8 = new Watchlist(null, m6, u3, Interest.HIGH, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w9 = new Watchlist(null, m8, u3, Interest.LOW, LocalDateTime.now(), LocalDateTime.now());
        Watchlist w10 = new Watchlist(null, m10, u3, Interest.HIGH, LocalDateTime.now(), LocalDateTime.now());
        watchlistRepository.saveAll(Arrays.asList(w1, w2, w3, w4, w5, w6, w7, w8, w9, w10));
    }
}
