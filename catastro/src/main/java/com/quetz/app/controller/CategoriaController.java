package com.quetz.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quetz.app.model.Categoria;
import com.quetz.app.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired ICategoriaService cateService;
	
	@GetMapping("/index")
	public String index(Model modelo) {
		
		modelo.addAttribute("categorias",cateService.obtenerTodas());
		return "cates/index";
	}
	
	@GetMapping("/nuevo")
	public String newCat(@ModelAttribute Categoria cate, Model modelo) {

		modelo.addAttribute("accion", "Nueva");
		return "cates/form";
	}
	
	@PostMapping("/guardar")
	public String saveNew(@ModelAttribute Categoria cate, Model modelo, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			modelo.addAttribute("accion", "Nueva");
			return "cates/form";
		}
		
		cateService.guardarNueva(cate);
		
		attributes.addFlashAttribute("mensaje", "La Categoría se Guardó con Exito");
		
		return "redirect:/categoria/index";
	}
	
	@GetMapping("/editar/{id}")
	public String edit(@PathVariable("id") int id, Model modelo) {
		
		modelo.addAttribute("categoria", cateService.buscarPorId(id));
		modelo.addAttribute("accion", "Editar");
		return "cates/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		cateService.eliminarPorId(id);
		
		attributes.addFlashAttribute("mensaje", "La Categoría ha sido Eliminada con Exito");
		
		return "redirect:/categoria/index";
	}
}
