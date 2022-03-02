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
		String colors = "Negro, azul, marr�n, gris, verde, naranja, rosa, p�rpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgo�a, lavanda, magenta, salm�n, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo p�lido, fucsia, mostaza, ocre, trullo, malva, "
				+ "p�rpura oscuro, verde lima, verde claro, ciruela, azul claro, melocot�n, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		ArrayList<String> colores2 = new ArrayList<String>(colores);
		colores2.set(0, "era negro");
		System.out.println(colores.get(0));
		System.out.println(colores2.get(0));
		System.out.println("Con esto comprobamos que se cre� una lista independiente y no est� apuntando a la misma");
	}
}
