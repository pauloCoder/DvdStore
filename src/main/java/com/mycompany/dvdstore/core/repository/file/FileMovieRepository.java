package com.mycompany.dvdstore.core.repository.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Value;
import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.IMovieRepository;

//@Repository
public class FileMovieRepository implements IMovieRepository
{
	
	private FileWriter writer ;
	
	@Value("${movies.file.location}")
	private File file;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public Movie save(Movie movie)
	{
		try
		{
			//long lastId = findAll().stream().map(Movie::getId).max(Long::compare).orElse(0L);
		    long lastId=StreamSupport.stream(findAll().spliterator(), false).map(Movie::getId).max(Long::compare).orElse(0L);
			movie.setId(lastId+1);
		    writer = new FileWriter(file,true);
		    writer.write(movie.getId()+";"+movie.getTitle()+";"+movie.getGenre()+";"
		    			 +movie.getDescription()+"\n");
			System.out.println("File : The movie " + movie.getTitle() + " has been added.");
		    writer.close();
		}
		catch (IOException e)
		{
		     e.printStackTrace();
		}
		return movie;
	}
	
	@Override
	public List<Movie> findAll() {
	 
	    List<Movie> movies=new ArrayList<>();
	 
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        for(String line; (line = br.readLine()) != null; ) {
	            final Movie movie=new Movie();
	            final String[] titreEtGenre = line.split("\\;");
	            movie.setId(Long.parseLong(titreEtGenre[0]));
	            movie.setTitle(titreEtGenre[1]);
	            movie.setGenre(titreEtGenre[2]);
	            movie.setDescription(titreEtGenre[3]);
	            movies.add(movie);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return movies;
	}

	@Override
	public Optional<Movie> findById(Long id) {
	    final Movie movie = new Movie();
	    movie.setId(id);
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        for(String line; (line = br.readLine()) != null; ) {
	 
	            final String[] allProperties = line.split("\\;");
	            final long nextMovieId=Long.parseLong(allProperties[0]);
	            if (nextMovieId==id) {
	                movie.setTitle(allProperties[1]);
	                movie.setGenre(allProperties[2]);
	                movie.setDescription(allProperties[3]);
	                return Optional.of(movie);
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (NumberFormatException e) {
	        System.err.println("A movie from the file does not have a proper id");
	        e.printStackTrace();
	    }
	    movie.setTitle("UNKNOWN");
	    movie.setGenre("UNKNOWN");
	    movie.setDescription("UNKNOWN");
	    return Optional.of(movie);
	}

	@Override
	public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
		throw new UnsupportedOperationException();
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
