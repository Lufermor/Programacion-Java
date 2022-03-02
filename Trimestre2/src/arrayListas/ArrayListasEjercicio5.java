package arrayListas;
import java.util.ArrayList;
/*
 * Implementa un programa Java elimine el elemento en la
posici�n 3 de un ArrayList de datos String.
 */
public class ArrayListasEjercicio5 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList y elimina el elemento en la tercera posici�n
	 */
	public static void main(String args[]) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marr�n, gris, verde, naranja, rosa, p�rpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgo�a, lavanda, magenta, salm�n, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo p�lido, fucsia, mostaza, ocre, trullo, malva, "
				+ "p�rpura oscuro, verde lima, verde claro, ciruela, azul claro, melocot�n, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		System.out.println("Elemento en la posici�n 3: " + colores.get(2));
		System.out.println("Borrando elemento en la posici�n 3");
		colores.remove(2);
		System.out.println("\nNuevo elemento en la posici�n 3: " + colores.get(2));
	}
}
