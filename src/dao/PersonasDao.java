package dao;

import java.util.ArrayList;

import entidad.Datos;
import entidad.Persona;

public interface PersonasDao {

	boolean insertarRegistroPersona(Persona persona) throws Exception;
	public ArrayList<Datos> listarDatos() throws Exception;
}
