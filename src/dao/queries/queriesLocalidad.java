package dao.queries;

public enum queriesLocalidad {

	 GET_LISTA_LOCALIDADES("SELECT ID_LOCALIDAD, DESCRIPCION FROM LOCALIDAD"),

	 GET_LOCALIDAD("SELECT ID_LOCALIDAD, DESCRIPCION FROM LOCALIDAD WHERE DESCRIPCION = ?"),

	 GET_LOCALIDAD_BY_ID("SELECT L.ID_LOCALIDAD, L.DESCRIPCION, P.ID_PROVINCIA,  P.DESCRIPCION \n"
			+ "FROM LOCALIDAD L\n"
			+ "INNER JOIN PROVINCIA P ON L.ID_PROVINCIA = P.ID_PROVINCIA  WHERE ID_LOCALIDAD = ?"),
	 ;
	
	private String query;

	private queriesLocalidad(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
