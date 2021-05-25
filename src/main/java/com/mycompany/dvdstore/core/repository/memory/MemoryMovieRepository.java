package com.mycompany.dvdstore.core.repository.memory;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.IMovieRepository;

//@Repository
public class MemoryMovieRepository implements IMovieRepository
{
	
	private static List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public void add(Movie movie)
	{
		movies.add(movie);
		System.out.println("Memory : The movie " + movie.getTitle() + " has been added.");
	}
	
	@Override
	public List<Movie> list() {
		return movies;
	}

}
