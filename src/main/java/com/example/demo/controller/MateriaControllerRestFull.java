package com.example.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.demo.service.to.EstudianteTO;
import com.example.demo.service.to.MateriaTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFull {

	@Autowired
	private IMateriaService materiaService;

	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Materia materia) {
		this.materiaService.guardar(materia);
	}

//	@GetMapping(path = "/codigo/{codigo}")
//	public ResponseEntity<Materia> consultarPorCodigo(@PathVariable(name = "codigo") String codigo) {
//
//		return ResponseEntity.status(200).body(this.materiaService.consultarPorCodigo(codigo));
//	}

	@GetMapping(path="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaTO> materiaPorId(@PathVariable(name="id") Integer id) {

		MateriaTO m = this.materiaService.obtenerMateriaTO(id);
		//System.out.println(m.toString());
		Link myLynk = linkTo(methodOn(MateriaControllerRestFull.class).buscarMateriaPorCodigo(m.getId())).withRel("materia");
           m.add(myLynk);
		return new ResponseEntity<>(m,null,HttpStatus.OK);
	}
	
	
	@GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaTO> buscarMateriaPorCodigo(@PathVariable(name="id") Integer id){
		
		
		return new ResponseEntity<>(this.materiaService.obtenerMateriaTO(id),null,HttpStatus.OK);
	}
}
