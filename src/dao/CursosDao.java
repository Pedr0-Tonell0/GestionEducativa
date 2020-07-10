package dao;

import java.util.ArrayList;

import entidad.Alumno;
import entidad.Curso;

public interface CursosDao {

	public boolean agregar(Curso curso);

	public boolean inscribirAlumno(int idCurso, int legajoInsertar);

	public int buscoUltinoCursoInsertado();

	public boolean borrarCurso(int ID_Curso);

	public boolean borrarAlumnosCursos(int ID_Curso);

	public boolean actualizar(Curso curso);

	public Curso buscar(int cursoSeleccionado);

	public ArrayList<Curso> cursosProfesor(int legajo);

	public ArrayList<Alumno> buscarAlumnos(int ID_CURSO);

	public ArrayList<Curso> buscarNotas(int ID_CURSO);

	public boolean cargarNotas(int IdCurso, int parcial1, int parcial2, int recuperatorio1, int recuperatorio2,
			int legajo, int estado);

	public int existe_Registro(int cursoSeleccionado, int alumno);
	
	public ArrayList<Alumno> buscarEstados();
}
