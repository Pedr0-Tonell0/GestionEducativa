package negocioImpl;


import java.util.ArrayList;

import dao.LoginDao;
import daoImpl.LoginDaoImpl;
import entidad.Docente;
import entidad.Persona;
import entidad.Usuario;
import negocio.LoginNegocio;

public class LoginNegocioImpl implements LoginNegocio{

	LoginDao ldao = new LoginDaoImpl();

	@Override
	public boolean validarLogin(String user, String pass) {
		return ldao.validarUsuarioContrasenia(user, pass);
	}

	public void insertUsuario(Persona persona) throws Exception {
		ldao.insertUsuario(persona);
		
	}

	@Override
	public int buscarLegajo(String user, String pass) {
		return ldao.buscarLegajo(user, pass);
	}

	@Override
	public int buscarRol(String user, String pass) {
		return ldao.buscarRol(user, pass);
	}

	@Override
	public Docente buscarDocente(int legajo) {
		return ldao.buscarDocente(legajo);
	}

	@Override
	public boolean CambiarPass(int legajo, String pass) {
        return ldao.cambiarPass(legajo, pass);		
	}

	@Override
	public ArrayList<Usuario> ListarUsuarios() {
		return ldao.listarUsuarios();
	}

	@Override
	public boolean CambiarUserPass(Usuario usuario) {
		return ldao.cambiarUserPass(usuario);
	}

}
