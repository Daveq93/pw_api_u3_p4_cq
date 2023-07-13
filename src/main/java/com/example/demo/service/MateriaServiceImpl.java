package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Materia;
import com.example.demo.repository.IMateriaRepo;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo materiaRepo;
	
	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
            this.materiaRepo.insertarMateria(materia);
	}

	@Override
	public Materia consultarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		
		Materia mate = this.materiaRepo.buscarPorCodigo(codigo);
		System.out.println(mate);
		return mate;
	}

}
