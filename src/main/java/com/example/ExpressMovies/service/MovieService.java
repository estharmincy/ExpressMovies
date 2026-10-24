package com.example.ExpressMovies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ExpressMovies.entity.Movie;
import com.example.ExpressMovies.repository.MovieRepository;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Add Movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // View All Movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // View Movie By ID
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Movie not found with ID: " + id));
    }

    // Update Movie
    public Movie updateMovie(Long id, Movie movie) {

        Movie existingMovie = getMovieById(id);

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setPrice(movie.getPrice());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setRating(movie.getRating());

        return movieRepository.save(existingMovie);
    }

    // Delete Movie
    public void deleteMovie(Long id) {

        Movie movie = getMovieById(id);

        movieRepository.delete(movie);
    }
}