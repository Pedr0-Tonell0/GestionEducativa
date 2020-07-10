package entidad;

public class Materia {
	private int IdMateria;
	private String nombre;

	public Materia() {}

	public Materia(int IdMateria, String Nombre) {
		this.IdMateria = IdMateria;
		this.nombre = Nombre;
	}

	public int getIdMateria() {
		return IdMateria;
	}
	public void setIdMateria(int idMateria) {
		IdMateria = idMateria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Materias [IdMateria=" + IdMateria + ", Nombre=" + nombre + "]";
	}
	
}
