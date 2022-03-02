package tarea4;
// Escribe un programa Java que te muestre los números enteros entre 50 y 100 (ambos incluídos)
public class ForEjercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este llama al metodo mostrarMensaje para imprimir numeros
	 */
	private static void ejecutar() {
		for(int i=50; i<=100; i++) {
			mostrarMensaje("" + i);
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main llama al metodo ejecutar
	 */
	public static void main(String[] args) {
		ejecutar();
	}
}
