package entidad;

public class Localidad {
	
	private int ID_Localidad;
	private Provincia provincia;
	private String descripcion;

	public int getLocalidad() {
		return ID_Localidad;
	}
	public void setLocalidad(int iD_Localidad) {
		ID_Localidad = iD_Localidad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
