package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Curso;
import negocioImpl.ReporteNegocioImpl;

/**
 * Servlet implementation class servletReporte
 */
@WebServlet("/servletReporte")
public class servletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletReporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (request.getParameter("btnBuscar") != null) {
			if (request.getParameter("dateTo") == "" || request.getParameter("dateFrom") == "") {
				String mensaje;
				mensaje = "error";
				request.setAttribute("mensaje", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("/AdministradorReporte.jsp");
				rd.forward(request, response);
			}
			LocalDate FechaInicio = LocalDate.parse(request.getParameter("dateFrom"));
			LocalDate FechaFin = LocalDate.parse(request.getParameter("dateTo"));
			ReporteNegocioImpl cnegocio = new ReporteNegocioImpl();
			cnegocio.verificar();
			cnegocio.porcentaje();
			ArrayList<Curso> lista = null;
			try {
				lista = cnegocio.informe(FechaInicio, FechaFin);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("lista", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/AdministradorReporte.jsp");
			rd.forward(request, response);
		}

	}

}