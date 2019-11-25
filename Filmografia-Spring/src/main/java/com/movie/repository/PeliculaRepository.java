package com.movie.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entities.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, String>{

	@Query("SELECT * FROM Pelicula p WHERE p.director = ?1")
	List<Pelicula> findByDirector(String director);
	
	@Query("SELECT * FROM Pelicula p WHERE p.titulo = ?1")
	Pelicula findByTitulo(String titulo);
	
}
