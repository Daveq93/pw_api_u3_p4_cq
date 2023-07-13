package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepoImpl implements IMateriaRepo {

	@PersistenceContext
	private EntityManager em;
 
	@Override
	public void insertarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.em.persist(materia);
		
	}

	@Override
	public Materia buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> myQ = this.em.createQuery("Select m from Materia m where m.codigo=:codigoM", Materia.class);
		return myQ.setParameter("codigoM", codigo).getSingleResult();
	}

	

}
