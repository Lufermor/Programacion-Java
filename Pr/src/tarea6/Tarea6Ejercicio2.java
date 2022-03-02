package tarea6;

/*Escribe un programa Java que muestre los números del 1 al 110, con 11
 *números por línea. El programa deberá escribir por pantalla “Coza” en
 *lugar de los números múltiplos de 3, “Loza” en lugar de los números
 *múltiplos de 5, “Woza” en lugar de los números múltiplos de 7 y
 *“CozaLoza” en lugar de los números múltiplos de 3 y 5.
 */
public class Tarea6Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: Este método imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.print(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo implementa un bucle para recorrer numeros e imprimir
	 * por pantalla segun piden los requisitos
	 */
	private static void ejecutar(){
		for(int i = 1; i<=110; i++) {
			if(i%3==0 && i%5==0) {
				mostrarMensaje("CozaLoza ");
			}else if(i%3==0) {
				mostrarMensaje("Coza ");
			}else if(i%5==0) {
				mostrarMensaje("Loza ");
			}else if(i%7==0) {
				mostrarMensaje("Woza ");
			}else {
				mostrarMensaje(i+" ");
			}
			if(i%11==0) {//Esta condicion es la que nos da un salto de linea cada 11 numeros
				mostrarMensaje("\n");
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
