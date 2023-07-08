package com.example.demo.repository;

import com.example.demo.model.Estudiante;

public interface IEstudianteRepo {

	
	public Estudiante seleccionarPorCedula(String cedula);
}
