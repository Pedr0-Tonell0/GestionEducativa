package negocio;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnosNegocio {

	public ArrayList<Alumno> listar();

	public ArrayList<Alumno> listar_X_Curso(int ID_Curso);

	public ArrayList<Alumno> listar_FueraDelCurso(int idCurso);
}
