package com.example.demo.repository;

import com.example.demo.model.Estudiante;

public interface IEstudianteRepo {

	public void insertarEstudiante(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public void actualizarEstudiante();
	
}
