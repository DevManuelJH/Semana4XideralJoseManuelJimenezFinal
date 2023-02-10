package com.manuelcodigo.crudproyectosxideral.dao;

import java.util.List;

import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;

public interface DesarrolladorDAO {
	
   public List<Desarrollador> mostrarTodos();
	
	public Desarrollador mostrarPorId(int id);
	
	public void guardar(Desarrollador desarrollador);
	
	public void eliminarPorId(int id);
	
}
