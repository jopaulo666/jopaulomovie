package com.jopaulo.movie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jopaulo.movie.entities.Score;
import com.jopaulo.movie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
