package arrayListas;

import java.util.ArrayList;
/*
 * Implementa un programa Java que inserte un elemento
en la primera posici�n de un ArrayList de datos String.
 */
public class ArrayListasEjercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de Strings, inserta un nuevo elemento en 
	 * la primera posici�n de este, y lo imprime por pantalla.
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marr�n, gris, verde, naranja, rosa, p�rpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgo�a, lavanda, magenta, salm�n, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo p�lido, fucsia, mostaza, ocre, trullo, malva, "
				+ "p�rpura oscuro, verde lima, verde claro, ciruela, azul claro, melocot�n, violeta, tan, granate";
		//String colorines[] = colors.split(", ");
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		System.out.println("Primer elemento del arrayList: ");
		System.out.println(colores.get(0));
		System.out.println("Tama�o del arrayList: " + colores.size());
		System.out.println("----------Anadimos elemento en la primera posicion-----------");
		colores.add(0, "Primero lo primero");
		System.out.println("Nuevo tama�o del arrayList: " + colores.size());
		System.out.println("Primer nuevo elemento del arrayList: ");
		System.out.println(colores.get(0));
	}
}
