package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> page = movieRepository.findAll(pageable);
		return page.map(x -> new MovieDTO(x));
	}
	
	
	//@Transactional(readOnly = true)
	//public List<GenreDTO> findAllPaged() {
		//List<Genre> list = genreRepository.findAll();
		//return list.map(x -> new GenreDTO(x));
	//}
	
	//@Transactional(readOnly = true)
	//public MovieDetailsDTO findById(Long id) {
		//try {
		//Movie result = movieRepository.findById(id).get();
		//MovieDetailsDTO dto = new MovieDetailsDTO(result);
		//return dto;
		//}
		//catch (ResourceNotFoundException e) {
			//throw new ResourceNotFoundException("Id not found " + id);
		//}
		
	//}
	
	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long id) {
		Optional<Movie> obj = movieRepository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDetailsDTO(entity);
	}
	
}
