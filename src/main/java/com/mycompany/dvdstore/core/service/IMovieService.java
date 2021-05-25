package com.mycompany.dvdstore.core.service;

import java.util.List;

import com.mycompany.dvdstore.core.entity.Movie;

public interface IMovieService 
{
	public void registerMovie(Movie movie);
	
	public List<Movie> getMovieList();
}
