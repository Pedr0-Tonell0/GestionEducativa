package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.MateriasDao;
import dao.queries.queriesMateria;
import entidad.Materia;

public class MateriaDaoImpl extends Dao implements MateriasDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";

	@Override
	public ArrayList<Materia> listar() {

		ArrayList<Materia> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesMateria.GET_LISTA_MATERIAS.getQuery());
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				Materia materia = new Materia();
				materia.setIdMateria(resultado.getInt("ID_MATERIA"));
				materia.setNombre(resultado.getString("DESCRIPCION"));
				lista.add(materia);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return lista;
	}

}
