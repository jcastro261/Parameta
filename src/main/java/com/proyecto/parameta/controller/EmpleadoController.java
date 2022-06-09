package com.proyecto.parameta.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.parameta.dto.EmpleadoDto;
import com.proyecto.parameta.dto.EmpleadoResponse;
import com.proyecto.parameta.entity.Empleado;
import com.proyecto.parameta.service.EmpleadoService;
import com.proyecto.parameta.util.Util;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@PostMapping
	@RequestMapping("/add")
	public ResponseEntity<?> create(@RequestBody EmpleadoDto empleadoDto) {

		if (Util.verificarParametros(empleadoDto.getNombre(), empleadoDto.getApellido(), empleadoDto.getTipoContrato(),
				empleadoDto.getTipoContrato(), empleadoDto.getCargo(), empleadoDto.getSalario(),
				empleadoDto.getFechaNacimiento())) {
			Empleado empleado = new Empleado(empleadoDto.getNombre(), empleadoDto.getApellido(),
					empleadoDto.getTipoContrato(), empleadoDto.getNumeroDocumento(), empleadoDto.getFechaNacimiento(),
					empleadoDto.getFechaVinculacion(), empleadoDto.getCargo(), empleadoDto.getSalario());

			return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");

	}

	@GetMapping
	@RequestMapping("consult/{idEmpleado}")
	public ResponseEntity<?> read(@PathVariable int idEmpleado) {
		Optional<Empleado> empleado = empleadoService.findById(idEmpleado);

		EmpleadoResponse response = new EmpleadoResponse(empleado.get().getNombre(), empleado.get().getApellido(),
				empleado.get().getTipoContrato(), empleado.get().getNumeroDocumento(),
				empleado.get().getFechaNacimiento(), empleado.get().getFechaVinculacion(), empleado.get().getCargo(),
				empleado.get().getSalario(), Util.imprimirEdad(empleado.get().getFechaVinculacion(), new Date(), false),
				Util.imprimirEdad(empleado.get().getFechaNacimiento(), new Date(), true));

		if (!empleado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping
	@RequestMapping("/update")
	public ResponseEntity<?> update(@RequestBody Empleado empleadoDetails) {

		if (Util.verificarEmppleado(empleadoDetails)) {

			Optional<Empleado> empleado = empleadoService.findById(empleadoDetails.getIdEmpleado());

			if (!empleado.isPresent())
				return ResponseEntity.notFound().build();

			empleado.get().setNombre(empleadoDetails.getNombre());
			empleado.get().setApellido(empleadoDetails.getApellido());
			empleado.get().setTipoContrato(empleadoDetails.getTipoContrato());
			empleado.get().setNumeroDocumento(empleadoDetails.getNumeroDocumento());
			empleado.get().setFechaNacimiento(empleadoDetails.getFechaNacimiento());
			empleado.get().setFechaVinculacion(empleadoDetails.getFechaVinculacion());
			empleado.get().setCargo(empleadoDetails.getCargo());
			empleado.get().setSalario(empleadoDetails.getSalario());

			return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado.get()));
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");

	}

	@DeleteMapping
	@RequestMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {

		if (Util.validarId(id)) {

			Optional<Empleado> empleado = empleadoService.findById(id);

			if (!empleado.isPresent())

				return ResponseEntity.notFound().build();

			empleadoService.deletById(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Parametros incorrectos");
	}

}
