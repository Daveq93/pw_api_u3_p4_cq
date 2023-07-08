package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes") //el nombre debe ser en plural
public class EstudianteControllerRestFull {

	@Autowired
	private IEstudianteService estudianteService;
	
	//Get
	@GetMapping(path="/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1784512154";
		return this.estudianteService.consultarPorCedula(cedula);
	}
	
}
