package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.LoginDao;
import dao.queries.queriesDocente;
import dao.queries.queriesUsuario;
import entidad.Docente;
import entidad.Persona;
import entidad.Usuario;
import factory.factoryUsuario;

public class LoginDaoImpl extends Dao implements LoginDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";

	@Override
	public boolean validarUsuarioContrasenia(String Usuario, String Contrasenia) {

		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesUsuario.VALIDAR_USUARIO.getQuery());
			miSentencia.setString(1, Usuario);
			miSentencia.setString(2, Contrasenia);
			resultado = miSentencia.executeQuery();
			if (resultado.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return false;
	}

	@Override
	public void insertUsuario(Persona persona) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			int legajoProfesor = getMaximoLegajoPersona(con);
			pstmt = con.prepareStatement(queriesUsuario.INSERT_USUARIO.getQuery());
			pstmt.setInt(1, legajoProfesor);
			pstmt.setString(2, String.valueOf(persona.getDni()) + ".frgp");
			pstmt.setString(3, String.valueOf(persona.getDni()));
			pstmt.setInt(4, persona.getRoll().getIdRoll()+1);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(con, pstmt);
		}
	}

	private int getMaximoLegajoPersona(Connection con) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(queriesUsuario.GET_MAXIMO_LEGAJO.getQuery());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			cerrarRecurso(pstmt, rs);
		}
		return 0;
		
	}

	@Override
	public int buscarLegajo(String Usu, String contrasenia) {

		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement("select u.legajo from usuario as u where u.USUARIO = ? and u.CONTRASEÑA = ?");
			miSentencia.setString(1, Usu);
			miSentencia.setString(2, contrasenia);
			resultado = miSentencia.executeQuery();
			if (resultado.next()) {
				return resultado.getInt("u.legajo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return 0;
	}

	@Override
	public int buscarRol(String Usu, String contrasenia) {

		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesUsuario.BUSCAR_ROL.getQuery());
			miSentencia.setString(1, Usu);
			miSentencia.setString(2, contrasenia);
			resultado = miSentencia.executeQuery();
			if (resultado.next()) {
				return resultado.getInt("u.id_rol");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return 0;
	}

	@Override
	public Docente buscarDocente(int legajo) {

		Docente docente = null;
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesDocente.GET_DOCENTE.getQuery());
			miSentencia.setInt(1, legajo);
			resultado = miSentencia.executeQuery();

			if (resultado.next()) {
				docente = new Docente();
				docente.setLegajo(resultado.getInt("p.legajo"));
				docente.setDNI(resultado.getInt("p.dni"));
				docente.setNombre(resultado.getString("p.nombre"));
				docente.setApellido(resultado.getString("p.apellido"));
				
				return docente;
			}

		} catch (Exception e) {
			System.out.println("Conexion fallida");
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return null;
	}

	@Override
	public boolean cambiarPass(int legajo, String password) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesUsuario.UPDATE_PASS.getQuery());
			pstmt.setString(1, password);
			pstmt.setInt(2, legajo);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn);
		}
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {

		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		ArrayList<Usuario> lista = new ArrayList<>();
		int legajo;
		String usuario, contrasenia, nombre, apellido;
		try {
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesUsuario.LISTAR_USUARIOS_DOCENTES.getQuery());
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				legajo = resultado.getInt("u.legajo");
				usuario = resultado.getString("u.usuario");
				contrasenia = resultado.getString("u.contraseña");
				nombre = resultado.getString("p.nombre");
				apellido = resultado.getString("p.apellido");
				lista.add(factoryUsuario.getInstance(legajo, usuario, contrasenia, nombre, apellido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, resultado, miSentencia);
		}
		return lista;
	}

	@Override
	public boolean cambiarUserPass(Usuario usuario) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesUsuario.UPDATE_USUARIO.getQuery());
			pstmt.setString(1, usuario.getUsuario());
			pstmt.setString(2, usuario.getContrasenia());
			pstmt.setInt(3, usuario.getLegajo());
			pstmt.executeUpdate();
			return true;
		}

		catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn, pstmt);
		}
	}
}
