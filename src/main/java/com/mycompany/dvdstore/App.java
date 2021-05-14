package com.mycompany.dvdstore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mycompany.dvdstore.controller.MovieController;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdstore.controller",
							   "com.mycompany.dvdstore.service",
							   "com.mycompany.dvdstore.repository.file"})
@PropertySource(value = "classpath:application.properties") 
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
    	MovieController movieController = context.getBean(MovieController.class);
    	
        movieController.addUsingConsole();
        
    }
}
