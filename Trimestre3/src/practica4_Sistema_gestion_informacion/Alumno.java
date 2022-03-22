package practica4_Sistema_gestion_informacion;

public class Alumno {
	private int nip;
	private String apellidos;
	private String nombre;
	
	public Alumno() {
		this.nip = 0;
		this.apellidos = "";
		this.nombre = "";
	}
	
	public Alumno(int nip, String apellidos, String nombre) {
		this.nip = nip;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [nip=" + nip + ", apellidos=" + apellidos + ", nombre=" + nombre + "]";
	}
	
	
}
