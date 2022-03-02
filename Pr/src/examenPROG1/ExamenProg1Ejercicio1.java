package examenPROG1;
import java.util.Scanner;
/*
 * Esta clase, dada una tabla de numeros enteros positivos, y un numero M
 * dado por el usuario, selecciona y muestra por pantalla los M numeros mayores de la tabla
 */

public class ExamenProg1Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si una cadena introducida es un entero
	 */
	private static boolean esEntero(String a) {
		try {
			Integer.parseInt(a);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo copia los valores de una tabla unidimensional de enteros dada a otra
	 */
	private static int[] copiarTabla(int[] tabla, int[] tabla2) {
		for(int i = 0; i < tabla.length; i++) {
			tabla2[i] = tabla[i];
		}
		return tabla2;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de enteros y un entero positivo m, y
	 * muestra por pantalla los m numeros mayores de la tabla
	 */
	private static void mejores(int[] tabla, int m) {
		System.out.println("\n----------Mayores (M = " + m + ")----------");
		int[] tabla2 = new int[tabla.length];
		copiarTabla(tabla, tabla2);
		for(int i = 0; i<tabla2.length; i++) {
			for(int j=i+1; j<tabla2.length; j++) {
				if(tabla2[j]>tabla2[i]) {
					int aux = tabla2[i];
					tabla2[i] = tabla2[j];
					tabla2[j] = aux;
				}
			}
			if(i<m) {
				if(i==m-1) {
					System.out.println(tabla2[i]);
				}else {
					System.out.print(tabla2[i] + " / ");
				}
			}
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide al usuario un numero entero y con este y una tabla
	 * dada, llama al metodo mejores para mostrar por pantalla los mayores
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int[] tabla = {10, 40, 100, 1, -3, 20, 50};
		int num = 0;
		String cadena = "";
		while(true) {
			System.out.println("Introduzca un numero entero positivo:");
			cadena = entrada.nextLine();
			if(esEntero(cadena)) {
				num = Integer.parseInt(cadena);
				if(num<=0) {
					System.out.println("Recuerde que debe ser un entero positivo.");
				}else if(num>tabla.length) {
					System.out.println("Lo sentimos, el numero es mayor que la longitud de la tabla, "
							+ "por favor pruebe con un numero menor.");
				}else {
					break;
				}
			}
		}
		System.out.println("Tabla: ");
		for(int i = 0; i<tabla.length; i++) {
			if(i==tabla.length-1) {
				System.out.println(tabla[i]);
			}else {
				System.out.print(tabla[i] + " / ");
			}
		}
		mejores(tabla, num);
	}
}
