package com.mycompany.dvdstore.core.repository;

import java.util.List;

import com.mycompany.dvdstore.core.entity.Movie;

public interface IMovieRepository 
{
	public Movie add(Movie movie);
	
	public List<Movie> list();
	
	public Movie getById(Long id);
}
