package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuario;
import negocioImpl.LoginNegocioImpl;

/**
 * Servlet implementation class servletUsuarios
 */
@WebServlet("/servletUsuarios")
public class servletUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Usuario> listaUsuarios = null;
		LoginNegocioImpl lNegocio = new LoginNegocioImpl();	
	    if(lNegocio.ListarUsuarios().size() > 0)	
	    {
	    	listaUsuarios = lNegocio.ListarUsuarios();
	    	request.setAttribute("listaUsuarios", listaUsuarios);
			RequestDispatcher view = request.getRequestDispatcher("/AdmCambiarPass.jsp");
			view.forward(request, response);
	    	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Usuario> listaUsuarios = null;
		LoginNegocioImpl lNegocio = new LoginNegocioImpl();
	   
		if(request.getParameter("btnModificar")!= null)
		{
			int legajo = Integer.parseInt(request.getParameter("legajo"));
			String user =(String) request.getParameter("usuario");
			String pass = (String) request.getParameter("contraseña");
			request.setAttribute("legajo", legajo);
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
		}
		if(request.getParameter("btnActualizar")!= null)
		{
			int legajo = Integer.parseInt(request.getParameter("legajo"));
			
			if(legajo !=0)
			{
				String user =(String) request.getParameter("usuario");
				String pass = (String) request.getParameter("contraseña");
				Usuario usuario = new Usuario();
				usuario.setLegajo(legajo);
				usuario.setUsuario(user);
				usuario.setContrasenia(pass);
			
				if(lNegocio.CambiarUserPass(usuario)==true)
				{
					 String mensaje1;
		 			 mensaje1 = "El usuario y contraseña fue cambiado correctamente";
		 			 request.setAttribute("mensaje1",mensaje1);
				}
				else {
					 String mensaje2;
		 			 mensaje2 = "No se pudo completar la accion solicitada";
		 		     request.setAttribute("mensaje2",mensaje2);
				}
			}
			else
			{
				String mensaje3;
				mensaje3 = "Antes debe seleccionar un registro";
		 		request.setAttribute("mensaje3",mensaje3);
			}
		}
		
		 if(lNegocio.ListarUsuarios().size() > 0)	
		    {
		    	listaUsuarios = lNegocio.ListarUsuarios();
		    	request.setAttribute("listaUsuarios", listaUsuarios);
		    }
		RequestDispatcher view = request.getRequestDispatcher("/AdmCambiarPass.jsp");
		view.forward(request, response);
	}

}
