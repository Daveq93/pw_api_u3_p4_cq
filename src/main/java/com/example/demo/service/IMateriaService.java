package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Materia;
import com.example.demo.service.to.MateriaTO;

public interface IMateriaService {
	
	public void guardar(Materia materia);
	
	public Materia consultarPorCodigo(String codigo);

	public List<MateriaTO> materiasPorCedulaEstudiante(String cedulaEstudiante);
	
	public MateriaTO obtenerMateriaTO(Integer id);
	
	
}
