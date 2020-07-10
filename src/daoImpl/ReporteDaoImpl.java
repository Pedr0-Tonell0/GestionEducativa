package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.ReporteDao;
import dao.queries.queriesCurso;
import entidad.Alumno;
import entidad.Curso;
import entidad.Docente;
import entidad.Materia;
import factory.factoryCurso;

public class ReporteDaoImpl extends Dao implements ReporteDao {

	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";
	

	@Override
	public ArrayList<Curso> notas() {

		ArrayList<Curso> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int idCurso, parcial1, parcial2, recuperatorio1, recuperatorio2, estado;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesCurso.GET_NOTAS.getQuery());
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				idCurso = resultado.getInt("c.ID_CURSO");
				parcial1 = resultado.getInt("c.PARCIAL1");
				parcial2 = resultado.getInt("c.PARCIAL2");
				recuperatorio1 = resultado.getInt("c.RECUPERATORIO1");
				recuperatorio2 = resultado.getInt("c.RECUPERATORIO2");
				estado = resultado.getInt("c.ESTADO");
				Alumno alumno = new Alumno();
				alumno.setLegajo(resultado.getInt("p.LEGAJO"));
				lista.add(factoryCurso.getInstance(idCurso, parcial1, parcial2, recuperatorio1, recuperatorio2, estado, alumno));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(conn, miSentencia, resultado);
		}
		
		return lista;
	}

	@Override
	public boolean aprobar(int idCurso, int legajo) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.APROBAR_ALUMNO.getQuery());
			pstmt.setInt(1, idCurso);
			pstmt.setInt(2, legajo);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn, pstmt);
		}
	}

	@Override
	public boolean verificar() {
		
		ArrayList<Curso> listaCursos = null;
		listaCursos = notas();
		if(listaCursos!=null)
		{
			for(Curso curso : listaCursos) 
			{
				if(curso.getParcial1()>=6 && curso.getParcial2()>=6 && curso.getEstado()==1)
				{
					aprobar(curso.getIdCurso(), curso.getAlumno().getLegajo());
				}
				
				if(curso.getParcial1()<6 && curso.getParcial2()>=6) 
				{
					if(curso.getRecuperatorio1()>=6 && curso.getEstado()==1)
					{
						aprobar(curso.getIdCurso(), curso.getAlumno().getLegajo());
					}
				}
				
				if (curso.getParcial1()>=6 && curso.getParcial2()<6)
					
				{
					if(curso.getRecuperatorio2()>=6  && curso.getEstado()==1)
					{
						aprobar(curso.getIdCurso(), curso.getAlumno().getLegajo());
					}
				}
				
				if(curso.getParcial1()<6 && curso.getParcial2()<6)
				{
					if(curso.getRecuperatorio1()>=6 && curso.getRecuperatorio2()>=6  && curso.getEstado()==1)
					{
						aprobar(curso.getIdCurso(), curso.getAlumno().getLegajo());

					}
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Curso> aprobados() {

		ArrayList<Curso> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesCurso.GET_PORCENTAJE_APROBADOS.getQuery());
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				Curso cursos = new Curso();
				cursos.setIdCurso(resultado.getInt("c.ID_CURSO"));
				cursos.setAprobados(resultado.getInt("aprobados"));
				lista.add(cursos);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(conn, miSentencia, resultado);
		}

		return lista;
	}

	@Override
	public boolean setearAprobados(int IdCurso, int aprobados) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.UPDATE_APROBADOS.getQuery());
			pstmt.setInt(1, aprobados);
			pstmt.setInt(2, IdCurso);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn);
		}
	}

	@Override
	public boolean setearDesaprobados(int idCurso, int desaprobados) {
		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.UPDATE_DESAPROBADOS.getQuery());
			pstmt.setInt(1, desaprobados);
			pstmt.setInt(2, idCurso);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn);
		}
	}

	@Override
	public boolean porcentaje() {
		ArrayList<Curso> listaAprobados = null;
		int desaprobados = 0;
		listaAprobados = aprobados();
		if (listaAprobados != null ) {
			
				for (Curso curso : listaAprobados)

				{
						desaprobados = 100 - curso.getAprobados();
						setearDesaprobados(curso.getIdCurso(), desaprobados);
						setearAprobados(curso.getIdCurso(), curso.getAprobados());
				}
				return true;
			}
		return false;
	}

	@Override
	public ArrayList<Curso> informe(LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {

		ArrayList<Curso> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesCurso.SP_REPORTE.getQuery());
			miSentencia.setString(1, fechaInicio.toString());
			miSentencia.setString(2, fechaFin.toString());
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				Curso cursos = new Curso();
				cursos.setCantidadAlumnos(resultado.getInt("cantidad"));
				cursos.setAprobados(resultado.getInt("c.aprobados"));
				cursos.setDesaprobados(resultado.getInt("c.desaprobados"));
				cursos.setAnio(resultado.getInt("c.anio"));
				cursos.setCuatrimestre(resultado.getInt("c.cuatrimestre"));
				Docente docente = new Docente();
				docente.setApellido(resultado.getString("p.apellido"));
				cursos.setDocente(docente);
				Materia materia = new Materia();
				materia.setNombre(resultado.getString("m.descripcion"));
				cursos.setMateria(materia);
				lista.add(cursos);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			cerrarRecurso(conn, miSentencia, resultado);
		}
		return lista;
	}

}
