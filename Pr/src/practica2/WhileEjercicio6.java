package practica2;

public class WhileEjercicio6 {
	/*
	 * Pre: ---
	 * Post: esta clase Java implementa un m�todo main que
	 * muestra los n�meros impares entre 0 y 100 
	 */
	public static void main(String[] args) {
		int i=0;
		while(i<=100) {
			if(i%2!=0) {
				System.out.println(i);
			}
			i++;
		}
	}
}
