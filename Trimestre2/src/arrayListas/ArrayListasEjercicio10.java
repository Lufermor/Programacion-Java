package arrayListas;

import java.util.ArrayList;

/*
 * Implementa un programa Java que unifique dos
ArrayLists de datos String en uno solo.
 */
public class ArrayListasEjercicio10 {
	/*
	 * Pre: ---
	 * Post: Este metodo main crea dos listas de enteros, y luego añade una a la otra
	 */
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		for(int i = 0; i<15; i++) {
			nums.add(i);
			nums2.add(-i);
			System.out.print(i + ", ");
		}
		for(int i = 0; i<nums2.size(); i++) {
			nums.add(nums2.get(i));
		}
		System.out.println("\n"+nums);
		nums.addAll(nums2);
		System.out.println("\n"+nums);
	}
}
