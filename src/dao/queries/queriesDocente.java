package dao.queries;

public enum queriesDocente {

	GET_LISTA_DOCENTES("SELECT A.LEGAJO, A.DNI, A.NOMBRE, A.APELLIDO, A.MAIL, A.TELEFONO,A.ID_TIPO, B.DESCRIPCION, A.DIRECCION, A.ID_LOCALIDAD, L.DESCRIPCION, A.FECHA_NACIMIENTO, A.ID_ESTADO\n"
						+ "FROM TPINTEGRADOR.PERSONAS AS A\n"
						+ "INNER JOIN TPINTEGRADOR.TIPO_PERSONA AS B ON A.ID_TIPO = B.ID_TIPO\n"
						+ "INNER JOIN LOCALIDAD L ON L.ID_LOCALIDAD = A.ID_LOCALIDAD\n"
						+ "WHERE B.DESCRIPCION = 'PROFESOR'"),
	
	GET_DOCENTE("SELECT P.LEGAJO, P.DNI, P.NOMBRE, P.APELLIDO FROM PERSONAS AS P WHERE P.ID_TIPO = 1 AND P.LEGAJO = ?"),

	;

	private String query;

	private queriesDocente(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
