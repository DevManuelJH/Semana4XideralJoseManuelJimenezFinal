package com.manuelcodigo.crudproyectosxideral.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manuelcodigo.crudproyectosxideral.dao.DesarrolladorDAO;
import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;

	
@Service
public class DesarrolladorServiceImpl implements DesarrolladorService {

		private DesarrolladorDAO desarrolladorDAO;
		
		@Autowired
		public DesarrolladorServiceImpl(DesarrolladorDAO desarrolladorDAO) {
			this.desarrolladorDAO = desarrolladorDAO;
		}
		
		@Override
		@Transactional
		public List<Desarrollador> mostrarTodos() {
			return desarrolladorDAO.mostrarTodos();
		}

		@Override
		@Transactional
		public Desarrollador mostrarPorId(int id) {
			return desarrolladorDAO.mostrarPorId(id);
		}

		@Override
		@Transactional
		public void guardar(Desarrollador desarrollador) {
			desarrolladorDAO.guardar(desarrollador);;
		}

		@Override
		@Transactional
		public void eliminar(int id) {
			desarrolladorDAO.eliminarPorId(id);;
		}

	}
