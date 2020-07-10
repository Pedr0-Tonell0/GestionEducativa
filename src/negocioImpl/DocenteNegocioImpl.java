package negocioImpl;

import java.util.ArrayList;

import daoImpl.DocenteDaoImpl;
import entidad.Docente;

public class DocenteNegocioImpl {

	DocenteDaoImpl ddao = new DocenteDaoImpl();

	public ArrayList<Docente> listar() {
		return ddao.listar();
	}
}
