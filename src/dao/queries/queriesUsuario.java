package dao.queries;

public enum queriesUsuario {
	
	VALIDAR_USUARIO("SELECT LEGAJO, USUARIO, CONTRASEÑA, ID_ROL "
					+ "FROM USUARIO AS U "
					+ "WHERE U.USUARIO = ? AND U.CONTRASEÑA = ?"),
	
	INSERT_USUARIO ("INSERT INTO USUARIO(LEGAJO, USUARIO, CONTRASEÑA, ID_ROL) VALUES(?, ?, ?, ?)"), 
	
	BUSCAR_ROL("SELECT U.ID_ROL FROM USUARIO AS U WHERE U.USUARIO = ? AND U.CONTRASEÑA = ?"), 
	
	UPDATE_PASS("UPDATE USUARIO AS U SET U.CONTRASEÑA = ? WHERE LEGAJO = ?"), 
	
	LISTAR_USUARIOS_DOCENTES("SELECT U.LEGAJO, U.USUARIO, U.CONTRASEÑA, P.NOMBRE, P.APELLIDO "
					+ "FROM USUARIO AS U "
					+ "INNER JOIN PERSONAS AS P ON P.LEGAJO = U.LEGAJO "
					+ "WHERE U.ID_ROL = 2"), 
	
	UPDATE_USUARIO("UPDATE USUARIO AS U SET U.USUARIO = ?, U.CONTRASEÑA = ? WHERE U.LEGAJO = ?"), 
	
	GET_MAXIMO_LEGAJO("SELECT LEGAJO FROM PERSONAS ORDER BY LEGAJO DESC"),

	;

	private String query;

	private queriesUsuario(String valor) {
		this.setQuery(valor);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
