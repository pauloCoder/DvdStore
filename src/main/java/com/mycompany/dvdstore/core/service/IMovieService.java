package com.mycompany.dvdstore.core.service;

import java.util.List;
import java.util.Optional;

import com.mycompany.dvdstore.core.entity.Movie;

public interface IMovieService 
{
	public Movie registerMovie(Movie movie);
	
	public Iterable<Movie> getMovieList();
	
	public Movie getMovieById(Long id);
}
