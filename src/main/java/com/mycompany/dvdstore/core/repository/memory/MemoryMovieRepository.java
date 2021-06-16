package com.mycompany.dvdstore.core.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.IMovieRepository;

//@Repository
public class MemoryMovieRepository implements IMovieRepository
{
	
	
	private static List<Movie> movies = new ArrayList<Movie>();
	private static Long compteur = 0L;
	
	@Override
	public Movie add(Movie movie)
	{
		movie.setId(++compteur);
		movies.add(movie);
		System.out.println("Memory : The movie " + movie.getTitle() + " has been added.");
		return movie;
	}
	
	@Override
	public List<Movie> list() {
		return movies;
	}

	@Override
	public Movie getById(Long id) {
	    return movies.stream().
	            filter(m -> m.getId()==id).
	            findFirst().get();
	}

}
