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
import negocioImpl.CursoNegocioImpl;

/**
 * Servlet implementation class servletNotas
 */
@WebServlet("/servletNotas")
public class servletNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletNotas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CursoNegocioImpl cNegocio = new CursoNegocioImpl();
		ArrayList<Alumno> listaAlumnos = null;
		ArrayList<Alumno> listaEstados= null;
		HttpSession misession = request.getSession(true);
		int curso = (Integer) misession.getAttribute("curso");
		listaAlumnos = cNegocio.buscarAlumnos(curso);
		listaEstados= cNegocio.buscarEstados();
		request.setAttribute("listaEstados", listaEstados);
		request.setAttribute("listaAlumnos", listaAlumnos);
		request.setAttribute("curso", curso);
		
		
		RequestDispatcher Request = request.getRequestDispatcher("/calificaciones.jsp");
		Request.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursoNegocioImpl cNegocio = new CursoNegocioImpl();
		ArrayList<Alumno> listaAlumnos = null;
		ArrayList<Alumno> listaEstados= null;
		HttpSession misession = request.getSession(true);
		int curso = (Integer) misession.getAttribute("curso");
		listaAlumnos = cNegocio.buscarAlumnos(curso);
		listaEstados= cNegocio.buscarEstados();
		request.setAttribute("listaEstados", listaEstados);
		request.setAttribute("listaAlumnos", listaAlumnos);
		request.setAttribute("curso", curso);
		
		
		if (request.getParameter("btnAgregarCalificacion") != null) {
			String[] listadoNotas = request.getParameterValues("notas");
			String[] listadoEstados = request.getParameterValues("cboxEstado");
			String[] listadoLegajos = request.getParameterValues("legajos");
			ArrayList<Alumno> listadoAlumnos = new ArrayList<Alumno>();
			ArrayList<Calificaciones> listadoNotasxAlumno = new ArrayList<Calificaciones>();
			ArrayList<Calificaciones> listadoFinal = new ArrayList<Calificaciones>();
			Calificaciones calificacion = new Calificaciones();
			
			// GUARDO LOS LEGAJOS
			for (String legajo : listadoLegajos) {
				Alumno AlumnoCurso = new Alumno();
				AlumnoCurso.setLegajo(Integer.parseInt(legajo));
				listadoAlumnos.add(AlumnoCurso);
			}

			// GUARDO LAS CALIFICACIONES
			
			int contador = 0;
			for (int i = 0; i < listadoNotas.length; i++) { 

				contador++; 
				if (contador == 1)
					calificacion.setParcial1(Integer.parseInt(listadoNotas[i]));
				else if (contador == 2)
					calificacion.setParcial2(Integer.parseInt(listadoNotas[i]));
				else if (contador == 3)
					calificacion.setRecuperatorio1(Integer.parseInt(listadoNotas[i]));
				else if (contador == 4) {
					calificacion.setRecuperatorio2(Integer.parseInt(listadoNotas[i]));
					listadoNotasxAlumno.add(calificacion);
					calificacion = null;
					calificacion = new Calificaciones();
					contador = 0;
				}
			}
			// GUARDO LOS ESTADOS

			for (int i = 0; i < listadoNotasxAlumno.size(); i++) {

				for (int j = 0; j < listadoEstados.length; j++) {

					if (i == j) {

						listadoNotasxAlumno.get(i).setEstado(Integer.parseInt(listadoEstados[j]));
					}
				}
			}
			// GUARDO EL REGISTRO ENTERO LEGAJO + CALIFICACIONES + ESTADO

			for (int i = 0; i < listadoAlumnos.size(); i++) {

				for (int j = 0; j < listadoNotasxAlumno.size(); j++) {

					if (i == j) {

						Calificaciones Calificacion = new Calificaciones();
						Calificacion = listadoNotasxAlumno.get(i);
						Calificacion.setLegajo(listadoAlumnos.get(i).getLegajo());
						listadoFinal.add(Calificacion);
					}
				}
			}

			// LLAMO AL METODO DE LA BASE DE DATOS PARA HACER EL UPDATE Y CARGAR LAS NOTAS

			curso = Integer.parseInt(request.getParameter("btnCalificar"));
			CursoNegocioImpl cursosNegocio = new CursoNegocioImpl();
			for (Calificaciones calificaciones : listadoFinal) {

				cursosNegocio.cargarNotas(curso, calificaciones.getParcial1(), calificaciones.getParcial2(),
						calificaciones.getRecuperatorio1(), calificaciones.getRecuperatorio2(),
						calificaciones.getLegajo(), calificaciones.getEstado());
			}

		        String mensaje;
				mensaje = "Notas cargadas exitosamente";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("/calificaciones.jsp");
				rd.forward(request, response);
			
		}
		RequestDispatcher Request = request.getRequestDispatcher("/calificaciones.jsp");
		Request.forward(request, response);
	}

}
