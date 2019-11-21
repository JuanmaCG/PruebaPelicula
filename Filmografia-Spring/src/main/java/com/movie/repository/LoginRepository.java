package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

}
