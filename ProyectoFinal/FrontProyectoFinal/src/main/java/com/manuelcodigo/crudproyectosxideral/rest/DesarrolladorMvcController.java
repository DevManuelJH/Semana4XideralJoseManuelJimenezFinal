package com.manuelcodigo.crudproyectosxideral.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;
import com.manuelcodigo.crudproyectosxideral.service.DesarrolladorService;

@Controller
@RequestMapping("/Accenture")
public class DesarrolladorMvcController {

	// need to inject our customer service
	@Autowired
	private DesarrolladorService desarrolladorService;
	
	@GetMapping("/devs")
	public String devs(Model theModel) {
		
		// get customers from the service
		List<Desarrollador> desarrolladores = desarrolladorService.mostrarTodos();
				
		// add the customers to the model
		theModel.addAttribute("desarrolladores", desarrolladores);
		
		return "list-desarrolladores";
	}

	@GetMapping("/agregarDesarrollador")
	public String agregarDesarroolador (Model theModel) {
		
		// create model attribute to bind form data
		Desarrollador desarrollador = new Desarrollador();
		
		theModel.addAttribute("desarrolladores", desarrollador);
		
		return "desarrollador-form";
	}
	
	@PostMapping("/guardarDesarrollador")
	public String guardarDesarrollador(@ModelAttribute("desarrolladores") Desarrollador desarrollador) {
		
		desarrolladorService.guardar(desarrollador);	
		
		return "redirect:/Accenture/devs";
	}
	
	@GetMapping("/formularioActualizar")
	public String formularioActualizar(@RequestParam("desarrolladorId") int id,
									Model theModel) {
		
		// get the customer from our service
		Desarrollador desarrollador = desarrolladorService.mostrarPorId(id);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("desarrolladores", desarrollador);
		
		// send over to our form		
		return "desarrollador-form";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("desarrolladorId") int id) {
		
		// delete the customer
		desarrolladorService.eliminar(id);
		
		return "redirect:/Accenture/devs";
	}

}










