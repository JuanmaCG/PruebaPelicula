package com.movie.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movie.entities.Login;

@Service
public interface LoginService {

	Login findByUsuario(String usuario);
	Login createLogin(Login login);
}
