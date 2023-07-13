package com.example.demo.service;

import com.example.demo.model.Estudiante;

public interface IEstudianteService {

	public void guardar(Estudiante estudiante);
	
	public Estudiante consultarPorCedula(String cedula);
}
