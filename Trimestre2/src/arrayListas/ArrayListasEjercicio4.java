package arrayListas;
import java.util.ArrayList;
//import java.util.Iterator;
/*
 * Implementa un programa Java que actualice el valor de
un elemento específico de un ArrayList de datos String.
 */
public class ArrayListasEjercicio4 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de Strings, reemplaza el primer elemento y lo muestra por pantalla
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
		//Iterator<String> ite = colores.iterator();
		System.out.println("Tamaño del arrayList: " + colores.size());
		System.out.println("Valor del primer elemento: " + colores.get(0));
		colores.set(0, "casi negro");
		System.out.println("\nNuevo valor del primer elemento: " + colores.get(0));
		System.out.println("Nuevo tamaño del arrayList: " + colores.size());
	}
}
