package com.example.ExpressMovies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ExpressMovies.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}