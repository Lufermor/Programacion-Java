package recursividad;

public class RecursTarea3Ejercicio4 {
	/*
	 * Pre: al llamar al m�todo desde el main, n1 y n2 corresponden a los dos primeros 
	 * n�meros de la serie. i ser�a el n�mero de iteraci�n actual, k es la iteraci�n
	 * que queremos calcular (k>2) 
	 * Post: calcula recursivamente un n�mero de la serie de fibonacci 
	 */
	private static void fibonacci(int n1, int n2, int i, int k) {
		if(i==k) System.out.println(n2);
		else fibonacci(n2, (n1+n2), ++i, k);
	}
	/*
	 * Pre: ---
	 * Post: realiza pruebas sobre el m�todo fibonacci
	 */
	public static void main(String[] args) {
		for(int k=2; k<=10;k++) {
			fibonacci(0, 1, 2, k);
		}
	}
}
