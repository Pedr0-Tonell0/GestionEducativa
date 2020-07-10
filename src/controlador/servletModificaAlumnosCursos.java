package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Alumno;
import entidad.Curso;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.CursoNegocioImpl;

/**
 * Servlet implementation class servletModificaAlumnosCursos
 */
@WebServlet("/servletModificaAlumnosCursos")
public class servletModificaAlumnosCursos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletModificaAlumnosCursos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession misession = (HttpSession) request.getSession();
		int cursoSeleccionado = (int) misession.getAttribute("IDCursoSeleccionado");

		ArrayList<Alumno> listaAlumnosActivos = null;
		ArrayList<Alumno> listaAlumnosNoCurso = null;
		
		if(cursoSeleccionado != 0)
		{
			AlumnoNegocioImpl aluNegocio = new AlumnoNegocioImpl();
			CursoNegocioImpl curNeg = new CursoNegocioImpl();
			Curso curso = new Curso();

			try {
				curso = curNeg.buscar(cursoSeleccionado);
			} catch (Exception e) {
				curso = null;
			}

			request.setAttribute("IDCursoSeleccionado", curso.getIdCurso());
			request.setAttribute("IDMateriaSleccionada", curso.getMateria().getNombre());


			String cuatricompleto = "Cuatrimestre " + String.valueOf(curso.getCuatrimestre());





			request.setAttribute("IDCuatriSeleccionado", cuatricompleto);


			if (aluNegocio.listar_X_Curso(curso.getIdCurso()).size() > 0) {
				listaAlumnosActivos = (ArrayList<Alumno>) aluNegocio.listar_X_Curso(curso.getIdCurso());
				request.setAttribute("listaAlumnosActivos", listaAlumnosActivos);
			}

			if (aluNegocio.listar_FueraDelCurso(curso.getIdCurso()).size() > 0) {
				listaAlumnosNoCurso = (ArrayList<Alumno>) aluNegocio.listar_FueraDelCurso(curso.getIdCurso());
				request.setAttribute("listaAlumnosNoCurso", listaAlumnosNoCurso);
			}

			RequestDispatcher view = request.getRequestDispatcher("/administradorModificarAlumnos.jsp");
			view.forward(request, response);

		}
		else 
		{
			RequestDispatcher view = request.getRequestDispatcher("/administradorBMCursos.jsp");
			view.forward(request, response);
		}

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession misession = (HttpSession) request.getSession();
		int cursoSeleccionado = (int) misession.getAttribute("IDCursoSeleccionado");
		CursoNegocioImpl curNeg = new CursoNegocioImpl();

		if (request.getParameter("btnAgregarAlumnoACurso") != null) {
			int alumno = Integer.parseInt(request.getParameter("selectAlumno"));
			
			
			String Mensaje;

			if (curNeg.existe_Registro(cursoSeleccionado, alumno) != -1) {
				int Estado = curNeg.existe_Registro(cursoSeleccionado, alumno);

				if (Estado == 1) {
					if (curNeg.volver_A_Inscribir(cursoSeleccionado, alumno)) {
						Mensaje = "INSCRIPCION_NUEVAMENTE";
					} else {
						Mensaje = "ERROR";
					}
				}
				else
				{
					Mensaje = "YA_EXISTE";
				}

			} else {
				if (curNeg.inscribirAlumno(cursoSeleccionado, alumno)) {
					Mensaje = "ALTA";
				} else {
					Mensaje = "ERROR";
				}
			}

		}
		
		if(request.getParameter("btnBorrarAlumnoCurso")!= null)
		{
			cursoSeleccionado = (int)misession.getAttribute("IDCursoSeleccionado");
			String[] AlumnosABorrar = request.getParameterValues("fila");
			CursoNegocioImpl curNegocio = new CursoNegocioImpl();
			
			
			
			if(AlumnosABorrar != null)
			{
				for (int j=0; j<AlumnosABorrar.length; j++) {
					
					int LegajoInsertar =Integer.parseInt(AlumnosABorrar[j]);

					curNegocio.borrarAlumnoCurso(cursoSeleccionado,LegajoInsertar);
					
					
					}
			}
			
		}

		ArrayList<Alumno> listaAlumnosActivos = null;
		ArrayList<Alumno> listaAlumnosNoCurso = null;

		AlumnoNegocioImpl aluNegocio = new AlumnoNegocioImpl();
		Curso curso = new Curso();

		try {
			curso = curNeg.buscar(cursoSeleccionado);
		} catch (Exception e) {
			curso = null;
		}

		request.setAttribute("IDCursoSeleccionado", curso.getIdCurso());
		request.setAttribute("IDMateriaSleccionada", curso.getMateria().getNombre());

		String cuatricompleto = "Cuatrimestre " + String.valueOf(curso.getCuatrimestre());

		request.setAttribute("IDCuatriSeleccionado", cuatricompleto);

		if (aluNegocio.listar_X_Curso(curso.getIdCurso()).size() > 0) {
			listaAlumnosActivos = (ArrayList<Alumno>) aluNegocio.listar_X_Curso(curso.getIdCurso());
			request.setAttribute("listaAlumnosActivos", listaAlumnosActivos);
		}

		if (aluNegocio.listar_FueraDelCurso(curso.getIdCurso()).size() > 0) {
			listaAlumnosNoCurso = (ArrayList<Alumno>) aluNegocio.listar_FueraDelCurso(curso.getIdCurso());
			request.setAttribute("listaAlumnosNoCurso", listaAlumnosNoCurso);
		}
		RequestDispatcher view = request.getRequestDispatcher("/administradorModificarAlumnos.jsp");
		view.forward(request, response);

	}

}
