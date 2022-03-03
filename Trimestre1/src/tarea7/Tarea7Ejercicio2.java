package tarea7;
/* Implementa un programa Java con un método llamado
 * average(double [] tabla) que devuelva un dato de tipo double, que
 * indique la media de los valores de los elementos de la tabla pasada como
 * parámetro.
 */

public class Tarea7Ejercicio2 {
	/*
	 * Pre:---
	 * Post: Este metodo devuelve la media aritmetica de los elementos de una tabla de enteros
	 */
	private static double average(double[] tabla) {
		double suma = 0;
		int i;
		for(i = 0; i<tabla.length; i++) {
			suma += tabla[i];
		}
		return suma/i;
	}
	/*
	 * Pre: --- 
	 * Post: Este metodo main hace una prueba sobre un metodo de media aritmetica
	 * de los elementos de una tabla de enteros
	 */
	public static void main(String[] args) {
		double[] tablaPrueba = new double[20];
		double comprobacion = 0;
		int i;
		for(i = 0; i < tablaPrueba.length; i++) {
			tablaPrueba[i] = i+0.5;
			comprobacion += i+0.5;
		}
		System.out.println(average(tablaPrueba));
		System.out.println(i);
		System.out.println(comprobacion/i);
	}
}
