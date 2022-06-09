package com.proyecto.parameta.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.parameta.entity.Empleado;
import com.proyecto.parameta.repository.EmpleadoRespository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRespository empleadoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Empleado> finAll() {
		
		return empleadoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> finAll(Pageable pageanle) {
		
		return empleadoRepository.findAll(pageanle);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Empleado> findById(int id) {
		
		return empleadoRepository.findById(id);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		
		return empleadoRepository.save(empleado);
	}

	@Override
	@Transactional
	public void deletById(int id) {
		empleadoRepository.deleteById(id);
		
	}

}
