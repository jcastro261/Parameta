package com.proyecto.parameta.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.proyecto.parameta.entity.Empleado;

public class Util {

	public static boolean verificarParametros(String nombre, String apellido, String tipoContrato,
			String numeroDocumento, String cargo, double salario, Date fechaNacimiento) {

		if (nombre == "")
			return false;
		else if (nombre == null)
			return false;
		else if (nombre.trim().length() > 20)
			return false;

		if (obtenerEdad(fechaNacimiento, new Date()) < 18)
			return false;

		if (apellido == "")
			return false;
		else if (apellido == null)
			return false;
		else if (apellido.trim().length() > 20)
			return false;

		if (tipoContrato == "")
			return false;
		else if (tipoContrato == null)
			return false;
		else if (tipoContrato.trim().length() > 50)
			return false;

		if (numeroDocumento == "")
			return false;
		else if (numeroDocumento == null)
			return false;
		else if (numeroDocumento.trim().length() > 10)
			return false;

		if (cargo == "")
			return false;
		else if (cargo == null)
			return false;
		else if (cargo.trim().length() > 10)
			return false;

		if (salario == 0)
			return false;

		return true;

	}

	public static boolean verificarEmppleado(Empleado empleado) {

		if (empleado == null)
			return false;

		else if (empleado.getNombre() == null && empleado.getNombre() == "")
			return false;

		else if (empleado.getApellido() == null && empleado.getApellido() == "")
			return false;

		else if (empleado.getTipoContrato() == null && empleado.getTipoContrato() == "")
			return false;

		else if (empleado.getNumeroDocumento() == null && empleado.getNumeroDocumento() == "")
			return false;

		else if (empleado.getFechaNacimiento() == null)
			return false;

		else if (empleado.getFechaVinculacion() == null)
			return false;

		else if (empleado.getCargo() == null && empleado.getCargo() == "")
			return false;

		else if (empleado.getSalario() == 0)
			return false;

		return true;

	}

	public static boolean validarId(int id) {

		if (id == 0)
			return false;
		return true;
	}

	public static String imprimirEdad(Date fecha, Date fechaActual, boolean imprimirDias) {
		String resultado = new String();
		int diferenciaAnios = 0;
		int diferenciaMeses = 0;
		int diferenciaDias = 0;

		Calendar calendario = new GregorianCalendar();
		Calendar calendario2 = new GregorianCalendar();

		calendario.setTime(fecha);
		calendario2.setTime(fechaActual);

		diferenciaAnios = calendario2.get(Calendar.YEAR) - calendario.get(Calendar.YEAR);
		diferenciaMeses = calendario2.get(Calendar.MONTH) - calendario.get(Calendar.MONTH);
		diferenciaDias = calendario2.get(Calendar.DATE) - calendario.get(Calendar.DATE);

		if (diferenciaMeses < 0 || (diferenciaMeses == 0 && diferenciaDias < 0)) {
			diferenciaAnios--;
			diferenciaMeses += 12;
		}

		if (diferenciaDias < 0) {
			diferenciaMeses--;

			if (calendario.get(Calendar.MONTH) == 2)
				diferenciaDias += 28;
			else if (calendario.get(Calendar.MONTH) == 4 || calendario.get(Calendar.MONTH) == 6
					|| calendario.get(Calendar.MONTH) == 9 || calendario.get(Calendar.MONTH) == 11)
				diferenciaDias += 30;
			else
				diferenciaDias += 31;
		}

		resultado = diferenciaAnios + " años, " + diferenciaMeses + " meses ";
		if (imprimirDias)
			resultado += ", " + diferenciaDias + " dias";

		return resultado;
	}

	public static int obtenerEdad(Date fecha, Date fechaActual) {

		int diferenciaAnios = 0;
		int diferenciaMeses = 0;
		int diferenciaDias = 0;

		Calendar calendario = new GregorianCalendar();
		Calendar calendario2 = new GregorianCalendar();

		calendario.setTime(fecha);
		calendario2.setTime(fechaActual);

		diferenciaAnios = calendario2.get(Calendar.YEAR) - calendario.get(Calendar.YEAR);
		diferenciaMeses = calendario2.get(Calendar.MONTH) - calendario.get(Calendar.MONTH);
		diferenciaDias = calendario2.get(Calendar.DATE) - calendario.get(Calendar.DATE);

		if (diferenciaMeses < 0 || (diferenciaMeses == 0 && diferenciaDias < 0)) {
			diferenciaAnios--;
			diferenciaMeses += 12;
		}

		return diferenciaAnios;

	}

}
