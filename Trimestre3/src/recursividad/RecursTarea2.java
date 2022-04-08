package recursividad;

public class RecursTarea2 {
	/*
	 * Pre: ---
	 * Post: Encuentra el primer número natural N para el que la suma 1 + 2 + 3 + ... + N 
	 * exceda a un valor M que se introduce como parámetro. 
	 */
	private static void encontrarN(int m, int n) {
		if(n<0) n=0;
		if((n*(n+1)/2)>m) {
			System.out.println("La suma de los naturales hasta "+n+" es mayor que "+m);
		}else encontrarN(m, n+1);
	}
	/*
	 * Pre: ---
	 * Post: Llama al método encontrarN
	 */
	public static void main(String[] args) {
		encontrarN(15, 0);
	}
}
