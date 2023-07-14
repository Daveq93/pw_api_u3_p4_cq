package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="estudiante")
public class Estudiante {

	@Id
	@Column(name = "estu_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "seq_estudiante")
	@SequenceGenerator(name="seq_estudiante",sequenceName = "seq_estudiante",allocationSize = 1)
	private Integer id;
	@Column(name = "estu_cedula")
	private String cedula;
	@Column(name = "estu_nombre")
	private String nombre;
	@Column(name = "estu_apellido")
	private String apellido;
	@Column(name = "estu_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name="estu_provincia")
	private String provincia;
}
