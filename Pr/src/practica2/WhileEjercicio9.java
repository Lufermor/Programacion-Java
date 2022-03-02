package practica2;

import java.util.Scanner;

public class WhileEjercicio9 {
	/**
	 * Pre: ---
	 * Post: esta clase Java implementa un m�todo main que 
	 * pregunta al usuario por 10 n�meros enteros y muestra por pantalla:
	 *  
	 * El n�mero total de veces que el usuario ha introducido el 0, 
	 * El n�mero total de enteros mayores que 0 introducidos y 
	 * El n�mero total de enteros menores que 0 introducidos.
	 * */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Vamos a introducir diez n�meros");
		int ceros = 0;
		int positivos = 0;
		int negativos = 0;
		int i = 0;
		int num;
		while(i<10) {
			System.out.println("Introduce el n�mero n�" + ++i);
			num = entrada.nextInt();
			if(num == 0) {
				ceros++;
			}else if(num>0) {
				positivos++;
			}else {
				negativos++;
			}
		}
		System.out.println("El n�mero de veces que se ha introducido el 0 es " + ceros);
		System.out.println("El n�mero de n�meros mayores que 0 es " + positivos);
		System.out.println("El n�mero de n�meros menores que 0 es " + negativos);
	}
}
