package com.mycompany.dvdstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.dvdstore.controller.MovieController;

public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	MovieController movieController = context.getBean(MovieController.class);
    	
        movieController.addUsingConsole();
        
    }
}
