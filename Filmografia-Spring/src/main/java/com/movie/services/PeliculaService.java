package com.movie.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.movie.entities.Pelicula;

@Service
public interface PeliculaService {

	List<Pelicula> getAll();
	Pelicula createPelicula(Pelicula pelicula);
	void deletePelicula(String titulo);
	Pelicula updatePelicula(Pelicula pelicula);
	List<Pelicula> getPeliculaByDirector(String director);
	Pelicula getPeliculaByTitulo (String titulo);
}
