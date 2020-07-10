package factory;

import entidad.Tipo_Persona;

public class factoryTipoPersona {

	public static Tipo_Persona getInstance(int iDTipo, String descripcion) {

		Tipo_Persona output = new Tipo_Persona();
		output.setIDTipo(iDTipo);
		output.setDescripcion(descripcion);
		return output;
	}

}
