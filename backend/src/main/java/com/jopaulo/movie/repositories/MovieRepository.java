package com.jopaulo.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jopaulo.movie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
