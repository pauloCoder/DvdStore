package com.mycompany.dvdstore.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.IMovieService;

@Controller
public class MovieController 
{
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}

	public void addUsingConsole()
	{
		
		//Instanciation des objets
    	Scanner sc = new Scanner(System.in);
    	Movie movie = new Movie();
    	
    	//Saisie et initialisation du titre du film
        System.out.println( "Quel est le titre du film ? : ");
        String movieTitle = sc.nextLine();
        movie.setTitle(movieTitle);

    	//Saisie et initialisation du genre du film
        System.out.println("Quel est le genre du film ? : ");
        String movieGenre = sc.nextLine();
        movie.setGenre(movieGenre);
        
        //Sauvegarde en BDD
        movieService.registerMovie(movie);
		
	}

}
