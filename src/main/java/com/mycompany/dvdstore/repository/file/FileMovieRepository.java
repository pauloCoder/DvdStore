package com.mycompany.dvdstore.repository.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.repository.IMovieRepository;

@Repository
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
	public void add(Movie movie)
	{
		try
		{
		    writer = new FileWriter(file,true);
		    writer.write(movie.getTitle() + ";" + movie.getGenre()+ "\n");
			System.out.println("File : The movie " + movie.getTitle() + " has been added.");
		    writer.close();
		}
		catch (IOException e)
		{
		     e.printStackTrace();
		}
	}

}
