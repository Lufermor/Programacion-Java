package practica2;

public class Tripleta {
	private int generacion;
	private int vivas;
	private int diferencia;
	
	public Tripleta() {
		generacion = 0;
		vivas = 0;
		diferencia = 0;
	}
	
	public Tripleta(int generacion, int vivas, int diferencia) {
		this.generacion = generacion;
		this.vivas = vivas;
		this.diferencia = diferencia;
	}
	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}
	
	public int getGeneracion() {
		return this.generacion;
	}
	
	public void setVivas(int vivas) {
		this.vivas = vivas;
	}
	
	public int getVivas() {
		return this.vivas;
	}
	
	public void setDiferencia(int diferencia) {
		this.diferencia = diferencia;
	}
	
	public int getDiferencia() {
		return this.diferencia;
	}
	
	@Override
	public String toString() {
		return "[Generacion: " + this.generacion + ", Celulas vivas: " 
				+ this.vivas + ", Diferencia con iteracion anterior: " + this.diferencia + "]";
		
	}
}
