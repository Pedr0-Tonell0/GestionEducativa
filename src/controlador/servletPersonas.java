package controlador;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Localidad;
import entidad.Persona;
import entidad.Provincia;
import entidad.Roll;
import factory.factoryPersona;
import negocioImpl.LoginNegocioImpl;
import negocioImpl.PersonaNegocioImpl;

/**
 * Servlet implementation class servletPersonas
 */
@WebServlet("/servletPersonas")
public class servletPersonas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletPersonas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PersonaNegocioImpl pNegocio = new PersonaNegocioImpl();
			ArrayList<Roll> listaRoll = pNegocio.listarRoll();

			if (listaRoll.size() > 0) {
				request.setAttribute("listaRoll", listaRoll);
			}

			ArrayList<Provincia> listaProvincias = pNegocio.listarProvincias();
			if (listaProvincias.size() > 0) {
				request.setAttribute("listaProvincias", listaProvincias);
			}

			ArrayList<Localidad> listaLocalidades = pNegocio.listarLocalidades();
			if (listaProvincias.size() > 0) {
				request.setAttribute("listaLocalidades", listaLocalidades);
			}

			ArrayList<Persona> listaPersonas = pNegocio.listarPersonas();
			if (listaPersonas.size() > 0) {
				request.setAttribute("listaPersonas", listaPersonas);
			}

			RequestDispatcher rd = request.getRequestDispatcher("/personas.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String redireccion = "/personas.jsp";
		try {
			PersonaNegocioImpl pNegocio = new PersonaNegocioImpl();
			ArrayList<Roll> listaRoll = pNegocio.listarRoll();

			if (listaRoll.size() > 0) {
				request.setAttribute("listaRoll", listaRoll);
			}

			ArrayList<Provincia> listaProvincias = pNegocio.listarProvincias();
			if (listaProvincias.size() > 0) {
				request.setAttribute("listaProvincias", listaProvincias);
			}

			ArrayList<Localidad> listaLocalidades = pNegocio.listarLocalidades();
			if (listaProvincias.size() > 0) {
				request.setAttribute("listaLocalidades", listaLocalidades);
			}

			ArrayList<Persona> listaPersonas = pNegocio.listarPersonas();
			if (listaPersonas.size() > 0) {
				request.setAttribute("listaPersonas", listaPersonas);
			}

			if (request.getParameter("btnAgregar") != null) {
				agregarPersona(request, response, pNegocio, redireccion);
			}

			if (request.getParameter("btnBorrarPersona") != null) {
				int legajo = Integer.parseInt(request.getParameter("btnBorrar"));
				new PersonaNegocioImpl().eliminarPersona(legajo);
				mostrarMensaje(request, response, "Registro eliminado correctamente", redireccion);
			}

			if (request.getParameter("btnModificarPersona") != null) {
				modificarPersona(request, response, pNegocio, redireccion);

			}
		} catch (Exception e) {
			mostrarMensaje(request, response, e.getMessage(), redireccion);
		}
	}

	private void modificarPersona(HttpServletRequest request, HttpServletResponse response, PersonaNegocioImpl pNegocio,
			String redireccion) throws Exception {

		try {
			int leg = Integer.parseInt(request.getParameter("btnModificar"));
			Persona persona = pNegocio.getPersona(leg);
			request.setAttribute("persona", persona);
			request.setAttribute("roll", persona.getRoll().getRoll());
			request.setAttribute("provincia", persona.getLocalidad().getProvincia());
			request.setAttribute("localidad", persona.getLocalidad());
			request.setAttribute("dni", persona.getDni());
			request.setAttribute("fechaNacimiento", persona.getFechaNacimiento());
			RequestDispatcher rd = request.getRequestDispatcher(redireccion);
			rd.forward(request, response);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private void agregarPersona(HttpServletRequest request, HttpServletResponse response, PersonaNegocioImpl pNegocio,
			String redireccion) throws ServletException, IOException, Exception {

		try {
			Persona persona = getDatosPersona(request, response, pNegocio);
			if (!pNegocio.existeRegistroPorDni(persona.getDni())) {
				pNegocio.existeRegistroPorEmail(persona.getEmail());
				if(pNegocio.insertarRegistroPersona(persona)==true) {
					String mensaje = "El registro ha sido agregado correctamente";
					mostrarMensaje(request, response, mensaje, redireccion);
					RequestDispatcher rd = request.getRequestDispatcher("/personas.jsp");
					rd.forward(request, response);
					return;
				}
				 else {
					 String mensaje = "Error el registro no ha sido agregado";
						mostrarMensaje(request, response, mensaje, redireccion);
						RequestDispatcher rd = request.getRequestDispatcher("/personas.jsp");
						rd.forward(request, response);
						return;
					}
				/*	if (persona.getRoll().getIdRoll() == 1) {
						new LoginNegocioImpl().insertUsuario(persona);
						HttpSession misession = request.getSession(true);
						misession.setAttribute("Docente", persona);
						RequestDispatcher rd = request.getRequestDispatcher("/confirmar.jsp");
						rd.forward(request, response);
						return;
					}
					if (persona.getRoll().getIdRoll() == 2) {
						RequestDispatcher rd = request.getRequestDispatcher("/personas.jsp");
						rd.forward(request, response);
						return;
					}*/
				
			}
			else {
				String mensaje = "El registro ya existe";
				mostrarMensaje(request, response, mensaje, redireccion);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private Persona getDatosPersona(HttpServletRequest request, HttpServletResponse response,
			PersonaNegocioImpl pNegocio) throws Exception {
		Roll roll = pNegocio.getRoll(request.getParameter("selectRoll"));
		int dni = Integer.parseInt(request.getParameter("txtDni"));
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		LocalDate FechaNacimiento = LocalDate.parse(request.getParameter("dateFrom"));
		Provincia provincia = pNegocio.getProvincia(request.getParameter("selectProvincia"));
		Localidad localidad = pNegocio.getLocalidad(request.getParameter("selectLocalidad"));
		String direccion = request.getParameter("txtDireccion");
		String email = request.getParameter("txtEmail");
		int telefono = Integer.parseInt(request.getParameter("txtTelefono"));

		return factoryPersona.getInstance(roll, dni, nombre, apellido, FechaNacimiento, provincia, localidad, direccion,
				email, telefono);
	}

	private void mostrarMensaje(HttpServletRequest request, HttpServletResponse response, String mensaje,
			String redireccion) throws ServletException, IOException {
		request.setAttribute("mensaje", mensaje);
		RequestDispatcher rd = request.getRequestDispatcher(redireccion);
		rd.forward(request, response);
	}
}
