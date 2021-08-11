package com.mycompany.dvdstore.core.entity.review;


import javax.persistence.*;

import com.mycompany.dvdstore.core.entity.movie.Movie;

@Entity
@NamedEntityGraph(name = "review-user" , attributeNodes = @NamedAttributeNode("reviewer"))
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String reviewComment;
    
    @Column(nullable = false)
    private Short mark;
    
    @Transient
    private Movie movie;
    
    private Long idMovie;
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ID_REVIEWER")
    private User reviewer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public Short getMark() {
        return mark;
    }

    public void setMark(Short mark) {
        this.mark = mark;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

	public Long getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Long idMovie) {
		this.idMovie = idMovie;
	}
}
