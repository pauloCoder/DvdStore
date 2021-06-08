package com.mycompany.dvdstore.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.IMovieRepository;

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
	public Movie registerMovie(Movie movie)
	{
		movieRepository.add(movie);
		return movie;
	}
	
	@Override
	public List<Movie> getMovieList() {
		return movieRepository.list();
	}

	@Override
	public Movie getMovieById(Long id) {
		// TODO Auto-generated method stub
		return movieRepository.getById(id);
	}

}
