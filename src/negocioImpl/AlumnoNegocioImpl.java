package negocioImpl;

import java.util.ArrayList;

import daoImpl.AlumnoDaoImpl;
import entidad.Alumno;
import negocio.AlumnosNegocio;

public class AlumnoNegocioImpl implements AlumnosNegocio {

	AlumnoDaoImpl adao = new AlumnoDaoImpl();

	public ArrayList<Alumno> listar() {

		return adao.listar();
	}

	@Override
	public ArrayList<Alumno> listar_X_Curso(int ID_Curso) {
		return adao.listar_X_Curso(ID_Curso);
	}

	public ArrayList<Alumno> listar_FueraDelCurso(int idCurso) {
		return adao.listar_FueraDelCurso(idCurso);
	}
}
