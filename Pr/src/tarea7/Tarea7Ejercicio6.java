package tarea7;
/*
 * Implementa un programa Java con un metodo llamado
 * insertElement(int[] tabla, int num, int index) que devuelve “tabla”,
 * insertando el valor de “num” en el índice “index” pasado por parámetro.
 * Como ya conocemos, las tablas tienen una longitud máxima que se indica
 * al crearlas. Por lo tanto, para añadir este nuevo elemento deberemos
 * desplazar el resto una posición hacia abajo. Es decir, si queremos 
 * almacenar num=2 en index=3, los elementos en la posición desde 3 hasta
 * tabla.length deberán desplazarse para dejar hueco al nuevo elemento.
 */

public class Tarea7Ejercicio6 {
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve una tabla a la que se le ha insertado el entero
	 * indicado en una posicion indicada.
	 */
	private static int[] insertElement(int[] tabla, int num, int index) {
		int[] tabla2 = new int[tabla.length + 1];
		for(int i = 0; i < tabla.length; i++) {
			if(i == index) {
				tabla2[i] = num;
				for(int j = i; j < tabla.length; j++) {
					tabla2[j+1] = tabla[j];/*necesitamos retomar un nuevo bucle desde el 
					punto donde insertamos el nuevo entero para añadir el resto de la tabla*/
				}
				break;
			}else {
				tabla2[i] = tabla[i];
			}
		}
		return tabla2;
	}
	/*
	 * Pre:--- 
	 * Post: Este metodo main pone a prueba el metodo insertElement enviandole una tabla,
	 * un entero y un indice
	 */
	public static void main(String[] args) {
		int[] tab;
		for(int i = 1; i < 10; i++) {
			tab = new int[i];//Vamos a crear diferentes tablas con diferentes longitudes en cada iteracion
			for(int k = 0; k < i; k++) {
				tab[k]=(k+1)*2;//Creamos una tabla de multiplos de 2 
			}
			System.out.println("Tabla inicial numero " + i + ":");
			for(int h = 0; h < tab.length; h++) {
				System.out.print(tab[h]+ " ");/*Imprimimos cada elemento de la tabla para 
												comprobar que se ha creado correctamente */
			}
			tab = insertElement(tab, -25, i-1);/*Llamamos al metodo de forma que siempre le 
			 									pedimos insertar el numero -25 en la penultima posicion*/ 
			System.out.println("\nTabla final n " + i + ":");
			for(int l = 0; l < tab.length; l++) {
				System.out.print(tab[l]+ " ");
			}
			System.out.println(" ");
		}
	}
}
