package tarea4;

public class ForEjercicio6 {
	// Escribe un programa Java que muestre los números impares entre 0 y 100
		/*
		 * Pre: ---
		 * Post: Este metodo imprime por pantalla un mensaje dado
		 */
		private static void mostrarMensaje(String msj) {
			System.out.println(msj);
		}
		/*
		 * Pre: ---
		 * Post: Este metodo implementa un bucle for en el que 
		 * llama al metodo mostrarMensaje para imprimir los 
		 * numeros impares del 0 al 100
		 */
		private static void ejecutar() {
			for(int i=0; i<=100; i++) {
				if(i%2!=0) {
					mostrarMensaje(""+i);
				}
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
