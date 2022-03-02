package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que revierta la posición de
todos los elementos de un ArrayList de datos String.
 */
public class ArrayListasEjercicio7 {
	/*
	 * Pre: ---
	 * POst: Este metodo main crea un arrayList, le introduce datos, y luego
	 * mediante un for, invierte el orden de los datos
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i = 0; i<15; i++) {
			nums.add(i);
			System.out.print(i + ", ");
		}
		/*for(int i = 0; i<colores.size(); i++) {
			String e = colores.get(i);
			colores.set(i, colores.get(colores.size()-i-1));
			colores.set(colores.size()-i-1, e);
			System.out.print(colores.get(i)+ ", ");
		}*/
		for(int i = 0, j = nums.size() - 1; i<j; i++) {
			nums.add(i, nums.remove(j));
			System.out.print(nums.get(i) + ", ");
		}
		System.out.println(nums.get(nums.size()-1));
		
	}
}
