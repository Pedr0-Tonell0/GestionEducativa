package factory;

import java.time.LocalDate;

import entidad.Localidad;
import entidad.Persona;
import entidad.Provincia;
import entidad.Roll;

public class factoryPersona {

	public static Persona instance(String nombre, String apellido, String email, int dni, int legajo, int telefono) {

		Persona output = new Persona();
		output.setNombre(nombre);
		output.setApellido(apellido);
		output.setEmail(email);
		output.setDni(dni);
		output.setLegajo(legajo);
		output.setTelefono(telefono);
		return output;
		// hola

	}

	public static Persona getInstance(Roll roll, int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			Provincia provincia, Localidad localidad, String direccion, String email, int telefono) {

		Persona output = new Persona();
		output.setRoll(roll);
		output.setDni(dni);
		output.setNombre(nombre);
		output.setApellido(apellido);
		output.setFechaNacimiento(fechaNacimiento);
		if (provincia != null) {
			localidad.setProvincia(provincia);
		}
		if (localidad != null) {
			output.setLocalidad(localidad);
		}
		output.setDireccion(direccion);
		output.setEmail(email);
		output.setTelefono(telefono);
		return output;
	}

	public static Persona getInstance(Roll roll, int dni, String nombre, String apellido, LocalDate fechaNacimiento,
			Localidad localidad, String direccion, String email, int telefono) {

		Persona output = new Persona();
		output.setRoll(roll);
		output.setDni(dni);
		output.setNombre(nombre);
		output.setApellido(apellido);
		output.setFechaNacimiento(fechaNacimiento);
		output.setLocalidad(localidad);
		output.setDireccion(direccion);
		output.setEmail(email);
		output.setTelefono(telefono);
		return output;
	}
}
