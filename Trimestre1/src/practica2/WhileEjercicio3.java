package practica2;

public class WhileEjercicio3 {
	/*
	 * Pre: ---
	 * Post: esta clase Java implementa un método main que 
	 * muestre únicamente la suma de los números enteros entre 
	 * 50 y 100 (ambos incluidos)
	 */
	public static void main(String[] args) {
		int i=50;
		int suma=0;
		while(i<=100) {
			suma=suma+i;
			i++;
		}
		//int comprobacion= (100*101)/2-(49*50)/2; 
		System.out.println(suma);
		//System.out.println(comprobacion);
	}
}
