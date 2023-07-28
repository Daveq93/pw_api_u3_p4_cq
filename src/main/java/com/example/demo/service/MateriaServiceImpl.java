package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Materia;
import com.example.demo.repository.IMateriaRepo;
import com.example.demo.service.to.MateriaTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private IMateriaRepo materiaRepo;

	@Override
	public void guardar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepo.insertarMateria(materia);
	}

	@Override
	public Materia consultarPorCodigo(String codigo) {
		// TODO Auto-generated method stub

		Materia mate = this.materiaRepo.buscarPorCodigo(codigo);
		System.out.println(mate);
		return mate;
	}

	@Override
	public List<MateriaTO> materiasPorCedulaEstudiante(String cedulaEstudiante) {
		// TODO Auto-generated method stub
		List<Materia> materias = this.materiaRepo.buscarPorCedulaEstudiante(cedulaEstudiante);

		List<MateriaTO> mateTO = materias.parallelStream().map(m -> {
			MateriaTO mate = new MateriaTO();
			mate.setId(m.getId());
			mate.setNombre(m.getNombre());
			mate.setNumeroCedula(m.getEstudiante().getCedula());
			return mate;
		}).collect(Collectors.toList());

		return mateTO;
	}

	@Override
	public MateriaTO obtenerMateriaTO(Integer id) {
		// TODO Auto-generated method stub
		Materia m = this.materiaRepo.buscarPorId(id);
		MateriaTO mTO = new MateriaTO();
		mTO.setId(m.getId());
		mTO.setNombre(m.getNombre());
		mTO.setNumeroCedula(m.getEstudiante().getCedula());
		
		return mTO;
	}

}
