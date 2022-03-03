package tarea8;
import java.util.Random;
/*
 *  Implementa un método Java llamado estadisticasTabla, el
cual recibe una tabla de enteros y muestra por pantalla: el número de
enteros positivos, el número de enteros negativos, el número de 0s, el
número de enteros pares y el número de enteros impares.
 */

public class Tarea8Ejercicio3 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de enteros y muestra por pantalla el numero de positivos,
	 * de negtvos, de ceros, de pares y de impares
	 */
	private static void estadisticasTabla(int[] tabla) {
		int positivos = 0, negativos = 0, ceros = 0, pares = 0, impares = 0;
		for(int i = 0; i < tabla.length; i++) {
			if(tabla[i] == 0) {
				ceros++;
			}else if(tabla[i] < 0) {
				negativos++;
				if(tabla[i] % 2 == 0) {
					pares++;
				}else {
					impares++;
				}
			}else {
				positivos++;
				if(tabla[i] % 2 == 0) {
					pares++;
				}else {
					impares++;
				}
			}
		}
		System.out.println("\nEl numero de ceros en la tabla es: " + ceros +
							"\nEl numero de negativos en la tabla es: " + negativos +
							"\nEl numero de positivos en la tabla es: " + positivos + 
							"\nEl total de numeros pares es: " + pares + 
							"\nEl total de numeros impares es: " + impares);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pone a prueba el metodo estadisticasTabla 
	 * enviandole una tabla generada aleatoriamente
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		int[] tab = new int[rand.nextInt(15)+5];//Generamos una tabla de una longitud aleatoria entre 5 y 20
		System.out.println("Tabla inicial: ");
		for(int i = 0; i < tab.length; i++) {
			tab[i] = rand.nextInt(200)-100; //Damos valores enteros aleatorios entre -100 y 100 a los elementos de la tabla
			System.out.print(tab[i] + ", ");
		}
		estadisticasTabla(tab);
	}
}
