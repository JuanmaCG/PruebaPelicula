package com.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Pelicula;
import com.movie.services.PeliculaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/filmografia")
public class PeliculaController {

	@Autowired
	PeliculaService peliculaService;
	
	@GetMapping("/peliculas")
	public List<Pelicula> getAllEmp(){
		return peliculaService.getAll();
	}
	
	@GetMapping("/listadoPeliculas/{director}")
	public List<Pelicula> getPelicula(@PathVariable String director) {
		return peliculaService.getPeliculaByDirector(director);
	}
	
	
}
