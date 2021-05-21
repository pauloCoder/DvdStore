package com.mycompany.dvdstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.dvdstore.entity.Movie;
import com.mycompany.dvdstore.service.IMovieService;

@Controller
public class HomeController {
	
	@Autowired
	private IMovieService movieService;
	
	public IMovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(IMovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping("/dvdstore-home")
	public @ModelAttribute("movies") List<Movie> displayHome()
	{
		List<Movie> movies =  movieService.getMovieList();
		return movies;
	}

}
