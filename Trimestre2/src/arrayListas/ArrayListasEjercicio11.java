package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que ordene
alfabéticamente los elementos de un ArrayList de datos String.
 */
public class ArrayListasEjercicio11 {
	/*
	 * Pre: ---
	 * Post: Este metodo main
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "negro, azul, marrón, gris, verde, naranja, rosa, púrpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgoña, lavanda, magenta, salmón, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo pálido, fucsia, mostaza, ocre, trullo, malva, "
				+ "púrpura oscuro, verde lima, verde claro, ciruela, azul claro, melocotón, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		colores.sort((o1, o2) -> o1.compareTo(o2));
		System.out.println(colores);
	}
}
