package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que copie/clone un
ArrayList en otro.
 */
public class ArrayListasEjercicio6 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList, le introduce datos, luego crea otro y 
	 * copia todos los elementos del primero en el segundo.
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marrón, gris, verde, naranja, rosa, púrpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgoña, lavanda, magenta, salmón, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo pálido, fucsia, mostaza, ocre, trullo, malva, "
				+ "púrpura oscuro, verde lima, verde claro, ciruela, azul claro, melocotón, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		ArrayList<String> colores2 = new ArrayList<String>(colores);
		colores2.set(0, "era negro");
		System.out.println(colores.get(0));
		System.out.println(colores2.get(0));
		System.out.println("Con esto comprobamos que se creó una lista independiente y no está apuntando a la misma");
	}
}
