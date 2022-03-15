package ficherosBinarios;

public class Alumno {
	private int aprobadas;
	private int suspendidas;
	private int cursadas;
	private double precio;
	
	public Alumno() {
		this.aprobadas=0;
		this.suspendidas=0;
		this.cursadas=0;
		this.precio=0;
	}
	
	public Alumno(int cursadas, int aprobadas, int suspendidas, double precio) {
		this.aprobadas = aprobadas;
		this.suspendidas = suspendidas;
		this.cursadas = cursadas;
		this.precio = precio;
	}

	public int getAprobadas() {
		return aprobadas;
	}

	public void setAprobadas(int aprobadas) {
		this.aprobadas = aprobadas;
	}

	public int getSuspendidas() {
		return suspendidas;
	}

	public void setSuspendidas(int suspendidas) {
		this.suspendidas = suspendidas;
	}

	public int getCursadas() {
		return cursadas;
	}

	public void setCursadas(int cursadas) {
		this.cursadas = cursadas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Alumno [aprobadas=" + aprobadas + ", suspendidas=" + suspendidas + ", cursadas=" + cursadas
				+ ", precio=" + precio + "]";
	}
	
}
