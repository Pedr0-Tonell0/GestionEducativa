package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 5664182500892469089L;

	
	public Integer getInteger(ResultSet rs, String strColName) throws SQLException {
        int nValue = rs.getInt(strColName);
        return rs.wasNull() ? null : nValue;
    }
	
	public String mensajeError(String error) {
		error=error.substring(error.indexOf("["));
		return error;
	}
	
	protected void cerrarRecurso(Object... recursos) {
		if (recursos != null) {
			for (Object unRecurso : recursos) {
				if (unRecurso != null) {
					if (unRecurso instanceof PreparedStatement) {
						PreparedStatement pstmt = (PreparedStatement) unRecurso;
						if (pstmt != null) {
							try {
								pstmt.close();
							} catch (Exception e) {
							}
						}
						continue;
					}
					if (unRecurso instanceof ResultSet) {
						ResultSet rs = (ResultSet) unRecurso;
						if (rs != null) {
							try {
								rs.close();
							} catch (Exception e) {
							}
						}
						continue;
					}
					if (unRecurso instanceof CallableStatement) {
						CallableStatement cstmt = (CallableStatement) unRecurso;
						if (cstmt != null) {
							try {
								cstmt.close();
							} catch (Exception e) {
							}
						}
					}
					continue;
				}
			}
		}
	}

}
