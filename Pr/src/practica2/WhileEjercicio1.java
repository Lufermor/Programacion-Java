package practica2;

public class WhileEjercicio1 {
	/**  
	 * Pre: ---
	 * Post: esta clase Java implementa un método main que 
	 * muetra por pantalla 10 veces la frase 
	 * "Los bucles son muy sencillos"
	 */
	public static void main(String[] args) {
		int i=0; //introducimos una variable índice para el bucle
		while(i<10) {
			i++;
			System.out.println(i + ".Los bucles son muy sencillos");
		}
	}
}
