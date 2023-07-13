package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Estudiante;
import com.example.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes") // el nombre debe ser en plural
public class EstudianteControllerRestFull {

	@Autowired
	private IEstudianteService estudianteService;

	// Get
	@GetMapping(path = "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1784512154";
		return this.estudianteService.consultarPorCedula(cedula);
	}

	@PostMapping(path = "/guardar") // Requestbody => digo que Estudiante debe venir en el cuerpo del request
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		}

	@PutMapping(path = "/actualizar")
	public void actualizar() {

	}

	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {

	}

	@DeleteMapping(path = "/borrar")
	public void borrar() {

	}

}
