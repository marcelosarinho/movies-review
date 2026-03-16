package com.marcelosarinho.moviereview.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título é obrigatório!")
    private String title;

    private Integer releaseYear;

    @ManyToMany
    @JoinTable(
            name = "movies_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private Set<Watchlist> watchlist = new HashSet<>();

    public Movie(Long id, String title, Integer releaseYear, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", releaseYear=" + releaseYear +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
