package tarea7;
/* Implementa un programa Java con un método llamado
 * sum(int [] tabla) que muestre por pantalla el resultado de sumar todos los
 * elementos de la tabla pasada como parámetro.
 */

public class Tarea7Ejercicio1 {
	/*
	 * Pre:---
	 * Post: Este metodo suma los elementos de una tabla de enteros
	 */
	private static void sum(int[] tabla) {
		int suma = 0;
		for(int i = 0; i<tabla.length; i++) {
			suma += tabla[i];
		}
		System.out.print(suma);
	}
	/*
	 * Pre: --- 
	 * Post: Este metodo main hace una prueba sobre un metodo de suma de elementos
	 * de una tabla
	 */
	public static void main(String[] args) {
		int[] tablaPrueba = new int[200];
		int comprobacion = 0;
		for(int i = 0; i < tablaPrueba.length; i++) {
			tablaPrueba[i] = i;
			comprobacion += i;
		}
		System.out.println(comprobacion);
		sum(tablaPrueba);
	}
}
