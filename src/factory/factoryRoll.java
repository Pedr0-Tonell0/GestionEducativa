package factory;

import entidad.Roll;

public class factoryRoll {

	public static Roll getInstance(int idRoll, String roll) {

		Roll output = new Roll();
		output.setIdRoll(idRoll);
		output.setRoll(roll);
		return output;
	}
}
