package practica3;

public class UsuarioBizi {
	private int idUsuario;
	private int traslados;
	private int circulares;
	private int totalUsos;
	
	public UsuarioBizi() {
		idUsuario = traslados = circulares = totalUsos = 0;
	}
	
	public UsuarioBizi(int idUsuario, int traslados, int circulares) {
		this.idUsuario = idUsuario; 
		this.traslados = traslados;
		this.circulares = circulares;
		calcularUsosTotales();
	}
	
	public void setIDUsuario(int idUsuario) {
		this.idUsuario =idUsuario; 
	}
	
	public int getIDUsuario() {
		return this.idUsuario;
	}
	
	public void setTraslados(int traslados) {
		this.traslados =traslados; 
		calcularUsosTotales();
	}
	
	public int getTraslados() {
		return this.traslados;
	}
	
	public void setCirculares(int circulares) {
		this.circulares =circulares; 
		calcularUsosTotales();
	}
	
	public int getCirculares() {
		return this.circulares;
	}
	/* Este método no se implementa porque los usos totales se calculan automáticamente:
	public void setUsosTotales(int totalUsos) {
		totalUsos =totalUsos; 
	}*/
	
	public int getUsosTotales() {
		return this.totalUsos;
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo suma los traslados y los circulares y
	 * los guarda en la variable usos totales
	 */
	public void calcularUsosTotales() {
		this.totalUsos = this.traslados + this.circulares;
	}
	
	/*
	 * Pre: ---
	 * Post: Este método suma a los traslados y circulares, los datos pasados como parámetros
	 */
	public void sumarUsos(int tr, int cir) {
		this.traslados += tr;
		this.circulares += cir;
		calcularUsosTotales();
	}
	
	/*
	 * Pre: ---
	 * Post: Este método aumenta el numero de traslados
	 */
	public void sumarTraslado(int tr) {
		this.traslados += tr;
		calcularUsosTotales();
	}
	
	/*
	 * Pre: ---
	 * Post: Este método aumenta el numero de usos circulares
	 */
	public void sumarCircular(int cir) {
		this.circulares += cir;
		calcularUsosTotales();
	}
	
	@Override
	public String toString() {
		return "[IdUsuario: " + idUsuario + 
				", Traslados: " + traslados + 
				", Usos circulares: " + circulares + 
				", Usos totales: " + totalUsos +"]";
		
	}
}
