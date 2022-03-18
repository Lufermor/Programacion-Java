package Recursividad;

public class RecursTarea1Ejercicio1 {
	/*
	 * Pre: ---
	 * Post:
	 */
	private static int sumarNaturales(int n) {
		if(n == 0) return 0;
		else return n + sumarNaturales(n-1);
	}
	
	/*
	 * Pre: --- 
	 * Post: 
	 */
	public static void main(String[] args) {
		for(int i= 1; i < 20; i++) {
			System.out.println("\nSuma no recursiva = " + (i*(i+1)/2));
			System.out.println("Suma recursiva = " + sumarNaturales(i));
		}
	}
}
