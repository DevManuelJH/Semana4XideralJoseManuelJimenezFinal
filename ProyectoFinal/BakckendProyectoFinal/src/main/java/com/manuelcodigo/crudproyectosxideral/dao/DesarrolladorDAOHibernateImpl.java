package com.manuelcodigo.crudproyectosxideral.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.manuelcodigo.crudproyectosxideral.entity.Desarrollador;

@Repository
public class DesarrolladorDAOHibernateImpl implements DesarrolladorDAO {

	private EntityManager entityManager;

	@Autowired
	public DesarrolladorDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Desarrollador> mostrarTodos() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Desarrollador> theQuery = currentSession.createQuery("from Desarrollador", Desarrollador.class);
		List<Desarrollador> desarrollador = theQuery.getResultList();

		return desarrollador;
	}

	@Override
	public Desarrollador mostrarPorId(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		Desarrollador desarrollador = currentSession.get(Desarrollador.class, id);

		return desarrollador;
	}

	@Override
	public void guardar(Desarrollador desarrollador) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(desarrollador);
	}

	@Override
	public void eliminarPorId(int id) {

		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Desarrollador where id=:desarrolladorId");
		theQuery.setParameter("desarrolladorId", id);

		theQuery.executeUpdate();

	}

}
