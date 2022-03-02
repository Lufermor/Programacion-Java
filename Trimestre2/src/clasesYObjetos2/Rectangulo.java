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
	//No se implementan los setter de área y permetro ya que se calculan automáticamente a partir de los lados
	
	/*
	 * Pre: ---
	 * Post: Calcula el perímetro del rectángulo
	 */
	public void calcularPerimetro() {
		perimetro = b + b + h + h;
	}
	
	/*
	 * Pre: ---
	 * Post: Calcula el área del rectángulo
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
		return "Rectángulo: [base = " + b + ", altura = " + h + 
				", perímetro = " + perimetro + ", área = " + area + "]";
	}
}
