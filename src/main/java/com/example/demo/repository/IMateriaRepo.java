package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Materia;


public interface IMateriaRepo {

	
	
	public void insertarMateria(Materia materia);
	
	public Materia buscarPorCodigo(String codigo);
	
	public Materia buscarPorId(Integer id);
	
	public List<Materia> buscarPorCedulaEstudiante(String cedulaEstudiante);

    
	
	
}
