package com.movie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entities.Login;
import com.movie.entities.Pelicula;
import com.movie.services.LoginService;
import com.movie.services.PeliculaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/filmografia")
public class PeliculaController {

	@Autowired
	PeliculaService peliculaService;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/peliculas")
	public List<Pelicula> getAllEmp(){
		return peliculaService.getAll();
	}
	
	@GetMapping("/listadoPeliculas/{director}")
	public List<Pelicula> getPelicula(@PathVariable String director) {
		return peliculaService.getPeliculaByDirector(director);
	}
	
	@GetMapping("/login/{usuario}")
	public Login getLogin(@PathVariable String usuario) {
		return loginService.findByUsuario(usuario);
	}
	
	@PostMapping("/login")
	public Login crearUsuario(@RequestBody Login login) {
		return loginService.createLogin(login);
	}
	
}
