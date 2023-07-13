package com.example.demo.service;

import com.example.demo.model.Materia;

public interface IMateriaService {
	
	public void guardar(Materia materia);
	
	public Materia consultarPorCodigo(String codigo);

}
