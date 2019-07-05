package com.quetz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quetz.app.model.Catalogo;
import com.quetz.app.model.Producto;
import com.quetz.app.service.ICatalogoService;
import com.quetz.app.service.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired IProductoService productoService;
	
	@Autowired ICatalogoService catalService;
	
	@GetMapping("/index")
	public String index(Model modelo) {
		
		modelo.addAttribute("productos", productoService.obtenerTodos());
		return "prods/index";
	}
	
	@GetMapping("/nuevo")
	public String newProd(Model modelo, @ModelAttribute Producto producto) {
		
		modelo.addAttribute("accion", "Nuevo");
		return "prods/form";
	}
	
	@PostMapping("/guardar")
	public String save(Model modelo, @ModelAttribute Producto producto, BindingResult result, RedirectAttributes attributes, @RequestParam("cataProd") String catalogo) {
		if(result.hasErrors()) {
			modelo.addAttribute("accion", "Nuevo");
			return "prods/form";
		}
		
		producto.setCatalogo(catalService.buscarPorNombre(catalogo));
		productoService.guardarNuevo(producto);
		
		attributes.addFlashAttribute("mensaje", "El Producto ha sido almacenado Exitosamente");
		
		return "redirect:/producto/index";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(Model modelo, @PathVariable("id") int id) {
		
		Producto prod = productoService.buscarPorId(id);
		modelo.addAttribute("accion", "Editar");
		modelo.addAttribute("producto", prod);
		modelo.addAttribute("catalAsignado", prod.getCatalogo());
		
		return "prods/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		
		productoService.eliminarPorId(id);
		
		attributes.addFlashAttribute("mensaje", "El Producto se Eliminó con Exito");
		return "redirect:/producto/index";
	}
	
	@ModelAttribute("catalogos")
	public List<Catalogo> catalogos(){
		return catalService.obtenerTodos();
	}
}