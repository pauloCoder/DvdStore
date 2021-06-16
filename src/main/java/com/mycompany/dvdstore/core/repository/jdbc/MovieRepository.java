package com.mycompany.dvdstore.core.repository.jdbc;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mycompany.dvdstore.core.entity.Movie;
import com.mycompany.dvdstore.core.repository.IMovieRepository;

@Repository
public class MovieRepository implements IMovieRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Movie add(Movie movie) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update((connection) -> {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO MOVIE(TITLE,GENRE,DESCRIPTION) VALUES(?,?,?)",
									Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, movie.getTitle());
			ps.setString(2, movie.getGenre());
			ps.setString(3, movie.getDescription());
			return ps;
		},
		kh);
		movie.setId(kh.getKey().longValue());
		
		return movie;
	};

	@Override
	public List<Movie> list() {
		return jdbcTemplate.query("SELECT ID,TITLE,GENRE FROM MOVIE", 
							      (rs,rowNum) -> new Movie
							      				(
							    		  		 rs.getLong("ID"),
							    		  		 rs.getString("TITLE"),
							    		  		 rs.getString("GENRE") 
							    		  		 )
							      );
	}

	@Override
	public Movie getById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM MOVIE WHERE ID = ?",
											new Object[] {id}, 
											(rs,rowNum) -> new Movie
						      				(
						    		  		 rs.getLong("ID"),
						    		  		 rs.getString("TITLE"),
						    		  		 rs.getString("GENRE"),
						    		  		 rs.getString("DESCRIPTION")
						    		  		 ));
	}

}
