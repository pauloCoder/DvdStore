package com.mycompany.dvdstore.core.service;

import java.util.NoSuchElementException;
import java.util.Optional;

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
		movieRepository.save(movie);
		return movie;
	}
	
	@Override
	public Iterable<Movie> getMovieList() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieById(Long id) {
	    Optional<Movie> optionalMovie=movieRepository.findById(id);
	    if (optionalMovie.isEmpty()){
	        throw new NoSuchElementException();
	    }
	    Movie movie=optionalMovie.get();
	    //Initialize proxys
	    movie.getMainActor().getFirstName();
	    movie.getReviews().forEach(review -> {
	        review.getMark();
	        review.setMovie(null);
	    });
	    
	    return movie;
	}

}
