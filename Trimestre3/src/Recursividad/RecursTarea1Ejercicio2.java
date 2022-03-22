package Recursividad;

public class RecursTarea1Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: calcula de forma recursiva el factorial de un número n 
	 */
	private static int factorial(int n) {
		if(n == 0) return 1;
		else return n*(factorial(n-1));
	}
	
	/*
	 * Pre: ---
	 * Post: Realiza pruebas sobre el método factorial 
	 */
	public static void main(String[] args) {
		int fact = 1;
		for(int i= 1; i < 20; i++) {
			fact = fact*i;
			System.out.println("Factorial nrecursiv de " + i + " = " + fact);
			System.out.println("Factorial recursivo de " + i + " = " + factorial(i));
		}
	}
}
