package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Categoria;
import com.quetz.app.repository.CategoriaRepository;

@Service
public class CategoriaServiceJPA implements ICategoriaService {

	@Autowired
	CategoriaRepository cateRepo;

	@Override
	public List<Categoria> obtenerTodas() {
		return cateRepo.findAll();
	}

	@Override
	public void guardarNueva(Categoria cate) {
		cateRepo.save(cate);
	}

	@Override
	public Categoria buscarPorId(int id) {
		Optional<Categoria> cate = cateRepo.findById(id);
		if (cate.isPresent()) {
			return cate.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) {
		cateRepo.deleteById(id);
	}

	@Override
	public Categoria buscarPorNombre(String nombre) {
		try {
			return cateRepo.findByNombre(nombre);
		} catch (Exception e) {
			return null;
		}
	}

}
