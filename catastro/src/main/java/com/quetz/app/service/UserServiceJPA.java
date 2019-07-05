package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Usuario;
import com.quetz.app.repository.UsuarioRepository;

@Service
public class UserServiceJPA implements IUserService {
	
	@Autowired UsuarioRepository userRepo;

	@Override
	public List<Usuario> obtenerTodos() {
		return userRepo.findAll();
	}

	@Override
	public void addNuevo(Usuario user) {
		userRepo.save(user);
	}

	@Override
	public Usuario buscarPorId(int id) {
		Optional<Usuario> user = userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) {
		userRepo.deleteById(id);
		
	}
}
