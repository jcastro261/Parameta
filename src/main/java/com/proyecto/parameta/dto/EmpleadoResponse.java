package com.proyecto.parameta.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EmpleadoResponse {

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
	
	String tiempoVinculacion;
	
	String edadActual;
	

	public EmpleadoResponse(String nombre, String apellido, String tipoContrato, String numeroDocumento,
			Date fechaNacimiento, Date fechaVinculacion, String cargo, double salario, String tiempoVinculacion,
			String edadActual) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoContrato = tipoContrato;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaVinculacion = fechaVinculacion;
		this.cargo = cargo;
		this.salario = salario;
		this.tiempoVinculacion = tiempoVinculacion;
		this.edadActual = edadActual;
	}

	public String getTiempoVinculacion() {
		return tiempoVinculacion;
	}

	public void setTiempoVinculacion(String tiempoVinculacion) {
		this.tiempoVinculacion = tiempoVinculacion;
	}

	public String getEdadActual() {
		return edadActual;
	}

	public void setEdadActual(String edadActual) {
		this.edadActual = edadActual;
	}

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
