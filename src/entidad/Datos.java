package entidad;

public class Datos {
	private String nombre;
	private String apellido;
	private String email;
	private int dni;
	private int legajo;
	private int telefono;
	private int edad;
	private int cantidadCursos;
	private String direccion;
	private Usuario usuario;
	private Localidad localidad;
	private Provincia provincia;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCantidadCursos() {
		return cantidadCursos;
	}
	public void setCantidadCursos(int cantidadCursos) {
		this.cantidadCursos = cantidadCursos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	@Override
	public String toString() {
		return "Datos [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", dni=" + dni + ", legajo="
				+ legajo + ", telefono=" + telefono + ", edad=" + edad + ", cantidadCursos=" + cantidadCursos
				+ ", direccion=" + direccion + ", usuario=" + usuario + ", localidad=" + localidad + ", provincia="
				+ provincia + "]";
	}
	

}
