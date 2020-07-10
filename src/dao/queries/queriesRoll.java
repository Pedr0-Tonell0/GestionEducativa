package dao.queries;

public enum queriesRoll {

	 GET_LISTA_ROLL("SELECT ID_TIPO, DESCRIPCION FROM TIPO_PERSONA"),

	 GET_ROLL("SELECT ID_TIPO, DESCRIPCION FROM TIPO_PERSONA WHERE DESCRIPCION = ?"),

	 GET_ROLL_BY_ID("SELECT ID_TIPO, DESCRIPCION FROM TIPO_PERSONA WHERE ID_TIPO = ?"),
	 ;
	
	private String query;

	private queriesRoll(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
