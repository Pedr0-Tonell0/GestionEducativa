package dao.queries;

public enum queriesProvincia {

	 GET_LISTA_PROVINCIAS("SELECT ID_PROVINCIA, DESCRIPCION FROM PROVINCIA"),

	 GET_PROVINCIA("SELECT ID_PROVINCIA, DESCRIPCION FROM PROVINCIA WHERE DESCRIPCION = ?"),

	 ;
	
	private String query;

	private queriesProvincia(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
