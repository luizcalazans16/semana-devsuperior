package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dtos.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public Movie saveScore(ScoreDTO scoreDTO) {
        Movie movie;
        User user = userRepository.findByEmail(scoreDTO.getEmail());

        if (ObjectUtils.isEmpty(user)) {
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Optional<Movie> optMovie = movieRepository.findById(scoreDTO.getMovieId());

        if (optMovie.isEmpty()) {
            return null;
        }
        movie = optMovie.get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }

        double avarage = sum / movie.getScores().size();

        movie.setScore(avarage);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return movie;
    }
}
