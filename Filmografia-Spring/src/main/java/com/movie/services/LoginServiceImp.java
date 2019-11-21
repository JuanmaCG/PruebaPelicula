package com.movie.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entities.Login;
import com.movie.repository.LoginRepository;

import exception.ResourceNotFoundException;

@Service
public class LoginServiceImp implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public Login createLogin(Login login) {
		if(loginRepository.findById(login.getUsuario()).isPresent()) {
			throw new ResourceNotFoundException("Usuario existente");
		}else {
			loginRepository.save(new Login(login.getUsuario(), login.getPassword()));
			return loginRepository.save(login);
		}
	}

	@Override
	public Login findByUsuario(String usuario) {
		Login login = loginRepository.findById(usuario).orElseThrow(() -> new ResourceNotFoundException("No se ha encontrado el usuario"));
		return login;
	}

}
