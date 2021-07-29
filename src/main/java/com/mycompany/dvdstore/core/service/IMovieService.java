package com.mycompany.dvdstore.core.service;

import com.mycompany.dvdstore.core.entity.movie.Movie;

@Deprecated
public interface IMovieService 
{
	public Movie registerMovie(Movie movie);
	
	public Iterable<Movie> getMovieList();
	
	public Movie getMovieById(Long id);
}
