package com.proyecto.parameta.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmpleadoDto {

	private String nombre;

	private String apellido;

	private String tipoContrato;

	private String numeroDocumento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaVinculacion;

	private String cargo;

	private double salario;

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaVinculacion() {
		return fechaVinculacion;
	}

	public void setFechaVinculacion(Date fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
