package factory;

import java.sql.Date;

import entidad.Docente;
import entidad.Localidad;
import entidad.Tipo_Persona;

public class factoryDocente {

	public static Docente getInstance(int legajo, String nombre, String apellido) {

		Docente output = new Docente();
		output.setLegajo(legajo);
		output.setNombre(nombre);
		output.setApellido(apellido);
		return output;

	}

	public static Docente getInstance(int legajo, int dni, String nombre, String apellido, String mail, int telefono,
			String direccion, Date fechaNacimiento, int idEstado, Tipo_Persona tipo, Localidad localidad) {

		Docente output = new Docente();
		output.setLegajo(legajo);
		output.setDNI(dni);
		output.setNombre(nombre);
		output.setApellido(apellido);
		output.setNombre(nombre);
		output.setMail(mail);
		output.setTelefono(telefono);
		output.setDireccion(direccion);
		output.setFecha_nacimiento(fechaNacimiento);
		output.setID_Estado(idEstado);
		output.setTipo_Persona(tipo);
		output.setLocalidad(localidad);
		return output;

	}

}
