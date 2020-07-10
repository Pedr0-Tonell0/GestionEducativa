package negocioImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import dao.ReporteDao;
import daoImpl.ReporteDaoImpl;
import entidad.Curso;
import negocio.ReporteNegocio;

public class ReporteNegocioImpl implements ReporteNegocio{
	ReporteDao rdao = new ReporteDaoImpl();
	
	@Override
	public ArrayList<Curso> notas() {
		return rdao.notas();
	}
	@Override
	public boolean aprobar(int IdCurso, int Legajo) {
		return rdao.aprobar(IdCurso, Legajo);
	}
	@Override
	public boolean verificar() {
		return rdao.verificar();
		
	}
	
	@Override
	public ArrayList<Curso> aprobados() {
		return rdao.aprobados();
	}
	@Override
	public boolean setearAprobados(int IdCurso, int aprobados) {
		return rdao.setearAprobados(IdCurso, aprobados);
	}
	@Override
	public boolean setearDesaprobados(int IdCurso, int desaprobados) {
		return rdao.setearDesaprobados(IdCurso, desaprobados);
	}
	@Override
	public boolean porcentaje() {
		return rdao.porcentaje();
	}
	
	@Override
	public ArrayList<Curso> informe(LocalDate FechaInicio, LocalDate FechaFin) throws SQLException {
		return rdao.informe(FechaInicio, FechaFin);
	}
}
