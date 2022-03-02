package tarea8;
/*
 * Implementa un método Java llamado mayorYmenor, el cual
recibe como parámetro una tabla de Strings y muestra por pantalla el
String con mayor longitud y el String con menor longitud.
 */

public class Tarea8Ejercicio5 {
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de Strings e imprime el de mayor y menor longitud
	 */
	private static void mayorYMenor(String[] tabla) {
		int mas = tabla[0].length();
		int menos = tabla[0].length();
		String mayor = tabla[0];
		String menor = tabla[0];
		for(int i = 1; i < tabla.length; i++) {
			if(tabla[i].length() < menos) {
				menos = tabla[i].length();
				menor = tabla[i];
			}else if(tabla[i].length() > mas) {
				mas = tabla[i].length();
				mayor = tabla[i];
			}
		}
		/* Es posible que haya más de un elemento de longitud maxima o minima,
		 * para esto hacemos las comprobaciones a continuacion:
		 */
		boolean mayorRepetido = false;
		boolean menorRepetido = false;
		for(int j = 1; j < tabla.length; j++) {
			if(tabla[j].length() == menos && !tabla[j].equals(menor)) {
				System.out.println("Hay mas de un elemento con la menor longitud, uno de ellos es: " + tabla[j]);
				menorRepetido = true;
			}else if(tabla[j].length() == mas && !tabla[j].equals(mayor)) {
				System.out.println("Hay mas de un elemento con la mayor longitud, uno de ellos es: " + tabla[j]);
				mayorRepetido = true;
			}
		}
		if(mayorRepetido) {
			System.out.println("El ultimo elemento de mayor longitud es: " + mayor);
		}else {
			System.out.println("El elemento de mayor longitud es: " + mayor);
		}
		if(menorRepetido){
			System.out.println("El ultimo elemento de menor longitud es: " + menor);
		}else {
			System.out.println("El elemento de menor longitud es: " + menor);
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main pone a prueba el metodo mayorYMenor enviandole una tabla de Strings
	 */
	public static void main(String[] args) {
		String[] table = {"1234", "12345", "12", "123456", "1234567", "21", "123", "7654321", "321", "4321", "11", "22", "33", "1238567"};
		mayorYMenor(table);
	}
}
