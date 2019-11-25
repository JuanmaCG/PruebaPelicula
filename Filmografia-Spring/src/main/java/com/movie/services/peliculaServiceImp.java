package com.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entities.Pelicula;
import com.movie.repository.PeliculaRepository;

import exception.ResourceNotFoundException;

@Service
public class peliculaServiceImp implements PeliculaService{

	@Autowired
	PeliculaRepository peliculaRepo;
	
	@Override
	public List<Pelicula> getAll() {
		// TODO Auto-generated method stub
		return peliculaRepo.findAll();
	}
	
	@Override
	public List<Pelicula> getPeliculaByDirector(String director) {
		List<Pelicula> peliculas = peliculaRepo.findByDirector(director);
		
		return peliculas;
	}
	@Override
	public Pelicula getPeliculaByTitulo(String titulo) {
		Pelicula pelicula = peliculaRepo.findByTitulo(titulo);
		
		return pelicula;
	}


	@Override
	public Pelicula createPelicula(Pelicula pelicula) {
		if(peliculaRepo.findById(pelicula.getTitulo()).isPresent()) {
			throw new ResourceNotFoundException("Titulo existente");
		}else {
			peliculaRepo.save(new Pelicula(pelicula.getTitulo(), pelicula.getDirector(), pelicula.getFecha()));
			return peliculaRepo.save(pelicula);
		}
	}

	@Override
	public void deletePelicula(String titulo) {
		Optional<Pelicula> pelicula = peliculaRepo.findById(titulo);
		if(pelicula.isPresent()) {
			peliculaRepo.delete(pelicula.get());
		}else {
			throw new ResourceNotFoundException("Pelicula no encontrada");
		}
	}

	@Override
	public Pelicula updatePelicula(Pelicula pelicula) {
		Optional<Pelicula> peli = peliculaRepo.findById(pelicula.getTitulo());
		if(peli.isPresent()) {
			Pelicula peliActualizada = peli.get();
			peliActualizada.setTitulo(pelicula.getTitulo());
			peliActualizada.setDirector(pelicula.getDirector());
			peliActualizada.setFecha(pelicula.getFecha());
			
			peliculaRepo.save(peliActualizada);
			return peliActualizada;
			
		}else {
			throw new ResourceNotFoundException("Pelicula no encontrada");
		}
	}




	
}
