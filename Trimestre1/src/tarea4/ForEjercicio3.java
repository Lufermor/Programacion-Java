package tarea4;
/* Escribe un programa Java que te muestre únicamente 
 * la suma de los números enteros entre 50 y 100 (ambos incluidos)
 */
public class ForEjercicio3 {
	/*
	 * Pre: ---
	 * Post: Este metodo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este suma los enteros desde el 50 hasta el 100 
	 * y llama al metodo mostrarMensaje para imprimir el resultado
	 */
	private static void ejecutar() {
		int suma = 0;
		for(int i=50; i<=100; i++) {
			suma += i;
		}
		mostrarMensaje("La suma de los numeros enteros desde el 50 hasta el 100 es: " + suma);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main llama al metodo ejecutar
	 */
	public static void main(String[] args) {
		ejecutar();
	}
}
