package dao.queries;

public enum queriesMateria {

	GET_LISTA_MATERIAS("SELECT ID_MATERIA, DESCRIPCION FROM MATERIA"),
	
	;

	private String query;

	private queriesMateria(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
