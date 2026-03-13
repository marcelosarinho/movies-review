package com.marcelosarinho.moviereview.entity;

import com.marcelosarinho.moviereview.entity.enums.Interest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(
        name = "watchlists",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "movie_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer interest;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Watchlist(Long id, Movie movie, User user, Interest interest, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.movie = movie;
        this.user = user;
        setInterest(interest);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private Interest getInterest() {
        return Interest.valueOf(interest);
    }

    private void setInterest(Interest interest) {
        if (interest != null) {
            this.interest = interest.getCode();
        }
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Watchlist watchlist = (Watchlist) o;
        return Objects.equals(id, watchlist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Watchlist{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
