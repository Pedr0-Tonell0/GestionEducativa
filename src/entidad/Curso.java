package entidad;

public class Curso {
	private int IdCurso;
	private Materia materia;
	private Docente docente;
	private Alumno alumno;
	private int anio;
	private int cuatrimestre;
	private int cantidadAlumnos;
	private int aprobados;
	private int desaprobados;
	private int parcial1;
	private int parcial2;
	private int recuperatorio1;
	private int recuperatorio2;
	private int estado;

	public Curso() {
	}

	public int getIdCurso() {
		return IdCurso;
	}

	public void setIdCurso(int idCurso) {
		IdCurso = idCurso;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public int getAprobados() {
		return aprobados;
	}

	public void setAprobados(int aprobados) {
		this.aprobados = aprobados;
	}

	public int getDesaprobados() {
		return desaprobados;
	}

	public void setDesaprobados(int desaprobados) {
		this.desaprobados = desaprobados;
	}

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

	@Override
	public String toString() {
		return "Cursos [IdCurso=" + IdCurso + ", materia=" + materia + ", docente=" + docente + ", alumno=" + alumno
				+ ", Anio=" + anio + ", Cuatrimestre=" + cuatrimestre + ", CantidadAlumnos=" + cantidadAlumnos
				+ ", Aprobados=" + aprobados + "]";
	}

}
