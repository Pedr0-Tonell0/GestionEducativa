package entidad;

public class Tipo_Persona {

	private int IDTipo;
	private String descripcion;

	public int getIDTipo() {
		return IDTipo;
	}
	public void setIDTipo(int iDTipo) {
		IDTipo = iDTipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Tipo_Persona [IDTipo=" + IDTipo + ", Descripcion=" + descripcion + "]";
	}
	
}
