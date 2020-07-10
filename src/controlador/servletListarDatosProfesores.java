package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Curso;
import entidad.Datos;
import negocioImpl.CursoNegocioImpl;
import negocioImpl.PersonaNegocioImpl;

/**
 * Servlet implementation class servletListarDatosProfesores
 */
@WebServlet("/servletListarDatosProfesores")
public class servletListarDatosProfesores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarDatosProfesores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Datos> lista = null;
		PersonaNegocioImpl pNegocio = new PersonaNegocioImpl();
		try {
			lista = pNegocio.listarDatos();
			request.setAttribute("lista", lista);
			RequestDispatcher Request = request.getRequestDispatcher("/datosProfesores.jsp");
			Request.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
