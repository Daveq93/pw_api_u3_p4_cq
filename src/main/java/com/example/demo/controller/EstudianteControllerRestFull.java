package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//	@GetMapping(path = "/{cedula}")
//	//Response entity es un wrapper 
//	public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable(name="cedula") String cedula) {
//		return ResponseEntity.status(227).body(this.estudianteService.consultarPorCedula(cedula));
//	}
	
	@GetMapping(path = "/{cedula}")
	//Response entity es un wrapper 
	public ResponseEntity<Estudiante> consultarPorCedulaStatus(@PathVariable(name="cedula") String cedula) {
		return ResponseEntity.status(HttpStatus.OK).body(this.estudianteService.consultarPorCedula(cedula));
	}

	@PostMapping // Requestbody => digo que Estudiante debe venir en el cuerpo del request
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Estudiante> actualizar(@RequestBody Estudiante estudiante, @PathVariable(name="id")Integer identificador ) {
		estudiante.setId(identificador);
		return ResponseEntity.ok(this.estudianteService.actualizar(estudiante));
	}

	@PatchMapping(path = "/{cedula}")
	public ResponseEntity<Integer> actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable(name="cedula")String cedula) {
		
//		estudiante.setId(identificador);
//		String cedula = "1784512154";
//		Estudiante estu1 = this.estudianteService.consultarPorCedula(cedula);
//		estu1.setCedula(estudiante.getCedula());
	
		return ResponseEntity.ok(this.estudianteService.actualizarParcial(estudiante.getCedula(),this.estudianteService.consultarPorCedula(cedula).getCedula() ));
	}
	

	@DeleteMapping(path = "/{id}")
	public void borrar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}
	
	@GetMapping//PathVariable hace referencia a un identificador, RequestParam es mas general
	public ResponseEntity<List<Estudiante>> listar(){
	
		//return ResponseEntity.ok(this.estudianteService.listarTodos());
	HttpHeaders cabecera = new HttpHeaders();
	cabecera.add("detailMessage","Ciudadanos consultados exitosamente");
		cabecera.add("valor Api", "Incalculable");
		return new ResponseEntity<>(this.estudianteService.listarTodos(),cabecera,228);
	}
	
	
//	@GetMapping(path="/{provincia}")//PathVariable hace referencia a un identificador, RequestParam es mas general
//	public ResponseEntity<List<Estudiante>> listar(@RequestParam String provincia){
//		
//		return ResponseEntity.ok(this.estudianteService.listarTodos().stream().filter(x->x.getProvincia().equals(provincia)).collect(Collectors.toList()));
//	}

}
