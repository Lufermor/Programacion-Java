package clasesYObjetos2;

public class PruebaFiguras {
	public static void main (String[] args) {
		Triangulo t1 = new Triangulo();
		System.out.println();
		Triangulo t2 = new Triangulo(2, 3, 4);
		Rectangulo r1 = new Rectangulo();
		Rectangulo r2 = new Rectangulo(5, 6);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		System.out.println(r1.toString());
		System.out.println(r2.toString());
	}
}
