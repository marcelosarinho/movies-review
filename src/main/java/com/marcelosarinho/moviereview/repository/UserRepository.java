package com.marcelosarinho.moviereview.repository;

import com.marcelosarinho.moviereview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
