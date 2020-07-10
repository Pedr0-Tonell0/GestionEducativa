package entidad;

public class Calificaciones {

	private int parcial1;
	private int parcial2;
	private int recuperatorio1;
	private int recuperatorio2;
	private int estado;
	private int legajo;

	public int getParcial1() {
		return parcial1;
	}

	public void setParcial1(int parcial1) {
		this.parcial1 = parcial1;
	}

	public int getParcial2() {
		return parcial2;
	}

	public void setParcial2(int parcial2) {
		this.parcial2 = parcial2;
	}

	public int getRecuperatorio1() {
		return recuperatorio1;
	}

	public void setRecuperatorio1(int recuperatorio1) {
		this.recuperatorio1 = recuperatorio1;
	}

	public int getRecuperatorio2() {
		return recuperatorio2;
	}

	public void setRecuperatorio2(int recuperatorio2) {
		this.recuperatorio2 = recuperatorio2;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return "Calificaciones [Parcial1=" + parcial1 + ", Parcial2=" + parcial2 + ", Recuperatorio1=" + recuperatorio1
				+ ", Recuperatorio2=" + recuperatorio2 + ", Estado=" + estado + ", Legajo=" + legajo + "]";
	}
}
