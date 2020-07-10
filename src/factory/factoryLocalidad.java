package factory;

import entidad.Localidad;
import entidad.Provincia;

public class factoryLocalidad {

	public static Localidad getInstance(int idLocalidad, String localidad, int idProvincia, String provincia) {

		Localidad output = new Localidad();
		output.setLocalidad(idLocalidad);
		output.setDescripcion(localidad);
		Provincia prov = new Provincia();
		prov.setProvincia(idProvincia);
		prov.setDescripcion(provincia);
		output.setProvincia(prov);
		return output;
	}

	public static Localidad getInstance(int idLocalidad, String localidad) {

		Localidad output = new Localidad();
		output.setLocalidad(idLocalidad);
		output.setDescripcion(localidad);
		return output;
	}
}
