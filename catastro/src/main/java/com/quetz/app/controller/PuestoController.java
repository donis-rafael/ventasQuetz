package com.quetz.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.quetz.app.model.Categoria;
import com.quetz.app.model.Mercado;
import com.quetz.app.model.Puesto;
import com.quetz.app.service.ICategoriaService;
import com.quetz.app.service.IMercadoService;
import com.quetz.app.service.IPuestoService;

@Controller
@RequestMapping("/puesto")
public class PuestoController {

	@Autowired
	IPuestoService puestoService;

	@Autowired
	IMercadoService mercadoService;

	@Autowired
	ICategoriaService cateService;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@GetMapping("/index")
	public String index(Model modelo) {

		modelo.addAttribute("puestos", puestoService.obtenerTodos());
		return "puestos/index";
	}

	@GetMapping("/nuevo")
	public String newPuesto(Model modelo, @ModelAttribute Puesto puesto) {

		modelo.addAttribute("accion", "Nuevo");
		return "puestos/form";
	}

	@PostMapping("/guardar")
	public String save(Model modelo, @ModelAttribute Puesto puesto, BindingResult result, RedirectAttributes attributes,
			@RequestParam("categPuesto") String categoria, @RequestParam("mercadito") String mercado) {
		if (result.hasErrors() || (puesto.getFecha() != null && puesto.getId() > 0 && puesto.getDeuda() < 0.01)) {
			if (puesto.getId() == 0) {
				modelo.addAttribute("accion", "Nuevo");
				return "puestos/form";
			} else {
				Puesto puestito = puestoService.buscarPorId(puesto.getId());
				modelo.addAttribute("puesto", puestito);
				modelo.addAttribute("mensaje", "Ingrese un número mayor a cero");

				return "puestos/deuda";
			}
		}

		puesto.setCategoria(cateService.buscarPorNombre(categoria));
		puesto.setMercado(mercadoService.buscarPorNombre(mercado));
		puestoService.guardarNuevo(puesto);

		attributes.addFlashAttribute("mensaje", "El Puesto se Guardó con Exito");

		return "redirect:/puesto/index";
	}

	@GetMapping("/editar/{id}")
	public String edit(@PathVariable("id") int id, Model modelo) {

		Puesto puesto = puestoService.buscarPorId(id);
		modelo.addAttribute("accion", "Editar");
		modelo.addAttribute("puesto", puesto);
		modelo.addAttribute("cateAsignada", puesto.getCategoria());
		modelo.addAttribute("mercadoAsignado", puesto.getMercado());

		return "puestos/form";
	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {

		puestoService.eliminarPorId(id);
		attributes.addFlashAttribute("mensaje", "El Puesto ha sido Eliminado con Exito");

		return "redirect:/puesto/index";
	}

	@GetMapping("/deuda/{id}")
	public String deuda(@PathVariable("id") int id, Model modelo) {
		Puesto puesto = puestoService.buscarPorId(id);

		if (puesto.getFecha() != null) {

			modelo.addAttribute("puesto", puesto);

			return "puestos/deuda";
		}

		modelo.addAttribute("idPuesto", id);

		return "puestos/decide";
	}

	@GetMapping("/iniciaD/{id}")
	public String creaD(@PathVariable("id") int id) {
		Puesto puesto = puestoService.buscarPorId(id);
		Date fechaSinHora;

		try {
			fechaSinHora = dateFormat.parse(dateFormat.format(new Date()));
			puesto.setFecha(fechaSinHora);
			puestoService.guardarNuevo(puesto);

			return "redirect:/puesto/deuda/" + id;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/puesto/index";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(@PathVariable("id") int id, RedirectAttributes attributes) {
		Puesto puesto = puestoService.buscarPorId(id);
		puesto.setFecha(null);
		puesto.setDeuda(0);
		puestoService.guardarNuevo(puesto);
		
		attributes.addFlashAttribute("mensaje", "La Deuda ha sido Eliminada con éxito");
		return "redirect:/puesto/index";
	}

	@ModelAttribute("mercados")
	public List<Mercado> mercados() {
		return mercadoService.obtenerTodos();
	}

	@ModelAttribute("categorias")
	public List<Categoria> categorias() {
		return cateService.obtenerTodas();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
