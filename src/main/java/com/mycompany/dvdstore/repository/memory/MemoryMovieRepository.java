package com.mycompany.dvdstore.repository.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.IMovieRepository;

@Repository
public class MemoryMovieRepository implements IMovieRepository
{
	
	private static List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public void add(Movie movie)
	{
		movies.add(movie);
		System.out.println("Memory : The movie " + movie.getTitle() + " has been added.");
	}

}
