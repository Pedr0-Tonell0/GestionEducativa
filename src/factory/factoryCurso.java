package factory;

import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.Materia;

public class factoryCurso {

	public static Curso getInstance(int idCurso, int anio, int cuatrimestre, int aprobado, int desaprobado,
			Materia materia, Docente docente) {

		Curso output = new Curso();
		output.setIdCurso(idCurso);
		output.setAnio(anio);
		output.setCuatrimestre(cuatrimestre);
		output.setAprobados(aprobado);
		output.setDesaprobados(desaprobado);
		output.setMateria(materia);
		output.setDocente(docente);
		return output;

	}

	public static Curso getInstance(int idCurso, int parcial1, int parcial2, int recuperatorio1, int recuperatorio2,
			int estado, Alumno alumno) {

		Curso output = new Curso();
		output.setIdCurso(idCurso);
		output.setParcial1(parcial1);
		output.setParcial2(parcial2);
		output.setRecuperatorio1(recuperatorio1);
		output.setRecuperatorio2(recuperatorio2);
		output.setEstado(estado);
		output.setAlumno(alumno);
		return output;

	}

}
