package dao.queries;

public enum queriesAlumno {

	GET_LISTA_ALUMNOS(
			"SELECT P.LEGAJO,P.DNI, P.NOMBRE, P.APELLIDO, P.MAIL, P.TELEFONO, P.ID_TIPO, TP.DESCRIPCION, P.DIRECCION, P.ID_LOCALIDAD, L.DESCRIPCION, P.FECHA_NACIMIENTO, P.ID_ESTADO\n"
					+ "FROM PERSONAS AS P \n" + "INNER JOIN TIPO_PERSONA AS TP ON P.ID_TIPO = TP.ID_TIPO\n"
					+ "INNER JOIN ESTADO AS E ON E.ID_ESTADO = P.ID_ESTADO\n"
					+ "INNER JOIN LOCALIDAD L ON L.ID_LOCALIDAD = P.ID_LOCALIDAD\n"
					+ "WHERE TP.DESCRIPCION = 'ALUMNO' AND E.DESCRIPCION = 'REGULAR'"),

	GET_LISTA_ALUMNOS_POR_CURSO(
			"SELECT P.LEGAJO,P.DNI, P.NOMBRE, P.APELLIDO, P.MAIL, P.TELEFONO, P.ID_TIPO, TP.DESCRIPCION, P.DIRECCION, P.ID_LOCALIDAD, L.DESCRIPCION, P.FECHA_NACIMIENTO, P.ID_ESTADO\n"
					+ "FROM PERSONAS AS P \n" + "INNER JOIN TIPO_PERSONA AS TP ON P.ID_TIPO = TP.ID_TIPO\n"
					+ "INNER JOIN ESTADO AS E ON E.ID_ESTADO = P.ID_ESTADO\n"
					+ "INNER JOIN LOCALIDAD L ON L.ID_LOCALIDAD = P.ID_LOCALIDAD\n"
					+ "INNER JOIN CURSOSXALUMNOS AS CA ON CA.ID_ALUMNO = P.LEGAJO \n"
					+ "WHERE TP.DESCRIPCION = 'ALUMNO' AND E.DESCRIPCION = 'REGULAR' AND CA.BAJA != 1 \n" + "AND CA.ID_CURSO = ?"),

	GET_LISTA_FUERA_DEL_CURSO(
			"SELECT P.LEGAJO, P.DNI, P.NOMBRE, P.APELLIDO, P.MAIL, P.TELEFONO, P.ID_TIPO, TP.DESCRIPCION, P.DIRECCION, P.ID_LOCALIDAD, L.DESCRIPCION, P.FECHA_NACIMIENTO, P.ID_ESTADO\n"
					+ "FROM PERSONAS AS P \n" 
					+ "INNER JOIN TIPO_PERSONA AS TP ON P.ID_TIPO = TP.ID_TIPO\n"
					+ "INNER JOIN ESTADO AS E ON E.ID_ESTADO = P.ID_ESTADO\n"
					+ "INNER JOIN LOCALIDAD L ON L.ID_LOCALIDAD = P.ID_LOCALIDAD  \n"
					+ "WHERE TP.DESCRIPCION = 'ALUMNO' AND E.DESCRIPCION = 'REGULAR'\n"
					+ "AND P.LEGAJO NOT IN (SELECT DISTINCT ID_ALUMNO \n" 
					+ "						FROM CURSOSXALUMNOS \n"
					+ "						WHERE ID_CURSO = ? AND BAJA <> 1)"),
	
	GET_ALUMNOS_POR_CURSO("SELECT C.ID_ALUMNO,P.NOMBRE,P.APELLIDO,T.ID_TIPO,T.DESCRIPCION,C.PARCIAL1,C.PARCIAL2,C.RECUPERATORIO1,C.RECUPERATORIO2 FROM CURSOSXALUMNOS AS C INNER JOIN PERSONAS AS P ON P.LEGAJO = C.ID_ALUMNO INNER JOIN TIPO_ALUMNO AS T ON T.ID_TIPO = C.ESTADO WHERE c.ID_CURSO = ?"), 
	
	GET_NOTAS("SELECT C.ID_ALUMNO, P.NOMBRE, P.APELLIDO, P.MAIL, P.TELEFONO, P.DNI "
					+ "FROM CURSOSXALUMNOS AS C "
					+ "INNER JOIN PERSONAS AS P ON P.LEGAJO = C.ID_ALUMNO "
					+ "WHERE C.ID_CURSO = ? "), 
	
	GET_ESTADOS("SELECT T.ID_TIPO, T.DESCRIPCION FROM TIPO_ALUMNO AS T"), 
	
	;

	private String query;

	private queriesAlumno(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}