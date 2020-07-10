package factory;

import entidad.Provincia;

public class factoryProvincia {

	public static Provincia getInstance(int idProvincia, String provincia) {

		Provincia output = new Provincia();
		output.setProvincia(idProvincia);
		output.setDescripcion(provincia);
		return output;
	}
}
