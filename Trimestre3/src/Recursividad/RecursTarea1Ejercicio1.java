package Recursividad;

public class RecursTarea1Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: suma de forma recursiva los numeros naturales hasta un número n dado
	 */
	private static int sumarNaturales(int n) {
		if(n == 0) return 0;
		else return n + sumarNaturales(n-1);
	}
	
	/*
	 * Pre: --- 
	 * Post: realiza pruebas sobre el método de sumar
	 */
	public static void main(String[] args) {
		for(int i= 1; i < 20; i++) {
			System.out.println("\nSuma no recursiva = " + (i*(i+1)/2));
			System.out.println("Suma recursiva = " + sumarNaturales(i));
		}
	}
}
