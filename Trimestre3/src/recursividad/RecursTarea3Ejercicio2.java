package recursividad;
/*
 * Programar un algoritmo recursivo que permita sumar los dígitos de un número. 
 * Ejemplo: Entrada: 123 Resultado:6
 */
public class RecursTarea3Ejercicio2 {
	/*
	 * Pre: Al llamar al método desde el main, el valor de [suma] debe ser cero.
	 * Post Suma los dígitos de un número entero
	 */
	private static int sumarDigitos(int num, int suma) {
		if(num/10<1) {
			return suma+num;
		}else {
			return  sumarDigitos((int)(num/10), suma+num%10);
		}
	}
	/*
	 * Pre: ---
	 * Post: realiza pruebas sobre el método sumarDigitos
	 */
	public static void main(String[] args) {
		for(int i = 0; i< 10; i++) {
			int num = (int)(Math.random()*10000);
			System.out.println(num + " = " + sumarDigitos(num, 0));
		}
	}
}
