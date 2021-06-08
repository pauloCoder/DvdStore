package com.mycompany.dvdstore.core.service;

import java.util.List;

import com.mycompany.dvdstore.core.entity.Movie;

public interface IMovieService 
{
	public Movie registerMovie(Movie movie);
	
	public List<Movie> getMovieList();
	
	public Movie getMovieById(Long id);
}
