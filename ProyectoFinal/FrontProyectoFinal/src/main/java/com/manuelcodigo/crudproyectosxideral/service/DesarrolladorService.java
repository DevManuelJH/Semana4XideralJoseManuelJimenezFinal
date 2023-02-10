package com.manuelcodigo.crudproyectosxideral.service;

import java.util.List;

import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;

public interface DesarrolladorService {

	public List<Desarrollador> mostrarTodos();
	
	public Desarrollador mostrarPorId(int id);
	
	public void guardar(Desarrollador desarrollador);
	
	public void eliminar(int id);
	
}
