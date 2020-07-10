package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Docente;
import negocioImpl.LoginNegocioImpl;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rol;
		int legajo;
		if (request.getParameter("btnIngresar") != null) {
			String user = (request.getParameter("txtUsuario"));
			String pass = (request.getParameter("txtPass"));
			LoginNegocioImpl lnegocio = new LoginNegocioImpl();
			Docente docente = new Docente();

			rol=lnegocio.buscarRol(user, pass);
			if (lnegocio.validarLogin(user, pass) == true && rol == 1) {
				HttpSession misession = request.getSession(true);
				misession.setAttribute("Usuario", user);
				RequestDispatcher rd = request.getRequestDispatcher("/homeadm.jsp");
				rd.forward(request, response);
			}
			
			else if (lnegocio.validarLogin(user, pass) == true && rol == 2) {
				HttpSession misession = request.getSession(true);
				legajo=lnegocio.buscarLegajo(user, pass);
				docente = lnegocio.buscarDocente(legajo);
				misession.setAttribute("Docente", docente);
				misession.setAttribute("user", user);
				misession.setAttribute("pass", pass);
				RequestDispatcher rd = request.getRequestDispatcher("/homeProfesor.jsp");
				rd.forward(request, response);
			}
			else {
			     String mensaje;
				mensaje = "error";
				request.setAttribute("mensaje",mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");   
		        rd.forward(request, response);
		}
		}
		
		}

	}

