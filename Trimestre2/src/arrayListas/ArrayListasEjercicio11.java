package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que ordene
alfab�ticamente los elementos de un ArrayList de datos String.
 */
public class ArrayListasEjercicio11 {
	/*
	 * Pre: ---
	 * Post: Este metodo main
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "negro, azul, marr�n, gris, verde, naranja, rosa, p�rpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgo�a, lavanda, magenta, salm�n, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo p�lido, fucsia, mostaza, ocre, trullo, malva, "
				+ "p�rpura oscuro, verde lima, verde claro, ciruela, azul claro, melocot�n, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		colores.sort((o1, o2) -> o1.compareTo(o2));
		System.out.println(colores);
	}
}
