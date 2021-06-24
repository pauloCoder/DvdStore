package com.mycompany.dvdstore.core.repository.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.IMovieRepository;

//@Repository
public class MemoryMovieRepository implements IMovieRepository
{
	
	
	private static List<Movie> movies = new ArrayList<Movie>();
	private static Long compteur = 0L;
	
	@Override
	public Movie save(Movie movie)
	{
		movie.setId(++compteur);
		movies.add(movie);
		System.out.println("Memory : The movie " + movie.getTitle() + " has been added.");
		return movie;
	}
	
	@Override
	public List<Movie> findAll() {
		return movies;
	}

	@Override
	public Optional<Movie> findById(Long id) {
	    return movies.stream().
	            filter(m -> m.getId()==id).
	            findFirst();
	}

	@Override
	public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Movie> findAllById(Iterable<Long> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long count() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteById(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Movie entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll(Iterable<? extends Movie> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		throw new UnsupportedOperationException();
		
	}

}
