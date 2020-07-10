package entidad;

public class Usuario {

	private String Contrasenia;
	private String Usuario;
	private int Rol;
	private int Legajo;
	private String Nombre;
	private String Apellido;

	public Usuario() {
	}

	public Usuario(String Pass, String User, int rol, int legajo, String nombre, String apellido) {
		Usuario = User;
		Contrasenia = Pass;
		Rol = rol;
		Legajo = legajo;
		Nombre = nombre;
		Apellido = apellido;

	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contraseña) {
		Contrasenia = contraseña;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public int getRol() {
		return Rol;
	}

	public void setRol(int rol) {
		Rol = rol;
	}

	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	@Override
	public String toString() {
		return "Usuario [Contraseña=" + Contrasenia + ", Usuario=" + Usuario + ", Rol=" + Rol + ", Legajo=" + Legajo
				+ ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
	}

}
