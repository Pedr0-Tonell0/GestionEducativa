package factory;

import entidad.Materia;

public class factoryMateria {

	public static Materia getInstance(int idMateria, String materia) {

		Materia output = new Materia();
		output.setIdMateria(idMateria);
		output.setNombre(materia);
		return output;
	}

}
