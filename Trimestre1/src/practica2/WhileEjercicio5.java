package practica2;

public class WhileEjercicio5 {
	/*
	 * Pre: ---
	 * Post: esta clase Java implementa un método main que
	 * muestra los números pares entre 0 y 100 
	 */
	public static void main(String[] args) {
		int i=0;
		while(i<=100) {
			if(i%2==0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
