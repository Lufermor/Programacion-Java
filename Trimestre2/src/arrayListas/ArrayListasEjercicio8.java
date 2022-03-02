package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que elimine todos los
elementos entre la posición N y M de un ArrayList de datos String.
 */
public class ArrayListasEjercicio8 {
	/*
	 * Pre: ---
	 * Post: Este método main crea una lista de numeros, y luego borra los elementos entre dos posiciones determinadas.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		System.out.println("Lista inicial: ");
		for(int i = 0; i<15; i++) {
			nums.add(i+1);
			System.out.print(i + ", ");
		}
		int n = 5;
		int m = 10;
		if(m>=n && m<nums.size() && n>=0) {
			for(int i = n; i<m-1;i++) {
				nums.remove(n);
			}
		}
		System.out.println("\nLista final: ");
		System.out.println(nums);
	}
}
