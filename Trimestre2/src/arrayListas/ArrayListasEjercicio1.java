package arrayListas;
import java.util.ArrayList;

/*
 * Implementa un programa Java que contenga una
ArrayList de datos String. Almacena en �l todos los colores que
conozcas y mu�stralos por pantalla.
 */
public class ArrayListasEjercicio1 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea un arrayList de strings, le introduce objetos y luego lo recorre para mostrarlos por pantalla 
	 */
	public static void main(String[] args) {
		ArrayList<String> colores = new ArrayList<String>();
		String colors = "Negro, azul, marr�n, gris, verde, naranja, rosa, p�rpura, rojo, blanco, amarillo, "
				+ "turquesa, verde oliva, verde menta, borgo�a, lavanda, magenta, salm�n, cian, beige, rosado, "
				+ "verde oscuro, verde oliva, lila, amarillo p�lido, fucsia, mostaza, ocre, trullo, malva, "
				+ "p�rpura oscuro, verde lima, verde claro, ciruela, azul claro, melocot�n, violeta, tan, granate";
		//String colorines[] = colors.split(", ");
		for(String color:colors.split(", ")) {
			colores.add(color);
		}
		for(String color:colores) {
			System.out.print(color + ", ");
		}
	}
}
