package arrayListas2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListas2Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo le pide un dato al usuario
	 */
	private static String pedirDato(String frase) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(frase);
		return entrada.nextLine();
	}
	/*
	 * Pre: ---
	 * Post: Este comprueba si una cadena dada es un numero entero
	 */
	private static boolean esEntero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: muestra por pantalla la suma de todos los elementos de la lista pasada como parámetro.
	 */
	private static void calcularSuma(ArrayList<Integer> lista) {
		int suma = 0;
		for(int num:lista) suma+=num;
		System.out.println("La suma de los elementos de la lista es= " + suma);
	}
	/*
	 * Pre: ---
	 * Post: muestra por pantalla la media aritmética de la lista pasada como parámetro.
	 */
	private static void calcularMedia(ArrayList<Integer> lista) {
		int suma = 0;
		for(int num:lista) suma+=num;
		System.out.println("La media aritmética de los elementos de la lista es= " + suma/lista.size());
	}
	/*
	 * Pre: ---
	 * Post: muestra por pantalla si la lista pasada por parámetros es capicúa.
	 */
	private static void esCapicua(ArrayList<Integer> lista) {
		boolean capicua = true;
		for(int i = 0, j = lista.size()-1; i<j; i++, j--) {
			if(lista.get(i)!=lista.get(j)) capicua = false; break;
		}
		if(capicua) System.out.println("La lista es capicua");
		else System.out.println("La lista NO es capicua");
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pide constantemente numeros enteros al usuario y los introduce en una lista hasta que 
	 * este introduce un cero, en ese momento llama unos metodos para realizar calculos sobre la lista.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(true) {
			String dato = pedirDato("Inserte un número entero: ");
			if(esEntero(dato)) {
				int num = Integer.parseInt(dato);
				if(num == 0) {
					calcularSuma(nums);
					calcularMedia(nums);
					esCapicua(nums);
					break;
				}else {
					nums.add(num);
				}
			}else {
				System.out.println("Recuerde que debe ser un número entero");
			}
		}
	}
}
