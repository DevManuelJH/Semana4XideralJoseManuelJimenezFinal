package com.manuelcodigo.crudproyectosxideral.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;
import com.manuelcodigo.crudproyectosxideral.services.DesarrolladorService;

@RestController
@RequestMapping("/Accenture")

public class DesarrolladorRestController {
	
	private DesarrolladorService desarrolladorService;
	
	//Inyecta por constructor los metodos que vamos a implementar en nuestros servicios
    @Autowired
	public DesarrolladorRestController(DesarrolladorService desarrolladorService) {
		this.desarrolladorService = desarrolladorService;
	}
    
    //Muestra toda la lista de devs
    @GetMapping("/desarrolladores")
	public List<Desarrollador> mostrarTodos() {
		return desarrolladorService.mostrarTodos();
	}
    
    //Muestra por ID
    @GetMapping("/desarrolladores/{id}")
	public Desarrollador mostrarPorId(@PathVariable int id) {
		
		Desarrollador desarrollador = desarrolladorService.mostrarPorId(id);
		
		if (desarrollador == null) {
			throw new DesarrolladorNotFoundException("No se encontro al desarrollador - " + id);
		}
		
		return desarrollador;
	}
    
	  @PostMapping("/desarrolladores") 
	  public Desarrollador agregar(@RequestBody Desarrollador desarrollador) {
	  
	  desarrollador.setId(0);
	  
	  desarrolladorService.guardar(desarrollador);
	  
	  return desarrollador; 
	  
	  }
	  
	  @PutMapping("/desarrolladores") 
	  public Desarrollador actualizar(@RequestBody Desarrollador desarrollador) {
	  
	  desarrolladorService.guardar(desarrollador);
	  
	  return desarrollador; 
	  
	  }
	  
	  @DeleteMapping("/desarrolladores/{id}")
		public String eliminar(@PathVariable int id) {
			
		    Desarrollador desarrollador = desarrolladorService.mostrarPorId(id);
		    
			if (desarrollador == null) {
				throw new DesarrolladorNotFoundException("No se encontro al desarrollador - " + id);
			}
			
			desarrolladorService.eliminar(id);
			
			return "Deleted desarrollador id - " + id;
		}

}
