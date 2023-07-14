package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public Estudiante consultarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.insertarEstudiante(estudiante);
		
	}

	@Override
	public Estudiante actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
	return	this.estudianteRepo.actualizarEstudiante(estudiante);
	}

	@Override
	public Integer actualizarParcial(String cedulaActual, String cedulaNueva) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.actualizarParcial(cedulaActual, cedulaNueva);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.borrar(id);
	}

	@Override
	public List<Estudiante> listarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepo.listarEstudiantes();
	}

}
