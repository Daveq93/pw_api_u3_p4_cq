package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepoImpl implements IEstudianteRepo {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQ = this.em.createQuery("Select e from Estudiante e where e.cedula =: datoCedula",Estudiante.class);
		Estudiante es =myQ.setParameter("datoCedula", cedula).getSingleResult();
		System.out.println("Estu: "+es.toString());
		return es;
	}

}
