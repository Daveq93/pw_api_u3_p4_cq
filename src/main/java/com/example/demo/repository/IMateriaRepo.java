package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Materia;

import jakarta.transaction.Transactional;


public interface IMateriaRepo {

	public void insertarMateria(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);
	
}
