package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dao.PersonasDao;
import dao.queries.queriesLocalidad;
import dao.queries.queriesPersona;
import dao.queries.queriesProvincia;
import dao.queries.queriesRoll;
import entidad.Alumno;
import entidad.Datos;
import entidad.Localidad;
import entidad.Persona;
import entidad.Provincia;
import entidad.Roll;
import entidad.Usuario;
import factory.factoryLocalidad;
import factory.factoryPersona;
import factory.factoryProvincia;
import factory.factoryRoll;

public class PersonaDaoImpl extends Dao implements PersonasDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";

	@Override
	public boolean insertarRegistroPersona(Persona persona) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.PR_INSERT_PERSONA.getQuery());
			pstmt.setInt(1, persona.getDni());
			pstmt.setString(2, persona.getNombre());
			pstmt.setString(3, persona.getApellido());
			pstmt.setString(4, persona.getEmail());
			pstmt.setInt(5, persona.getTelefono());
			pstmt.setInt(6, persona.getRoll().getIdRoll());
			pstmt.setString(7, persona.getDireccion());
			pstmt.setInt(8, persona.getLocalidad().getLocalidad());
			pstmt.setString(9, persona.getFechaNacimiento().toString());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, con);
		}
		return true;
	}

	public ArrayList<Provincia> listarProvincias() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Provincia> listaProvincia = new ArrayList<Provincia>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesProvincia.GET_LISTA_PROVINCIAS.getQuery());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				listaProvincia
						.add(factoryProvincia.getInstance(rs.getInt("ID_PROVINCIA"), rs.getString("DESCRIPCION")));
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return listaProvincia;
	}

	public ArrayList<Roll> listarRoll() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Roll> listaRoll = new ArrayList<Roll>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesRoll.GET_LISTA_ROLL.getQuery());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				listaRoll.add(factoryRoll.getInstance(rs.getInt("ID_TIPO"), rs.getString("DESCRIPCION")));
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return listaRoll;
	}

	public ArrayList<Persona> listarPersonas() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.GET_LISTA_PERSONAS.getQuery());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				listaPersonas.add(factoryPersona.instance(rs.getString("NOMBRE"), rs.getString("APELLIDO"),
						rs.getString("MAIL"), rs.getInt("DNI"), rs.getInt("LEGAJO"), rs.getInt("TELEFONO")));
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return listaPersonas;
	}

	public void eliminarPersona(int legajo) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.ELIMINAR_PERSONA.getQuery());
			pstmt.setInt(1, legajo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, con);
		}
	}

	public ArrayList<Localidad> listarLocalidades() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Localidad> listaLocalidades = new ArrayList<Localidad>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesLocalidad.GET_LISTA_LOCALIDADES.getQuery());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				listaLocalidades
						.add(factoryLocalidad.getInstance(rs.getInt("ID_LOCALIDAD"), rs.getString("DESCRIPCION")));
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return listaLocalidades;
	}

	public boolean existeRegistroPorDni(int dni) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.GET_REGISTRO_DNI_EXISTENTE.getQuery());
			pstmt.setInt(1, dni);
			rs = pstmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
	}

	public void existeRegistroPorEmail(String email) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.GET_REGISTRO_EMAIL_EXISTENTE.getQuery());
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				throw new Exception("El email ingresado ya se encuentra en el sistema");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
	}

	public Roll getRoll(String roll) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesRoll.GET_ROLL.getQuery());
			pstmt.setString(1, roll);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return factoryRoll.getInstance(rs.getInt(1), rs.getString(2));
			} else {
				throw new Exception("Debe seleccionar un roll");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
	}

	public Provincia getProvincia(String provincia) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesProvincia.GET_PROVINCIA.getQuery());
			pstmt.setString(1, provincia);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return factoryProvincia.getInstance(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return null;
	}

	public Localidad getLocalidad(String localidad) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesLocalidad.GET_LOCALIDAD.getQuery());
			pstmt.setString(1, localidad);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return factoryLocalidad.getInstance(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return null;
	}

	public Persona getPersona(int leg) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.GET_PERSONA.getQuery());
			pstmt.setInt(1, leg);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int dni = rs.getInt("DNI");
				String nombre = rs.getString("NOMBRE");
				String apellido = rs.getString("APELLIDO");
				String email = rs.getString("MAIL");
				int telefono = rs.getInt("TELEFONO");
				Roll roll = getRollById(rs.getInt("ID_TIPO"));
				String direccion = rs.getString("DIRECCION");
				Localidad localidad = getLocalidadById(rs.getInt("ID_LOCALIDAD"));
				LocalDate fechaNacimiento = getFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
				return factoryPersona.getInstance(roll, dni, nombre, apellido, fechaNacimiento, localidad, direccion,
						email, telefono);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return null;
	}

	private LocalDate getFechaNacimiento(String fechaNacimiento) throws Exception {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			return LocalDate.parse(fechaNacimiento, formatter);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	private Localidad getLocalidadById(int idLocalidad) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesLocalidad.GET_LOCALIDAD_BY_ID.getQuery());
			pstmt.setInt(1, idLocalidad);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return factoryLocalidad.getInstance(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return null;
	}

	private Roll getRollById(int idRoll) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesRoll.GET_ROLL_BY_ID.getQuery());
			pstmt.setInt(1, idRoll);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return factoryRoll.getInstance(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return null;
	}

	public void actualizarRegistroPersona(Persona persona) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.ACTUALIZAR_PERSONA.getQuery());
			pstmt.setString(1, persona.getNombre());
			pstmt.setString(2, persona.getApellido());
			pstmt.setString(3, persona.getEmail());
			pstmt.setInt(4, persona.getTelefono());
			pstmt.setInt(5, persona.getRoll().getIdRoll());
			pstmt.setString(6, persona.getDireccion());
			if (persona.getLocalidad() != null) {
				pstmt.setInt(7, persona.getLocalidad().getLocalidad());
			}else {
				pstmt.setNull(7, Types.INTEGER);
			}
			pstmt.setString(8, persona.getFechaNacimiento().toString());
			pstmt.setInt(9, persona.getDni());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw new Exception("Error al actualizar el registro");
		} finally {
			cerrarRecurso(pstmt, con);
		}
	}

	@Override
	public ArrayList<Datos> listarDatos() throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Datos> lista = new ArrayList<Datos>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = con.prepareStatement(queriesPersona.VM_DATOS_PROFESORES.getQuery());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Datos datos = new Datos();
				datos.setLegajo(rs.getInt("LEGAJO"));
				datos.setDni(rs.getInt("DNI"));
				datos.setNombre(rs.getString("Nombre"));
				datos.setApellido(rs.getString("Apellido"));
				datos.setEmail(rs.getString("MAIL"));
				datos.setTelefono(rs.getInt("TELEFONO"));
				datos.setDireccion(rs.getString("DIRECCION"));
				datos.setEdad(rs.getInt("EDAD"));
				datos.setCantidadCursos(rs.getInt("Cursos"));
				Usuario usuario = new Usuario();
				usuario.setUsuario(rs.getString("USUARIO"));
				usuario.setContrasenia(rs.getString("CONTRASEÑA"));
				datos.setUsuario(usuario);
				Localidad localidad = new Localidad();
				localidad.setDescripcion(rs.getString("LOCALIDAD"));
				datos.setLocalidad(localidad);
				Provincia provincia = new Provincia();
				provincia.setDescripcion(rs.getString("PROVINCIA"));
				datos.setProvincia(provincia);
				lista.add(datos);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			cerrarRecurso(pstmt, rs, con);
		}
		return lista;
	}
}
