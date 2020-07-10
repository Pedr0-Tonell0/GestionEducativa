package negocioImpl;

import java.util.ArrayList;

import dao.LoginDao;
import dao.MateriasDao;
import daoImpl.LoginDaoImpl;
import daoImpl.MateriaDaoImpl;
import entidad.Materia;
import negocio.MateriasNegocio;

public class MateriaNegocioImpl implements MateriasNegocio {

	MateriaDaoImpl mdao = new MateriaDaoImpl() ;
	
	@Override
	public ArrayList<Materia>listar() {
		return mdao.listar();
	}
}
