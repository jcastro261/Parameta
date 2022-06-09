package com.proyecto.parameta.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.proyecto.parameta.entity.Empleado;

public interface EmpleadoService {
	
	public Iterable<Empleado> finAll();
	
	public Page<Empleado> finAll(Pageable pageanle);
	
	public Optional<Empleado> findById(int id);
	
	public Empleado save(Empleado empleado);
	
	void deletById(int id);
	
}
