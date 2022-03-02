package tarea4;
//Escribe un programa Java que te muestre 10 veces el texto: "Los bucles son muy sencillos"
public class ForEjercicio1 {
	/*
	 * Pre: ---
	 * Post: Este m�todo imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este llama al m�todo mostrarMensaje 10 veces
	 */
	private static void ejecutar() {
		for(int i=0; i<10; i++) {
			mostrarMensaje((i+1) + ". Los bucles son muy sencillos");
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main llama al m�todo ejecutar
	 */
	public static void main(String[] args) {
		ejecutar();
	}
}
