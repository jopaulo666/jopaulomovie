package com.jopaulo.movie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jopaulo.movie.dto.MovieDTO;
import com.jopaulo.movie.dto.ScoreDTO;
import com.jopaulo.movie.entities.Movie;
import com.jopaulo.movie.entities.Score;
import com.jopaulo.movie.entities.User;
import com.jopaulo.movie.repositories.MovieRepository;
import com.jopaulo.movie.repositories.ScoreRepository;
import com.jopaulo.movie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}

		double avg = sum / movie.getScores().size(); // média

		movie.setScore(avg);
		movie.setCount(movie.getScores().size()); // total

		movie = movieRepository.save(movie);

		return new MovieDTO(movie);

	}
}
