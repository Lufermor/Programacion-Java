package recursividad;
//Programar un algoritmo recursivo que permita invertir un número. Ejemplo: Entrada: 123 Salida: 321
public class RecursTarea3Ejercicio1 {
	/*
	 * Pre: el resultado que recibe desde el main, debe ser cero
	 * Post: recibe un entero e invierte la posición de sus dígitos 
	 */
	private static int invertirNumero(int num, int resultado) {
//		System.out.println(num + " a " + resultado);
		if(num/10<1) {
			resultado = 10*resultado +num%10;
			return resultado;
		}else {
			return invertirNumero(((int)(num/10)), 10*resultado +num%10);
		}
	}
	/*
	 * Pre: ---
	 * Post: realiza pruebas sobre el método invertirNumero
	 */
	public static void main(String[] args) {
//		int num = 123450;
		for(int i = 0; i< 10; i++) {
			int num = (int)(Math.random()*10000);
			System.out.println(num + " = " + invertirNumero(num, 0));
		}
	}
}
