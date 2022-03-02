package tarea8;
/* Implementa un método Java llamado calcularModa que
 * calcule la moda de una tabla Java. La moda es el valor con mayor
 * frecuencia que aparece en una colección de datos. Por ejemplo, si
 * tenemos la tabla: {1, 1, 2, 1, 4, 1, 2, 1} la moda es 1. 
 */
import java.util.Random;

public class Tarea8Ejercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo calcula la cantidad de datos unicos (sin contar repeticiones) 
	 * en una tabla de enteros.
	 */
	private static int calcularDatosUnicos(int[] tabla1) {
		if(tabla1.length == 1) {
			return 1;
		}else {
			int datoMenor = tabla1[0];
			int datoMayor = tabla1[0];
			int datosUnicos = 1;//Variable contador que nos ayuda a contar los datos unicos de la tabla.
			for(int i = 0; i < tabla1.length; i++) {//hacemos un bucle para saber el dato menor
				if(tabla1[i] < datoMenor) {
					datoMenor = tabla1[i];
				}
			}
			for(int i = 0; i < tabla1.length; i++) {//hacemos un bucle para saber el dato mayor
				if(tabla1[i] > datoMayor) {
					datoMayor = tabla1[i];
				}
			}
			int datoMenor2 = datoMenor;//Variable auxiliar
			int datoMenor3 = datoMayor;//Variable auxiliar
			while(true) {
				for(int i = 0; i < tabla1.length; i++) {
					if(tabla1[i] <= datoMenor2) {//para descartar el dato menor, no hacemos nada con esta condicion
					}else if(tabla1[i] < datoMenor3) {
						datoMenor3 =tabla1[i]; 
					}/*Con este else if, al terminar el recorrido del for encontraremos 
					el siguiente dato menor (el siguiente dato en orden) para cada iteración 
					del while, este es el dato que queda almacenado en la variable*/
				}
				datosUnicos+=1;//Aumentamos el contador de datos unicos.
				if(datoMenor3 == datoMayor) {/*si se cumple esta condicion significa que 
				 		hemos terminado de recorrer la tabla; por lo tanto salimos del bucle*/
					break;
				}else {
					datoMenor2 = datoMenor3;//actualizamos la variable para ir avanzando de dato unico
					datoMenor3 = datoMayor;//reiniciamos la variable para repetir el bucle
				}
			}
			return datosUnicos;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de enteros, y devuelve otra con 
	 * sus elementos unicos ordenados de forma ascendente. (sin repeticiones) 
	 */
	private static int[] ordenarTabla(int[] tabla1) {
		int datoMenor = tabla1[0];
		int datoMayor = tabla1[0];
		int[] tabla2 = new int[calcularDatosUnicos(tabla1)];
		for(int i = 0; i < tabla1.length; i++) {//hacemos un bucle para saber el dato menor
			if(tabla1[i] < datoMenor) {
				datoMenor = tabla1[i];
			}
		}
		for(int i = 0; i < tabla1.length; i++) {//hacemos un bucle para saber el dato mayor
			if(tabla1[i] > datoMayor) {
				datoMayor = tabla1[i];
			}
		}
		int datoMenor2 = datoMayor;//Variable auxiliar
		for(int i = 0; i < tabla2.length; i++) {
			tabla2[i] = datoMenor;
			for(int j = 0; j < tabla1.length; j++) {
				if(tabla1[j] <= datoMenor) {//para descartar el dato menor, no hacemos nada con esta condicion
				}else if(tabla1[j] < datoMenor2) {
					datoMenor2 = tabla1[j]; 
				}
			}
			datoMenor = datoMenor2;
			datoMenor2 = datoMayor;
		}
		return tabla2;
	}
	/*
	 * Pre: ---
	 * Post: Este método recibe una tabla de enteros, crea una segunda tabla donde 
	 * ordena los elementos unicos de la primera. Finalmente cuenta las veces que se 
	 * repite cada elemento de la primera tabla para calcular la moda.
	 */
	private static int calcularModa(int[] tabla1) {
		System.out.println("\nA continuacion se muestran los valores de la tabla con sus frecuencias:");
		if(tabla1.length == 1) {
			return tabla1[0];
		}else {
			int contador; //variable auxiliar que contara las apariciones de cada elemento unico
			int contador2 = 0;
			int moda = tabla1[0];
			int[] tabla2 = ordenarTabla(tabla1);
			for(int i = 0; i < tabla2.length; i++) {
				contador = 0;
				for(int j = 0; j < tabla1.length; j++) {
					if(tabla1[j] == tabla2[i]) {
						contador++;
					}
				}
				if(contador > contador2) {
					moda = tabla2[i];
					contador2 = contador;
				}
			}
			//Puede ser el caso de que una tabla tenga varias modas, para comprobarlo, implementamos el siguiente bucle
			int frecuenciaMax = contador2;
			for(int i = 0; i < tabla2.length; i++) {
				contador = 0;
				for(int j = 0; j < tabla1.length; j++) {
					if(tabla1[j] == tabla2[i]) {
						contador++;
					}
				}
				System.out.print(tabla2[i] + ":" + contador + " ");
				if(contador == frecuenciaMax && tabla2[i] != moda) {
					System.out.println("\nLa tabla tiene varias modas, una de las modas es: " + tabla2[i]);
				}
			}
			return moda;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pone a prueba el procedimiento de calcular moda con los
	 * metodos anteriores, utilizando para esto diferentes tablas generadas aleatoriamente.
	 */
	public static void main(String[] args) {
		int[] tabla = {1, 1, 2, 2, 4, 1, 2, 2, 2, 2, 2, 1, 1, 
				3, 5, 1, 2, 3, 5, 5, 2, 5, 5, 5, 1, 2, 1, 1, 1, 2, 2, 3, 6};
		System.out.println("\nLa moda de la tabla 0 es: " + calcularModa(tabla));
		int[] tab = new int[20];
		Random rand = new Random();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < tab.length; j++) {
				tab[j] = rand.nextInt(6)+1;
			}
			System.out.println("Tabla inicial numero " + (i+1) + ":");
			for(int h = 0; h < tab.length; h++) {
				System.out.print(tab[h]+ " ");/*Imprimimos cada elemento de la tabla para 
				comprobar que se ha creado correctamente y ver manualmente los elementos*/
			}
			System.out.println("\nLa moda de la tabla " + (i+1) + " es: " +calcularModa(tab));
		}		
	}
}
