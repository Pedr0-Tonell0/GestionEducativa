package negocioImpl;

import java.util.ArrayList;

import dao.CursosDao;
import daoImpl.CursoDaoImpl;
import entidad.Alumno;
import entidad.Curso;
import entidad.Materia;
import negocio.CursosNegocio;

public class CursoNegocioImpl implements CursosNegocio {

	CursoDaoImpl cdao = new CursoDaoImpl();

	public boolean agregar(Curso curso) {
		return cdao.agregar(curso);
	}

	public boolean inscribirAlumno(int idCurso, int legajoInsertar) {
		return cdao.inscribirAlumno(idCurso, legajoInsertar);
	}

	public int buscoUltimoCursoInsertado() {
		return cdao.buscoUltinoCursoInsertado();
	}

	public ArrayList<Curso> listar() {
		return cdao.listar();
	}

	public boolean borrarCurso(int ID_Curso) {

		return cdao.borrarCurso(ID_Curso);
	}

	public boolean borrarAlumnosCursos(int ID_Curso) {

		return cdao.borrarAlumnosCursos(ID_Curso);
	}

	public boolean actualizar(Curso curso) {
		return cdao.actualizar(curso);
	}

	public Curso buscar(int cursoSeleccionado) {
		return cdao.buscar(cursoSeleccionado);
	}

	@Override
	public ArrayList<Curso> cursosProfesor(int legajo) {
		return cdao.cursosProfesor(legajo);
	}

	@Override
	public ArrayList<Alumno> buscarAlumnos(int ID_CURSO) {
		return cdao.buscarAlumnos(ID_CURSO);
	}

	@Override
	public ArrayList<Curso> buscarNotas(int ID_CURSO) {
		return cdao.buscarNotas(ID_CURSO);
	}

	@Override
	public boolean cargarNotas(int IdCurso, int parcial1, int parcial2, int recuperatorio1, int recuperatorio2,
			int legajo, int estado) {
		return cdao.cargarNotas(IdCurso, parcial1, parcial2, recuperatorio1, recuperatorio2, legajo, estado);
	}

	public int existe_Registro(int cursoSeleccionado, int alumno) {
		return cdao.existe_Registro(cursoSeleccionado, alumno);
	}

	public boolean volver_A_Inscribir(int cursoSeleccionado, int alumno) {
		return cdao.volver_A_Inscribir(cursoSeleccionado, alumno);
	}

	public boolean borrarAlumnoCurso(int curso, int alumnoDarBaja) {
		return cdao.borrarAlumnoCurso(curso, alumnoDarBaja);
	}

	@Override
	public ArrayList<Alumno> buscarEstados() {
		return cdao.buscarEstados();
	}

	

}
