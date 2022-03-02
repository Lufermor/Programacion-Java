package tarea7;
/* Implementa un programa Java con un método llamado
 * copyArray(String[] tabla, String[] tabla2) que devuelva “tabla2” con los
 * mismos valores de “tabla”. Es decir, el programa debe copiar el contenido
 * de una tabla en otra.
 */

public class Tarea7Ejercicio5 {
	/*
	 * Pre: ---
	 * Post: Este metodo copia los valores de una tabla dada a otra
	 */
	private static String[] copyArray(String[] tabla, String[] tabla2) {
		for(int i = 0; i < tabla.length; i++) {
			tabla2[i] = tabla[i];
		}
		return tabla2;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pone a prueba el metodo compyArray comprobando que copia bien
	 * una tabla que le envía en otra nueva.
	 */
	public static void main(String [] args) {
		String[] a = {"Avila","Burgos","Leon","Palencia","Salamanca",
				   "Segovia","Soria","Valladolid","Zamora"};
		String[] b = new String [a.length];
		/*
		 * b = a;
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		 */
		b = copyArray(a, b);
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
