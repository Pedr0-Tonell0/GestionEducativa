package entidad;

import java.sql.Date;

public class Alumno {

	private int Legajo;
	private int DNI;
	private String nombre;
	private String apellido;
	private String mail;
	private int telefono;
	private Tipo_Persona tipo_Persona;
	private String direccion;
	private Localidad localidad;
	private Date fecha_nacimiento;
	private int ID_Estado;
	private String condicion;
	private Calificaciones calificaciones;

	public int getLegajo() {
		return Legajo;
	}

	public void setLegajo(int legajo) {
		Legajo = legajo;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Tipo_Persona getTipo_Persona() {
		return tipo_Persona;
	}

	public void setTipo_Persona(Tipo_Persona tipo_Persona) {
		this.tipo_Persona = tipo_Persona;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public Date getFecha_Nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_Nacimiento) {
		this.fecha_nacimiento = fecha_Nacimiento;
	}

	public int getID_Estado() {
		return ID_Estado;
	}

	public void setID_Estado(int iD_Estado) {
		ID_Estado = iD_Estado;
	}

	public Calificaciones getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Calificaciones calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	@Override
	public String toString() {
		return "Alumno [Legajo=" + Legajo + ", DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido + ", mail="
				+ mail + ", telefono=" + telefono + ", tipo_Persona=" + tipo_Persona + ", direccion=" + direccion
				+ ", localidad=" + localidad + ", fecha_nacimiento=" + fecha_nacimiento + ", ID_Estado=" + ID_Estado
				+ ", condicion=" + condicion + ", calificaciones=" + calificaciones + "]";
	}

	
}
