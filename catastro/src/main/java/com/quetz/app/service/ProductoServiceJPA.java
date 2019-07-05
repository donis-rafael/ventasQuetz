package com.quetz.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quetz.app.model.Producto;
import com.quetz.app.repository.ProductoRepository;

@Service
public class ProductoServiceJPA implements IProductoService {

	@Autowired ProductoRepository productoRepo;
	
	@Override
	public List<Producto> obtenerTodos() {
		return productoRepo.findAll();
	}

	@Override
	public void guardarNuevo(Producto producto) {
		productoRepo.save(producto);
	}

	@Override
	public Producto buscarPorId(int id) {
		Optional<Producto> prod = productoRepo.findById(id);
		if(prod.isPresent()) {
			return prod.get();
		}
		return null;
	}

	@Override
	public void eliminarPorId(int id) {
		productoRepo.deleteById(id);
	}

}