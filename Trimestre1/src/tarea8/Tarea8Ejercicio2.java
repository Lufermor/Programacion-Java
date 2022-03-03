package tarea8;
import java.util.Random;
/*
 *  Implementa un método Java llamado incrementarValores, el
	cual recibe una tabla y un valor numérico, y devuelve todos los elementos
	de la tabla multiplicados por dicho valor, excepto el primero y el último.
 */

public class Tarea8Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo recive una tabla y un valor numerico y devuelve otra tabla 
	 * con los valores de la primera multiplicados por el valor numerico aportado
	 */
	private static int[] incrementarValores(int[] tabla1, int a) {
		System.out.println("\nMultiplicador: " + a);
		int[] tabla2 = new int[tabla1.length - 2];
		for(int i = 0; i < tabla2.length; i++) {
			tabla2[i] = tabla1[i+1]*a;
		}
		return tabla2;
	}
	/*
	 * Pre:---
	 * Post: Este metodo main pone a prueba el metodo Incrementar valores
	 * enviandole una tabla generada aleatoriamente
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		int[] tabla = new int[rand.nextInt(4)+4];
		System.out.println("Tabla inicial:");
		for(int i = 0; i < tabla.length; i++) {
			tabla[i] = rand.nextInt(10);//damos valores a los elementos de la tabla, de 0 a 9
			System.out.print(tabla[i] + ", ");
		}
		int[] tab = incrementarValores(tabla, rand.nextInt(10));
		System.out.println("\nTabla final:");
		for(int j = 0; j < tab.length; j++) {
			System.out.print(tab[j] + ", ");
		}
	}
}
