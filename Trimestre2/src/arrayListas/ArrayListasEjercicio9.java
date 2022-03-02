package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que compare dos
ArrayLists de datos String.
 */
public class ArrayListasEjercicio9 {
	/*
	 * Pre:---
	 * Post: Compara dos listas y dice si son iguales o no
	 */
	public static void comparar(ArrayList uno, ArrayList dos) {
		if(uno.equals(dos)) {
			System.out.println("Las listas son iguales");
		}else {
			System.out.println("NO son iguales");
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main crea una lista, luego hace una copia, y las compara.
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marr�n, gris, verde, naranja, rosa, p�rpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgo�a, lavanda, magenta, salm�n, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo p�lido, fucsia, mostaza, ocre, trullo, malva, "
				+ "p�rpura oscuro, verde lima, verde claro, ciruela, azul claro, melocot�n, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		ArrayList<String> colores2 = new ArrayList<String>(colores);
		comparar(colores, colores2);
		colores2.add("aaa");
		comparar(colores, colores2);
		colores.add("aaa");
		comparar(colores, colores2);
	}
}
