package negocio;

import java.util.ArrayList;

import entidad.Datos;
import entidad.Localidad;
import entidad.Persona;
import entidad.Provincia;
import entidad.Roll;

public interface PersonasNegocio {

	public boolean insertarRegistroPersona(Persona persona) throws Exception;

	public ArrayList<Provincia> listarProvincias() throws Exception;

	public ArrayList<Roll> listarRoll() throws Exception;
	
	public ArrayList<Persona> listarPersonas() throws Exception;
	
	public ArrayList<Localidad> listarLocalidades() throws Exception;

	public void eliminarPersona(int legajo) throws Exception;

	public boolean existeRegistroPorDni(int dni) throws Exception;

	public void existeRegistroPorEmail(String email) throws Exception;

	public Roll getRoll(String roll) throws Exception;
	
	public Provincia getProvincia(String provincia) throws Exception;
	
	public Localidad getLocalidad(String localidad) throws Exception;
	
	public Persona getPersona(int leg) throws Exception;

	public void actualizarRegistroPersona(Persona persona) throws Exception;
	
	public ArrayList<Datos> listarDatos() throws Exception;

	
}
