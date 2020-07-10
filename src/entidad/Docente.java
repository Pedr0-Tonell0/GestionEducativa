package entidad;

import java.sql.Date;

public class Docente {

	private int legajo;
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

	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public int getID_Estado() {
		return ID_Estado;
	}
	public void setID_Estado(int iD_Estado) {
		ID_Estado = iD_Estado;
	}
	
	
	
}
