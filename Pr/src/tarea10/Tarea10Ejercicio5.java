package tarea10;

public class Tarea10Ejercicio5 {
	/*
	 * Pre:---
	 * Post: Este metodo recibe una tabla unidimensional de strings, y 
	 * la devuelve ordenada alfabéticamente
	 */
	private static void ordenarTablaStrings(String tabla[]){
		for(int i=0; i<tabla.length; i++) {
			for(int j=i+1; j<tabla.length; j++) {
				if(tabla[i].toLowerCase().compareTo(tabla[j].toLowerCase()) > 0) {
					String temp = tabla[i];
					tabla[i] = tabla[j];
					tabla[j] = temp;
				}
			}
		}
	}
	/*
	 * Pre:---
	 * Post: Este metodo main tiene una tabla de cadenas string, 
	 * y llama al metodo ordenarTabla para ordenarla alfabeticamente, y luego la imprime
	 */
	public static void main(String[] args) {
		String nombres[] = {"Pepe", "Juan", "María", "Antonio", "Luisa"};
		ordenarTablaStrings(nombres);
		System.out.println("Tabla ordenada alfabéticamente:");
		for(int i=0; i<nombres.length; i++){
			if(i==nombres.length-1) {
				System.out.println(nombres[i]);
			}else {
				System.out.print(nombres[i] + " / ");
			}
		}
	}
}
