package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.Materia;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

/**
 * Servlet implementation class servletAltaCursos
 */
@WebServlet("/servletAltaCursos")
public class servletAltaCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletAltaCursos() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		/*Cargo la lista de materias para enviar a la vista */
		
		ArrayList<Materia> listaMaterias = null; 
		MateriaNegocioImpl matNegocio = new MateriaNegocioImpl();

		/* Si encontro informacion seteo el atributo */
		if (matNegocio.listar().size() > 0) {
			listaMaterias = matNegocio.listar();
			request.setAttribute("listaMaterias", listaMaterias);
		}

		/* Cargo la lista de docentes para enviar a la vista */

		ArrayList<Docente> listaDocentes = null;
		DocenteNegocioImpl docNegocio = new DocenteNegocioImpl();

		if (docNegocio.listar().size() > 0) {
			listaDocentes = docNegocio.listar();
			request.setAttribute("listaDocentes", listaDocentes);
		}

		/* Cargo la lista de alumnos para enviar a la lista */

		ArrayList<Alumno> listaAlumnos = null;
		AlumnoNegocioImpl aluNegocio = new AlumnoNegocioImpl();

		if (aluNegocio.listar().size() > 0) {
			listaAlumnos = (ArrayList<Alumno>) aluNegocio.listar();
			request.setAttribute("listaAlumnos", listaAlumnos);
		}
		ArrayList<Curso> listaCursos = null;
		CursoNegocioImpl curNegocio = new CursoNegocioImpl();

		if (curNegocio.listar().size() > 0) {
			listaCursos = curNegocio.listar();
			request.setAttribute("listaCursos", listaCursos);
		}

		RequestDispatcher view = request.getRequestDispatcher("/administradorAltaCursos.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		/*Cargo la lista de materias para enviar a la vista */
		ArrayList<Materia> listaMaterias = null; 
		MateriaNegocioImpl matNegocio = new MateriaNegocioImpl();

		/* Si encontro informacion seteo el atributo */
		if (matNegocio.listar().size() > 0) {
			listaMaterias = matNegocio.listar();
			request.setAttribute("listaMaterias", listaMaterias);
		}

		/* Cargo la lista de docentes para enviar a la vista */

		ArrayList<Docente> listaDocentes = null;
		DocenteNegocioImpl docNegocio = new DocenteNegocioImpl();

		if (docNegocio.listar().size() > 0) {
			listaDocentes = docNegocio.listar();
			request.setAttribute("listaDocentes", listaDocentes);
		}

		/* Cargo la lista de alumnos para enviar a la lista */

		ArrayList<Alumno> listaAlumnos = null;
		AlumnoNegocioImpl aluNegocio = new AlumnoNegocioImpl();

		if (aluNegocio.listar().size() > 0) {
			listaAlumnos = (ArrayList<Alumno>) aluNegocio.listar();
			request.setAttribute("listaAlumnos", listaAlumnos);
		}
		;

		/* Cargo la lista de cursos para enviar a la vista */

		ArrayList<Curso> listaCursos = null;
		CursoNegocioImpl curNegocio = new CursoNegocioImpl();

		if (curNegocio.listar().size() > 0) {
			listaCursos = curNegocio.listar();
			request.setAttribute("listaCursos", listaCursos);
		}

		if (request.getParameter("btnAgregarCurso") != null) {

			int Materia = Integer.parseInt(request.getParameter("selectMateria"));
			int cuatrimestre = Integer.parseInt(request.getParameter("selectCuatrimestre"));
			int anio = Integer.parseInt(request.getParameter("selectAnio"));
			int Docente = Integer.parseInt(request.getParameter("selectDocente"));
			String inserto = null;

			if (Materia != 0 && cuatrimestre != 0 && anio != 0 && Docente != 0) {
				Curso curso = new Curso();
				curso.setCuatrimestre(Integer.parseInt(request.getParameter("selectCuatrimestre")));
				curso.setAnio(Integer.parseInt(request.getParameter("selectAnio")));
				Docente docente = new Docente();
				docente.setLegajo(Integer.parseInt(request.getParameter("selectDocente")));
				curso.setDocente(docente);
				Materia materia = new Materia();
				materia.setIdMateria(Integer.parseInt(request.getParameter("selectMateria")));
				curso.setMateria(materia);

				String[] array = request.getParameterValues("fila");

				if (array != null) {

					if (!curNegocio.agregar(curso)) {
						inserto = "NO";
						request.setAttribute("Inserto", inserto);
						RequestDispatcher view = request.getRequestDispatcher("/administradorAltaCursos.jsp");
						view.forward(request, response);
					} else {
						inserto = "SI";
						request.setAttribute("Inserto", inserto);

						int id_curso = curNegocio.buscoUltimoCursoInsertado();

						for (int j = 0; j < array.length; j++) {
							int legajoInsertar = Integer.parseInt(array[j]);
							curNegocio.inscribirAlumno(id_curso, legajoInsertar);
						}

						RequestDispatcher view = request.getRequestDispatcher("/administradorAltaCursos.jsp");
						view.forward(request, response);
					}
				} else {
					String seleccionoAlumnos = "NO";
					request.setAttribute("SeleccionoAlumnos", seleccionoAlumnos);
					RequestDispatcher view = request.getRequestDispatcher("/administradorAltaCursos.jsp");
					view.forward(request, response);
				}
			} else {
				request.setAttribute("Inserto", inserto);
				RequestDispatcher view = request.getRequestDispatcher("/administradorAltaCursos.jsp");
				view.forward(request, response);
			}

		}
		if (request.getParameter("btnBorrarCurso") != null) {
			
			CursoNegocioImpl CursoNegocio = new CursoNegocioImpl();
			
			int cursoBorrar ;
			cursoBorrar = Integer.parseInt(request.getParameter("btnBorrar"));

			boolean borroAlumnos = CursoNegocio.borrarAlumnosCursos(cursoBorrar);
			boolean borrarCurso = CursoNegocio.borrarCurso(cursoBorrar);

			RequestDispatcher view = request.getRequestDispatcher("/administradorAltaCursos.jsp");
			view.forward(request, response);
			
		}
	}
}
