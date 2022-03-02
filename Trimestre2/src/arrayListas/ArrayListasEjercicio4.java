package arrayListas;
import java.util.ArrayList;
//import java.util.Iterator;
/*
 * Implementa un programa Java que actualice el valor de
un elemento espec�fico de un ArrayList de datos String.
 */
public class ArrayListasEjercicio4 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de Strings, reemplaza el primer elemento y lo muestra por pantalla
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
		//Iterator<String> ite = colores.iterator();
		System.out.println("Tama�o del arrayList: " + colores.size());
		System.out.println("Valor del primer elemento: " + colores.get(0));
		colores.set(0, "casi negro");
		System.out.println("\nNuevo valor del primer elemento: " + colores.get(0));
		System.out.println("Nuevo tama�o del arrayList: " + colores.size());
	}
}
