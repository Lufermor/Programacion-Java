package clasesYObjetos2;

public class Triangulo {
	private double a;
	private double b;
	private double c;
	private double area;
	private double perimetro;
	
	public Triangulo() {
		a = b = c = 1;
		calcularPerimetro();
		calcularArea();
	}
	
	public Triangulo(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		calcularPerimetro();
		calcularArea();
	}
	
	public double getA() {
		return a;
	}
	
	public void setA(double a) {
		this.a = comprobarLado(a);
		calcularPerimetro();
		calcularArea();
	}
	
	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b = comprobarLado(b);
		calcularPerimetro();
		calcularArea();
	}
	
	public double getC() {
		return c;
	}
	
	public void setC(double c) {
		this.c = comprobarLado(c);
		calcularPerimetro();
		calcularArea();
	}
	
	public double getPerimetro() {
		return perimetro;
	}
	
	public double getArea() {
		return area;
	}
	//No se implementan los setter de area y perimetro ya que se calculan automáticamente a partir de los lados
	
	/*
	 * Pre: ---
	 * Post: Calcula el perímetro del triángulo
	 */
	public void calcularPerimetro() {
		perimetro = a + b + c;
	}
	
	/*
	 * Pre: El perímetro del triángulo debe ser conocido
	 * Post: Calcula el área del triángulo
	 */
	public void calcularArea() {
		double p= perimetro/2;
		area = Math.sqrt(p*(p-a)*(p-b)*(p-c)); //Fórmula de Herón
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
		return "Triangulo: [lado a = " + a + ", lado b = " + b + ", lado c = " + c + 
				", perímetro = " + perimetro + ", área = " + area + "]";
	}
}
