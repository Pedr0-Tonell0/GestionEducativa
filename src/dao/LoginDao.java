package dao;

import java.util.ArrayList;

import entidad.Docente;
import entidad.Persona;
import entidad.Usuario;

public interface LoginDao {

	public boolean validarUsuarioContrasenia(String user, String pass);

	public void insertUsuario(Persona persona) throws Exception;

	public int buscarLegajo(String user, String pass);

	public int buscarRol(String user, String pass);

	public Docente buscarDocente(int legajo);

	public boolean cambiarPass(int legajo, String pass);

	public ArrayList<Usuario> listarUsuarios();

	public boolean cambiarUserPass(Usuario usuario);

}
