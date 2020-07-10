package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DocentesDao;
import dao.queries.queriesDocente;
import entidad.Docente;
import entidad.Localidad;
import entidad.Tipo_Persona;
import factory.factoryDocente;
import factory.factoryLocalidad;
import factory.factoryTipoPersona;

public class DocenteDaoImpl extends Dao implements DocentesDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";

	@Override
	public ArrayList<Docente> listar() {

		ArrayList<Docente> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int legajo, dni, telefono, idEstado;
		String nombre, apellido, mail, direccion;
		Date fechaNacimiento;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesDocente.GET_LISTA_DOCENTES.getQuery());
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				legajo = resultado.getInt("a.LEGAJO");
				dni = resultado.getInt("a.DNI");				
				nombre = resultado.getString("a.NOMBRE");
				apellido = resultado.getString("a.APELLIDO");
				mail = resultado.getString("a.MAIL");
				telefono = resultado.getInt("a.TELEFONO");
				direccion = resultado.getString("a.DIRECCION");
				fechaNacimiento = resultado.getDate("a.FECHA_NACIMIENTO");
				idEstado = resultado.getInt("a.ID_ESTADO");
				Tipo_Persona tipo = factoryTipoPersona.getInstance(resultado.getInt("a.ID_TIPO"), resultado.getString("b.Descripcion"));
				Localidad localidad = factoryLocalidad.getInstance(resultado.getInt("a.ID_LOCALIDAD"), resultado.getString("L.DESCRIPCION"));
				lista.add(factoryDocente.getInstance(legajo, dni, nombre, apellido, mail, telefono, direccion, fechaNacimiento, idEstado, tipo, localidad));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return lista;
	}

}
