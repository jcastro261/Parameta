package com.proyecto.parameta.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private int idEmpleado;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "tipo_contrato")
	private String tipoContrato;

	@Column(name = "numero_documento")
	private String numeroDocumento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha_vinculacion")
	private Date fechaVinculacion;

	@Column(name = "cargo")
	private String cargo;

	@Column(name = "salario")
	private double salario;

	public Empleado() {

	}

	public Empleado(String nombre, String apellido, String tipoContrato, String numeroDocumento, Date fechaNacimiento,
			Date fechaVinculacion, String cargo, double salario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoContrato = tipoContrato;
		this.numeroDocumento = numeroDocumento;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaVinculacion = fechaVinculacion;
		this.cargo = cargo;
		this.salario = salario;
	}

	public int getIdEmpleado() {
		return idEmpleado;
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
