package clasesYObjetos2;

public class Rectangulo {
	private double b;
	private double h;
	private double area;
	private double perimetro;
	
	public Rectangulo() {
		b = h = 1;
		calcularPerimetro();
		calcularArea();
	}
	
	public Rectangulo(double b, double h) {
		this.b = comprobarLado(b);
		this.h = comprobarLado(h);
		calcularPerimetro();
		calcularArea();
	}
	
	public void setB(double b) {
		this.b = comprobarLado(b);
		calcularPerimetro();
		calcularArea();
	}
	
	public double getH() {
		return h;
	}
	
	public void setH(double h) {
		this.h = comprobarLado(h);
		calcularPerimetro();
		calcularArea();
	}
	
	public double getPerimetro() {
		return perimetro;
	}
	
	public double getArea() {
		return area;
	}
	//No se implementan los setter de �rea y permetro ya que se calculan autom�ticamente a partir de los lados
	
	/*
	 * Pre: ---
	 * Post: Calcula el per�metro del rect�ngulo
	 */
	public void calcularPerimetro() {
		perimetro = b + b + h + h;
	}
	
	/*
	 * Pre: ---
	 * Post: Calcula el �rea del rect�ngulo
	 */
	public void calcularArea() {
		area = b*h;
	}
	
	/*
	 * Pre: ---
	 * Post: Comprueba que el dato es positivo, de lo contrario devuelve 1
	 */
	public double comprobarLado(double dato) {
		if(dato>0) return dato;
		else return 1;
	}
	
	@Override
	public String toString() {
		return "Rect�ngulo: [base = " + b + ", altura = " + h + 
				", per�metro = " + perimetro + ", �rea = " + area + "]";
	}
}
