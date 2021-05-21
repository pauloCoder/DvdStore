package com.mycompany.dvdstore.service;

import java.util.List;

import com.mycompany.dvdstore.entity.Movie;

public interface IMovieService 
{
	public void registerMovie(Movie movie);
	
	public List<Movie> getMovieList();
}
