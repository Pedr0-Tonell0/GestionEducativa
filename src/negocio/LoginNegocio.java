package negocio;

import java.util.ArrayList;

import entidad.Docente;
import entidad.Persona;
import entidad.Usuario;

public interface LoginNegocio {

	public boolean validarLogin(String user, String pass);

	public void insertUsuario(Persona persona) throws Exception;

	public int buscarLegajo(String user, String pass);

	public int buscarRol(String user, String pass);

	public Docente buscarDocente(int legajo);

	public boolean CambiarPass(int legajo, String pass);
	
	public ArrayList <Usuario> ListarUsuarios();
	
	public boolean CambiarUserPass(Usuario usuario);

}
