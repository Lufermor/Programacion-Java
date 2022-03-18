package practica4_Sistema_gestion_informacion;

public class Matricula {
	private int nipAlumno;
	private int codAsignatura;
	
	public Matricula() {
		this.nipAlumno = 0;
		this.codAsignatura = 0;
	}

	public Matricula(int nipAlumno, int codAsignatura) {
		this.nipAlumno = nipAlumno;
		this.codAsignatura = codAsignatura;
	}

	public int getNipAlumno() {
		return nipAlumno;
	}

	public void setNipAlumno(int nipAlumno) {
		this.nipAlumno = nipAlumno;
	}

	public int getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(int codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	@Override
	public String toString() {
		return "Matricula [nipAlumno=" + nipAlumno + ", codAsignatura=" + codAsignatura + "]";
	}
	
}
