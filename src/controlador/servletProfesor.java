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
import entidad.Calificaciones;
import entidad.Curso;
import entidad.Docente;
import entidad.Materia;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

/**
 * Servlet implementation class servletProfesor
 */
@WebServlet("/servletProfesor")
public class servletProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletProfesor() {
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
		Docente docente = (Docente) misession.getAttribute("Docente");
		ArrayList<Curso> listaCursos = null;
		CursoNegocioImpl cNegocio = new CursoNegocioImpl();

		if (cNegocio.cursosProfesor(docente.getLegajo()).size() > 0) {
			listaCursos = cNegocio.cursosProfesor(docente.getLegajo());
			request.setAttribute("listaCursos", listaCursos);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/listado.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CursoNegocioImpl cNegocio = new CursoNegocioImpl();
		ArrayList<Curso> lista = null;
		int curso = 0;
		if (request.getParameter("btnCalificar1") != null) {
			curso = Integer.parseInt(request.getParameter("btnCalificar2"));
			HttpSession misession = request.getSession(true);
			misession.setAttribute("curso", curso);
			RequestDispatcher Request = request.getRequestDispatcher("/servletNotas");
			Request.forward(request, response);
		}

		if (request.getParameter("btnVer1") != null) {
			curso = Integer.parseInt(request.getParameter("btnVer2"));
			lista = cNegocio.buscarNotas(curso);
			request.setAttribute("lista", lista);
			RequestDispatcher Request = request.getRequestDispatcher("/calificacionesVista.jsp");
			Request.forward(request, response);
		}

	

	}

}