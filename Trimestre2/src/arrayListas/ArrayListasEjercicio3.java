package arrayListas;
import java.util.ArrayList;

/*
 * Implementa un programa Java que muestre por pantalla
el valor de un elemento específico (debes indicar el índice) de un
ArrayList de datos String.	
 */
public class ArrayListasEjercicio3 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de Strings, y luego mediante un bucle, 
	 * imprime por pantalla los elementos del quinto al decimo llamandolos por sus posiciones en la lista. 
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
		for(int i = 4; i<10; i++) {
			System.out.print(colores.get(i) + ", ");
		}
	}
}
