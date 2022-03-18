package practica4_Sistema_gestion_informacion;

public class Asignatura {
	private int codigo;
	private double creditos;
	private int cuatrimestre;
	private String tipologia;
	private String denominacion;
	
	public Asignatura() {
		this.codigo = 0;
		this.creditos = 0;
		this.cuatrimestre = 1;
		this.tipologia = "FB";
		this.denominacion = "";
	}

	public Asignatura(int codigo, double creditos, int cuatrimestre, String tipologia, String denominacion) {
		this.codigo = codigo;
		this.creditos = creditos;
		this.cuatrimestre = cuatrimestre;
		comprobarTipologia(tipologia);
		this.denominacion = denominacion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		comprobarTipologia(tipologia);
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	
	/*
	 * Pre: ---
	 * Post: Comprueba que la tipología introducida es correcta, de lo contrario
	 * guarda el valor por defecto en la variable local.
	 */
	private void comprobarTipologia(String tipo) {
		String[] tipologias = {"FB", "OB", "OP", "TF"};
		this.tipologia = "FB";
		for(String t:tipologias) {
			if(tipo.equalsIgnoreCase(t)) {
				this.tipologia = tipo;
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", creditos=" + creditos + ", cuatrimestre=" + cuatrimestre
				+ ", tipologia=" + tipologia + ", denominacion=" + denominacion + "]";
	}
	
}
