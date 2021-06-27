package com.mycompany.dvdstore.core.repository;


import org.springframework.data.repository.CrudRepository;

import com.mycompany.dvdstore.core.entity.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Long>
{
	/**
	public Movie add(Movie movie);
	
	public List<Movie> list();
	
	public Movie getById(Long id);
	*/
}
