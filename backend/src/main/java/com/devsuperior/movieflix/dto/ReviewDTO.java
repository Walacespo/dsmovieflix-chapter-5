package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO {
	
	private String text;
	private Long movieId;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(String text, Long movieId) {
		super();
		this.text = text;
		this.movieId = movieId;
	}

	public ReviewDTO(Review review) {
		this.text = text;
		this.movieId = movieId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	
}
