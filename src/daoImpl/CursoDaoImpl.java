package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.CursosDao;
import dao.queries.queriesAlumno;
import dao.queries.queriesCurso;
import entidad.Alumno;
import entidad.Calificaciones;
import entidad.Curso;
import entidad.Docente;
import entidad.Materia;
import factory.factoryAlumno;
import factory.factoryCurso;
import factory.factoryDocente;
import factory.factoryMateria;

public class CursoDaoImpl extends Dao implements CursosDao {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "password";
	private String dbName = "tpintegrador";

	@Override
	public boolean agregar(Curso curso) {

		LocalDate Fecha_Inicio;
		LocalDate Fecha_Fin;
		Connection cn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			if (curso.getCuatrimestre() == 1) {
				Fecha_Inicio = LocalDate.parse(String.valueOf(curso.getAnio()) + "-01-01");
				Fecha_Fin = LocalDate.parse(String.valueOf(curso.getAnio()) + "-06-30");
			} else {
				Fecha_Inicio = LocalDate.parse(String.valueOf(curso.getAnio()) + "-07-01");
				Fecha_Fin = LocalDate.parse(String.valueOf(curso.getAnio()) + "-12-31");
			}
			pstmt = cn.prepareStatement(queriesCurso.INSERT_INTO_CURSOS.getQuery());
			pstmt.setInt(1, curso.getMateria().getIdMateria());
			pstmt.setInt(2, curso.getAnio());
			pstmt.setInt(3, curso.getDocente().getLegajo());
			pstmt.setInt(4, curso.getCuatrimestre());
			pstmt.setString(5, Fecha_Inicio.toString());
			pstmt.setString(6, Fecha_Fin.toString());
			pstmt.setInt(7, 0);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn, pstmt, rs);
		}
	}

	public boolean inscribirAlumno(int idCurso, int legajoInsertar) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.INSERT_INTO_CURSOS_POR_ALUMNOS.getQuery());
			pstmt.setInt(1, idCurso);
			pstmt.setInt(2, legajoInsertar);
			pstmt.setInt(3, 1);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn, pstmt, rs);
		}
	}

	public int buscoUltinoCursoInsertado() {

		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesCurso.GET_ULTIMO_CURSO.getQuery());
			resultado = miSentencia.executeQuery();
			if (resultado.next()) {
				return resultado.getInt("ID_CURSO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return 0;
	}

	public ArrayList<Curso> listar() {

		ArrayList<Curso> lista = new ArrayList<>();
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int idCurso, anio, cuatrimestre, aprobado, desaprobado;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesCurso.LISTAR_CURSOS.getQuery());
			resultado = miSentencia.executeQuery();

			while (resultado.next()) {
				idCurso = resultado.getInt("C.ID_CURSO");
				anio = resultado.getInt("C.ANIO");
				cuatrimestre = resultado.getInt("CUATRIMESTRE");
				aprobado = resultado.getInt("APROBADOS");
				desaprobado = resultado.getInt("DESAPROBADOS");
				Materia materia = factoryMateria.getInstance(resultado.getInt("C.ID_MATERIA"),
						resultado.getString("M.DESCRIPCION"));
				Docente docente = factoryDocente.getInstance(resultado.getInt("C.ID_DOCENTE"),
						resultado.getString("P.NOMBRE"), resultado.getString("P.APELLIDO"));
				lista.add(factoryCurso.getInstance(idCurso, anio, cuatrimestre, aprobado, desaprobado, materia, docente));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return lista;
	}

	public boolean borrarCurso(int ID_Curso) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.BORRAR_CURSO.getQuery());
			pstmt.setInt(1, ID_Curso);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn, pstmt);
		}
	}

	public boolean borrarAlumnosCursos(int ID_Curso) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.BORRAR_ALUMNOS_DE_CURSO.getQuery());
			pstmt.setInt(1, ID_Curso);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn);
		}
	}

	@Override
	public boolean actualizar(Curso curso) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.UPDATE_CURSO.getQuery());
			pstmt.setInt(1, curso.getMateria().getIdMateria());
			pstmt.setInt(2, curso.getCuatrimestre());
			pstmt.setInt(3, curso.getAnio());
			pstmt.setInt(4, curso.getDocente().getLegajo());
			pstmt.setInt(5, curso.getIdCurso());
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn);
		}
	}

	public Curso buscar(int cursoSeleccionado) {

		Connection con = null;
		Curso curso = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int idCurso, anio, cuatrimestre, aprobado, desaprobado;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesCurso.LISTAR_CURSOS_POR_ID.getQuery());
			miSentencia.setInt(1, cursoSeleccionado);
			resultado = miSentencia.executeQuery();

			if (resultado.next()) {
				idCurso = resultado.getInt("C.ID_CURSO");
				anio = resultado.getInt("C.ANIO");
				cuatrimestre = resultado.getInt("CUATRIMESTRE");
				aprobado = resultado.getInt("APROBADOS");
				desaprobado = resultado.getInt("DESAPROBADOS");
				Materia materia = factoryMateria.getInstance(resultado.getInt("C.ID_MATERIA"),
						resultado.getString("M.DESCRIPCION"));
				Docente docente = factoryDocente.getInstance(resultado.getInt("C.ID_DOCENTE"),
						resultado.getString("P.NOMBRE"), resultado.getString("P.APELLIDO"));
				return factoryCurso.getInstance(idCurso, anio, cuatrimestre, aprobado, desaprobado, materia, docente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return curso;
	}

	@Override
	public ArrayList<Curso> cursosProfesor(int legajo) {

		ArrayList<Curso> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int idCurso, anio, cuatrimestre, aprobado, desaprobado;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesCurso.GET_CURSO_POR_PROFESOR.getQuery());
			miSentencia.setInt(1, legajo);
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(resultado.getInt("c.id_curso"));
				curso.setAnio(resultado.getInt("c.anio"));
				curso.setCuatrimestre(resultado.getInt("c.cuatrimestre"));
				Materia materia = new Materia();
				materia.setNombre(resultado.getString("m.descripcion"));
				curso.setMateria(materia);
				Docente docente = new Docente();
				docente.setApellido(resultado.getString("p.apellido"));
				curso.setDocente(docente);
				
				lista.add(curso);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(conn, miSentencia, resultado);
		}
		return lista;
	}

	@Override
	public ArrayList<Alumno> buscarAlumnos(int ID_CURSO) {

		ArrayList<Alumno> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int legajo, telefono, dni;
		String apellido, nombre, mail;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesAlumno.GET_ALUMNOS_POR_CURSO.getQuery());
			miSentencia.setInt(1, ID_CURSO);
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				Alumno alumno = new Alumno();
				alumno.setLegajo(resultado.getInt("c.id_alumno"));
				alumno.setNombre(resultado.getString("p.nombre"));
				alumno.setApellido(resultado.getString("p.apellido"));
				alumno.setID_Estado(resultado.getInt("t.id_tipo"));
				alumno.setCondicion(resultado.getString("t.descripcion"));
				Calificaciones calificaciones = new Calificaciones ();
				calificaciones.setParcial1(resultado.getInt("c.parcial1"));
				calificaciones.setParcial2(resultado.getInt("c.parcial2"));
				calificaciones.setRecuperatorio1(resultado.getInt("c.recuperatorio1"));
				calificaciones.setRecuperatorio2(resultado.getInt("c.recuperatorio2"));
				alumno.setCalificaciones(calificaciones);
				lista.add(alumno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(conn, miSentencia, resultado);
		}
		return lista;
	}

	@Override
	public ArrayList<Curso> buscarNotas(int ID_CURSO) {

		ArrayList<Curso> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		int legajo, telefono, dni;
		String apellido, nombre, mail;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesAlumno.GET_NOTAS.getQuery());
			miSentencia.setInt(1, ID_CURSO);
			
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				legajo = resultado.getInt("C.ID_ALUMNO");
				nombre = resultado.getString("p.nombre");
				apellido = resultado.getString("p.apellido");
				mail = resultado.getString("p.mail");
				telefono = resultado.getInt("p.telefono");
				dni = resultado.getInt("p.dni");
				Alumno alumno = factoryAlumno.getInstance(legajo, nombre, apellido, mail, telefono, dni);
				Curso cursos = new Curso();
				cursos.setAlumno(alumno);
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
	public boolean cargarNotas(int IdCurso, int parcial1, int parcial2, int recuperatorio1, int recuperatorio2,
			int legajo, int estado) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.UPDATE_NOTAS.getQuery());
			pstmt.setInt(1, parcial1);
			pstmt.setInt(2, parcial2);
			pstmt.setInt(3, recuperatorio1);
			pstmt.setInt(4, recuperatorio2);
			pstmt.setInt(5, estado);
			pstmt.setInt(6, IdCurso);
			pstmt.setInt(7, legajo);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn);
		}
	}

	public int existe_Registro(int cursoSeleccionado, int alumno) {

		int estado = -1;
		Connection con = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = con.prepareStatement(queriesCurso.EXISTE_REGISTRO.getQuery());
			miSentencia.setInt(1, alumno);
			miSentencia.setInt(2, cursoSeleccionado);
			resultado = miSentencia.executeQuery();
			if (resultado.next()) {
				return resultado.getInt("C.BAJA");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(con, miSentencia, resultado);
		}
		return estado;
	}

	public boolean volver_A_Inscribir(int cursoSeleccionado, int alumno) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.VOLVER_A_INSCRIBIR.getQuery());
			pstmt.setInt(1, cursoSeleccionado);
			pstmt.setInt(2, alumno);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			cerrarRecurso(cn, pstmt);
		}
	}

	public boolean borrarAlumnoCurso(int curso, int alumnoDarBaja) {

		Connection cn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(host + dbName, user, pass);
			pstmt = cn.prepareStatement(queriesCurso.BORRAR_ALUMNO_DE_CURSO.getQuery());
			pstmt.setInt(1, curso);
			pstmt.setInt(2, alumnoDarBaja);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(cn, pstmt);
		}
		return false;
	}

	@Override
	public ArrayList<Alumno> buscarEstados() {
		ArrayList<Alumno> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement miSentencia = null;
		ResultSet resultado = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host + dbName, user, pass);
			miSentencia = conn.prepareStatement(queriesAlumno.GET_ESTADOS.getQuery());
			resultado = miSentencia.executeQuery();
			while (resultado.next()) {
				Alumno alumno = new Alumno();
				alumno.setID_Estado(resultado.getInt("t.ID_TIPO"));
				alumno.setCondicion(resultado.getString("t.descripcion"));
				lista.add(alumno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cerrarRecurso(conn, miSentencia, resultado);
		}
		return lista;
	}

}
