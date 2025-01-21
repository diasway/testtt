package controllers.interfaces;

import models.Movie;

public interface IMovieController {
    String createMovie(Movie movie);
    String getMovieById(int id);
    String getAllMovies();
}
