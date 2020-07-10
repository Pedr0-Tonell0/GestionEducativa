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
import entidad.Docente;
import entidad.Materia;
import negocioImpl.AlumnoNegocioImpl;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.DocenteNegocioImpl;
import negocioImpl.MateriaNegocioImpl;

/**
 * Servlet implementation class servletBMcursos
 */
@WebServlet("/servletBMcursos")
public class servletBMcursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBMcursos() {
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

		ArrayList<Curso> listaCursos = null;
		CursoNegocioImpl curNegocio = new CursoNegocioImpl();

		if (curNegocio.listar().size() > 0) {
			listaCursos = curNegocio.listar();
			request.setAttribute("listaCursos", listaCursos);
		}

		RequestDispatcher view = request.getRequestDispatcher("/administradorBMCursos.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		ArrayList<Materia> listaMaterias = null; 
		MateriaNegocioImpl matNegocio = new MateriaNegocioImpl();
		
		HttpSession misession = request.getSession(true);
		misession.setAttribute("IDCursoSeleccionado", 0);

		/* Cargo la lista de docentes para enviar a la vista */

		ArrayList<Docente> listaDocentes = null;
		DocenteNegocioImpl docNegocio = new DocenteNegocioImpl();

		/* Cargo la lista de cursos para enviar a la vista */
		ArrayList<Curso> listaCursos = null;
		CursoNegocioImpl curNegocio = new CursoNegocioImpl();

		if (request.getParameter("btnBorrarCurso") != null) {

			int cursoBorrar;
			cursoBorrar = Integer.parseInt(request.getParameter("btnBorrar"));
			String mensaje;

			if(curNegocio.borrarAlumnosCursos(cursoBorrar) && curNegocio.borrarCurso(cursoBorrar))
			{
				mensaje = "OK";
			}
			else
			{
				mensaje = "NOK";
			}
			request.setAttribute("mensajeBorrado",mensaje); 
			
		}
		
		if(request.getParameter("btnModificarCurso")!= null)
		{
			int idCurso = Integer.parseInt(request.getParameter("btnModificar"));
			int materiaSeleccionada = Integer.parseInt(request.getParameter("btnModificarMateria"));
			int cuatriSeleccionado = Integer.parseInt(request.getParameter("btnModificarCuatri"));
			int anioSeleccionado = Integer.parseInt(request.getParameter("btnModificarAnio"));
			int docenteSeleccionado = Integer.parseInt(request.getParameter("btnModificarDocente"));

			request.setAttribute("CursoSeleccionada", idCurso);
			request.setAttribute("MateriaSeleccionada", materiaSeleccionada);
			request.setAttribute("CuatriSeleccionado", cuatriSeleccionado);
			request.setAttribute("AnioSeleccionado", anioSeleccionado);
			request.setAttribute("DocenteSeleccionado", docenteSeleccionado);

			misession.setAttribute("IDCursoSeleccionado", idCurso);
			
			request.setAttribute("presionoModificar", "1");
			ArrayList<Alumno> listaAlumnos = null; 
			AlumnoNegocioImpl aluNegocio = new AlumnoNegocioImpl();

			if (aluNegocio.listar_X_Curso(idCurso).size() > 0) {
				listaAlumnos = (ArrayList<Alumno>) aluNegocio.listar_X_Curso(idCurso);
				request.setAttribute("listaAlumnos", listaAlumnos);
			}

		}
		
		if(request.getParameter("btnModificarCursoUpdate")!= null)
		{
			int idCurso=0;
			if(Integer.parseInt(request.getParameter("IDCursoSelecc")) != 0)
			{
				 idCurso= Integer.parseInt(request.getParameter("IDCursoSelecc"));
			}
			 
			int materiaSeleccionadga = Integer.parseInt(request.getParameter("selectMateria"));
			int cuatriSeleccionado = Integer.parseInt(request.getParameter("selectCuatrimestre"));
			int anioSeleccionado = Integer.parseInt(request.getParameter("selectAnio"));
			int docenteSeleccionado = Integer.parseInt(request.getParameter("selectDocente"));

			if (materiaSeleccionadga != 0 & cuatriSeleccionado != 0 & anioSeleccionado != 0 & docenteSeleccionado != 0 & idCurso != 0) {
				Curso curso = new Curso();
				
				curso.setIdCurso(idCurso);
				Materia materia = new Materia();
				materia.setIdMateria(materiaSeleccionadga);
				curso.setMateria(materia);
				curso.setCuatrimestre(cuatriSeleccionado);
				curso.setAnio(anioSeleccionado);

				Docente docente = new Docente();
				docente.setLegajo(docenteSeleccionado);
				curso.setDocente(docente);

				String mensaje=""; 
				if (curNegocio.actualizar(curso)) {
					mensaje = "OK";

				 }
				 else 
				 {
					 mensaje = "NOK";

				 }
				request.setAttribute("mensajeActualizar", mensaje);
			}
		}
		
		if(request.getParameter("btnModificarCursoAlumnos")!= null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/servletModificaAlumnosCursos");
			view.forward(request, response);
						
			
		}
		if (matNegocio.listar().size() > 0) {
			listaMaterias = matNegocio.listar();
			request.setAttribute("listaMaterias", listaMaterias);
		}
		if (docNegocio.listar().size() > 0) {
			listaDocentes = docNegocio.listar();
			request.setAttribute("listaDocentes", listaDocentes);
		}
		if (curNegocio.listar().size() > 0) {
			listaCursos = curNegocio.listar();
			request.setAttribute("listaCursos", listaCursos);
		}		
			
		RequestDispatcher view = request.getRequestDispatcher("/administradorBMCursos.jsp");
		view.forward(request, response);
	}

}
