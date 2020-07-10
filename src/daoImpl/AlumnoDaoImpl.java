package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.queries.queriesAlumno;
import entidad.Alumno;
import entidad.Localidad;
import entidad.Tipo_Persona;
import factory.factoryAlumno;
import factory.factoryLocalidad;
import factory.factoryTipoPersona;

public class AlumnoDaoImpl extends Dao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";

	public ArrayList<Alumno> listar() {

		ArrayList<Alumno> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int legajo, dni, telefono, idEstado;
		String nombre, apellido, email, direccion;
		Date fechaNacimiento;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesAlumno.GET_LISTA_ALUMNOS.getQuery());
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				legajo = resultado.getInt("p.LEGAJO");
				dni = resultado.getInt("p.DNI");
				nombre = resultado.getString("p.NOMBRE");
				apellido = resultado.getString("p.APELLIDO");
				email = resultado.getString("p.MAIL");
				telefono = resultado.getInt("p.TELEFONO");
				Tipo_Persona tipo = factoryTipoPersona.getInstance(resultado.getInt("p.ID_TIPO"), resultado.getString("tp.Descripcion"));
				direccion = resultado.getString("p.DIRECCION");
				Localidad localidad = factoryLocalidad.getInstance(resultado.getInt("p.ID_LOCALIDAD"), resultado.getString("L.DESCRIPCION"));
				fechaNacimiento = resultado.getDate("p.FECHA_NACIMIENTO");
				idEstado = resultado.getInt("p.ID_ESTADO");
				lista.add(factoryAlumno.getInstance(legajo, dni, nombre, apellido, email, telefono, tipo, direccion, localidad, fechaNacimiento, idEstado));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}

		return lista;
	}

	public ArrayList<Alumno> listar_X_Curso(int iD_Curso) {

		ArrayList<Alumno> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int legajo, dni, telefono, idEstado;
		String nombre, apellido, email, direccion;
		Date fechaNacimiento;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesAlumno.GET_LISTA_ALUMNOS_POR_CURSO.getQuery());
			miSentencia.setInt(1, iD_Curso);
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				legajo = resultado.getInt("p.LEGAJO");
				dni = resultado.getInt("p.DNI");
				nombre = resultado.getString("p.NOMBRE");
				apellido = resultado.getString("p.APELLIDO");
				email = resultado.getString("p.MAIL");
				telefono = resultado.getInt("p.TELEFONO");
				Tipo_Persona tipo = factoryTipoPersona.getInstance(resultado.getInt("p.ID_TIPO"), resultado.getString("tp.Descripcion"));
				direccion = resultado.getString("p.DIRECCION");
				Localidad localidad = factoryLocalidad.getInstance(resultado.getInt("p.ID_LOCALIDAD"), resultado.getString("L.DESCRIPCION"));
				fechaNacimiento = resultado.getDate("p.FECHA_NACIMIENTO");
				idEstado = resultado.getInt("p.ID_ESTADO");
				lista.add(factoryAlumno.getInstance(legajo, dni, nombre, apellido, email, telefono, tipo, direccion, localidad, fechaNacimiento, idEstado));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return lista;
	}

	public ArrayList<Alumno> listar_FueraDelCurso(int idCurso) {

		ArrayList<Alumno> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int legajo, dni, telefono, idEstado;
		String nombre, apellido, email, direccion;
		Date fechaNacimiento;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesAlumno.GET_LISTA_FUERA_DEL_CURSO.getQuery());
			miSentencia.setInt(1, idCurso);
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				legajo = resultado.getInt("p.LEGAJO");
				dni = resultado.getInt("p.DNI");
				nombre = resultado.getString("p.NOMBRE");
				apellido = resultado.getString("p.APELLIDO");
				email = resultado.getString("p.MAIL");
				telefono = resultado.getInt("p.TELEFONO");
				Tipo_Persona tipo = factoryTipoPersona.getInstance(resultado.getInt("p.ID_TIPO"), resultado.getString("tp.Descripcion"));
				direccion = resultado.getString("p.DIRECCION");
				Localidad localidad = factoryLocalidad.getInstance(resultado.getInt("p.ID_LOCALIDAD"), resultado.getString("L.DESCRIPCION"));
				fechaNacimiento = resultado.getDate("p.FECHA_NACIMIENTO");
				idEstado = resultado.getInt("p.ID_ESTADO");
				lista.add(factoryAlumno.getInstance(legajo, dni, nombre, apellido, email, telefono, tipo, direccion, localidad, fechaNacimiento, idEstado));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}

		return lista;
	}

}
