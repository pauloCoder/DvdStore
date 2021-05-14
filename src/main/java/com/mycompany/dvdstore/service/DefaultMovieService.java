package com.mycompany.dvdstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.IMovieRepository;

@Service
public class DefaultMovieService implements IMovieService
{
	
	@Autowired
	private IMovieRepository movieRepository;
	
	public IMovieRepository getMovieRepository() {
		return movieRepository;
	}

	public void setMovieRepository(IMovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public void registerMovie(Movie movie)
	{
		movieRepository.add(movie);
	}

}
