package negocio;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import entidad.Curso;

public interface ReporteNegocio {
	public ArrayList<Curso> notas();
	public boolean aprobar(int IdCurso, int Legajo);
	public boolean verificar();
	public ArrayList<Curso> aprobados();
	public boolean setearAprobados(int IdCurso, int aprobados);
	public boolean setearDesaprobados(int IdCurso, int desaprobados);
	public boolean porcentaje();
	public ArrayList<Curso> informe(LocalDate FechaInicio, LocalDate FechaFin) throws SQLException;
}
