package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.model.Materia;
import com.example.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFull {

	@Autowired
	private IMateriaService materiaService;
	
	@PostMapping(path="/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
	}
	
	
	@GetMapping(path="/codigo/{codigo}")
	public ResponseEntity<Materia> consultarPorCodigo(@PathVariable(name="codigo")String codigo) {
		
		return ResponseEntity.status(200).body(this.materiaService.consultarPorCodigo(codigo));
	}
	
	
}
