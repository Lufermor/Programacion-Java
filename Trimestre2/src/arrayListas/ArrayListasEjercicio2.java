package arrayListas;

import java.util.ArrayList;
/*
 * Implementa un programa Java que inserte un elemento
en la primera posición de un ArrayList de datos String.
 */
public class ArrayListasEjercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de Strings, inserta un nuevo elemento en 
	 * la primera posición de este, y lo imprime por pantalla.
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marrón, gris, verde, naranja, rosa, púrpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgoña, lavanda, magenta, salmón, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo pálido, fucsia, mostaza, ocre, trullo, malva, "
				+ "púrpura oscuro, verde lima, verde claro, ciruela, azul claro, melocotón, violeta, tan, granate";
		//String colorines[] = colors.split(", ");
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		System.out.println("Primer elemento del arrayList: ");
		System.out.println(colores.get(0));
		System.out.println("Tamaño del arrayList: " + colores.size());
		System.out.println("----------Anadimos elemento en la primera posicion-----------");
		colores.add(0, "Primero lo primero");
		System.out.println("Nuevo tamaño del arrayList: " + colores.size());
		System.out.println("Primer nuevo elemento del arrayList: ");
		System.out.println(colores.get(0));
	}
}
