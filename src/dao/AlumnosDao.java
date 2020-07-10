package dao;

import java.util.ArrayList;

import entidad.Alumno;

public interface AlumnosDao {
	public ArrayList<Alumno> Listar();

	public ArrayList<Alumno> listar_X_Curso(int idCurso);

	public ArrayList<Alumno> listar_FueraDelCurso(int idCurso);
}
