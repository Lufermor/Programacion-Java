package arrayListas;
import java.util.ArrayList;

public class ArrayListEjercicio000 {
	public static void main(String[] args) {
		ArrayList<Integer> enteros = new ArrayList<Integer>();
		
		for(int i = 1; i<=100; i++) {
			enteros.add(i);
		}
		System.out.println("El tamaño de la lista es: " + enteros.size()
							+ "\nMetodo 1: ");
		for(int i = 0; i<enteros.size(); i++) {
			System.out.print(enteros.get(i) + ", ");
		}
		System.out.println("\n--------------------------------------------------------"
				+ "\nMetodo 2: ");
		for(int entero:enteros) {
			System.out.print(entero + ", ");
		}
		String[] colores = "blanco, negro, rojo, azul, gris".split(", ");
		for(int i = 0; i<colores.length; i++) {
			System.out.println("\n" + colores[i]);
		}
		
	}
}
