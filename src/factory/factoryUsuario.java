package factory;

import entidad.Usuario;

public class factoryUsuario {

	public static Usuario getInstance(int legajo, String usuario, String contrasenia, String nombre, String apellido) {

		Usuario output = new Usuario();
		output.setLegajo(legajo);
		output.setUsuario(usuario);
		output.setContrasenia(contrasenia);
		output.setNombre(nombre);
		output.setApellido(apellido);
		return output;

	}

}
