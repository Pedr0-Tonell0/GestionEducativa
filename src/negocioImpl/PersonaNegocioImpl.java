package negocioImpl;

import java.util.ArrayList;

import daoImpl.PersonaDaoImpl;
import entidad.Datos;
import entidad.Localidad;
import entidad.Persona;
import entidad.Provincia;
import entidad.Roll;
import negocio.PersonasNegocio;

public class PersonaNegocioImpl implements PersonasNegocio {

	public boolean insertarRegistroPersona(Persona persona) throws Exception {
		return new PersonaDaoImpl().insertarRegistroPersona(persona);
	}

	public ArrayList<Provincia> listarProvincias() throws Exception {
		return new PersonaDaoImpl().listarProvincias();
	}

	public ArrayList<Roll> listarRoll() throws Exception {
		return new PersonaDaoImpl().listarRoll();
	}

	public ArrayList<Persona> listarPersonas() throws Exception {
		return new PersonaDaoImpl().listarPersonas();
	}

	public ArrayList<Localidad> listarLocalidades() throws Exception {
		return new PersonaDaoImpl().listarLocalidades();
	}

	public void eliminarPersona(int legajo) throws Exception {
		new PersonaDaoImpl().eliminarPersona(legajo);
	}

	public boolean existeRegistroPorDni(int dni) throws Exception {
		return new PersonaDaoImpl().existeRegistroPorDni(dni);
	}

	public void existeRegistroPorEmail(String email) throws Exception {
		new PersonaDaoImpl().existeRegistroPorEmail(email);
	}

	public Roll getRoll(String roll) throws Exception {
		return new PersonaDaoImpl().getRoll(roll);
	}

	public Provincia getProvincia(String provincia) throws Exception {
		return new PersonaDaoImpl().getProvincia(provincia);
	}

	public Localidad getLocalidad(String localidad) throws Exception {
		return new PersonaDaoImpl().getLocalidad(localidad);
	}

	public Persona getPersona(int leg) throws Exception {
		return new PersonaDaoImpl().getPersona(leg);
	}

	public void actualizarRegistroPersona(Persona persona) throws Exception {
		new PersonaDaoImpl().actualizarRegistroPersona(persona);
	}

	@Override
	public ArrayList<Datos> listarDatos() throws Exception {
		return new PersonaDaoImpl().listarDatos();
	}
}
