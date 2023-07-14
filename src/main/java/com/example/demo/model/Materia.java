package com.example.demo.model;

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
@Table(name="materia")
public class Materia {

	@Id
	@Column(name = "mate_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "mseq_materia")
	@SequenceGenerator(name="seq_materia",sequenceName = "seq_materia",allocationSize = 1)
	private Long id;
	
	@Column(name = "mate_codigo")
	private String codigo;
	
	@Column(name = "mate_nombre")
	private String nombre;
	
	@Column(name = "mate_creditos")
	private Integer creditos;

	
	//Get and set generado por lombok
	
	
	
}
