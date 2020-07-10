package factory;

import java.sql.Date;

import entidad.Alumno;
import entidad.Localidad;
import entidad.Tipo_Persona;

public class factoryAlumno {

	public static Alumno getInstance(int legajo, int dni, String nombre, String apellido, String email, int telefono,
			Tipo_Persona tipo, String direccion, Localidad localidad, Date fechaNacimiento, int idEstado) {

		Alumno output = new Alumno();
		output.setLegajo(legajo);
		output.setDNI(dni);
		output.setNombre(nombre);
		output.setApellido(apellido);
		output.setMail(email);
		output.setTelefono(telefono);
		output.setTipo_Persona(tipo);
		output.setDireccion(direccion);
		output.setLocalidad(localidad);
		output.setFecha_nacimiento(fechaNacimiento);
		output.setID_Estado(idEstado);
		return output;
	}

	public static Alumno getInstance(int legajo, String nombre, String apellido, String mail, int telefono, int dni) {
		
		Alumno output = new Alumno();
		output.setLegajo(legajo);
		output.setNombre(nombre);
		output.setApellido(apellido);
		output.setMail(mail);
		output.setTelefono(telefono);
		output.setDNI(dni);
		return output;
		
	}

}
