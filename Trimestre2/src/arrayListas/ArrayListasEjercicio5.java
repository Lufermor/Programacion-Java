package arrayListas;
import java.util.ArrayList;
/*
 * Implementa un programa Java elimine el elemento en la
posición 3 de un ArrayList de datos String.
 */
public class ArrayListasEjercicio5 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList y elimina el elemento en la tercera posición
	 */
	public static void main(String args[]) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marrón, gris, verde, naranja, rosa, púrpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgoña, lavanda, magenta, salmón, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo pálido, fucsia, mostaza, ocre, trullo, malva, "
				+ "púrpura oscuro, verde lima, verde claro, ciruela, azul claro, melocotón, violeta, tan, granate";
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		System.out.println("Elemento en la posición 3: " + colores.get(2));
		System.out.println("Borrando elemento en la posición 3");
		colores.remove(2);
		System.out.println("\nNuevo elemento en la posición 3: " + colores.get(2));
	}
}
