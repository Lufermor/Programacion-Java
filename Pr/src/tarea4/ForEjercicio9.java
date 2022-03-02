package tarea4;

import java.util.Scanner;

public class ForEjercicio9 {
	/*
	 * Escribe un programa Java que pregunte al usuario por 10 números enteros 
	 * y muestre por pantalla el número total de veces que el usuario ha introducido el 0, 
	 * el número total de enteros mayores que 0 introducidos y el número total de enteros 
	 * menores que 0 introducidos.
	 */
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo pide al usuario un numero entero y lo devuelve
	 */
	private static int pedirEntero() {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje("Introduzca un numero entero");
		int num = entrada.nextInt();
		return num;
	}
	/*
	 * Pre: ---
	 * Post: este metodo implementa un bucle for para pedir al usuario 10 numeros enteros, 
	 * luego imprime en pantalla la cantidad de positivos, negativos, y ceros introducidos. 
	 */
	private static void positivosNegativos() {
		int positivos = 0;
		int negativos = 0;
		int ceros = 0;
		for(int i=0; i<10; i++) {
			int aux = pedirEntero(); //Introducimos una variable auxiliar para ayudar con la comprobacion
			if(aux>0) {
				positivos++;
			}else if(aux<0) {
				negativos++;
			}else {
				ceros++;
			}
		}
		mostrarMensaje("La cantidad de numeros introducidos mayores que cero es: \n" + positivos);
		mostrarMensaje("La cantidad de numeros introducidos menores que cero es: \n" + negativos);
		mostrarMensaje("La cantidad de ceros introducidos es : \n" + ceros);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main ejecuta el metodo positivosNegativos para pedir al usuario 
	 * 10 numeros y luego mostrar en pantalla la cantidad de positivos, negativos y ceros
	 * introducidos.
	 */
	public static void main(String[] args) {
		positivosNegativos();
	}
}
