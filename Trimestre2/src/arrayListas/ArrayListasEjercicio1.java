package arrayListas;
import java.util.ArrayList;

/*
 * Implementa un programa Java que contenga una
ArrayList de datos String. Almacena en él todos los colores que
conozcas y muéstralos por pantalla.
 */
public class ArrayListasEjercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de strings, le introduce objetos y luego lo recorre para mostrarlos por pantalla 
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marrón, gris, verde, naranja, rosa, púrpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgoña, lavanda, magenta, salmón, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo pálido, fucsia, mostaza, ocre, trullo, malva, "
				+ "púrpura oscuro, verde lima, verde claro, ciruela, azul claro, melocotón, violeta, tan, granate";
		//String colorines[] = colors.split(", ");
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		for(String color:colores) {
			System.out.print(color + ", ");
		}
	}
}
