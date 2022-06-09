package com.proyecto.parameta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.parameta.entity.Empleado;

@Repository
public interface EmpleadoRespository extends JpaRepository<Empleado, Integer> {

}
