package repaso1;

public class Repaso1Ejercicio1 {
	
	/*
	 * Pre: ---
	 * Post: Recibe un string y lo devuelve escrito al revés, mas un índice que va incrementándose
	 */
	private static String invertirCadenaCreciente(String cadena, int i) {
		if(cadena.length()==1) {
			System.out.println("i = " + (i+1));
			return cadena;
		}
		else return cadena.substring(cadena.length()-1)+invertirCadenaCreciente(cadena.substring(0, cadena.length()-1), i+1);
	}
	
	/*
	 * Pre: ---
	 * Post: Recibe un string y lo devuelve escrito al revés, mas un índice que va decrementándose
	 */
	private static String invertirCadenaDecreciente(String cadena, int i) {
		if(cadena.length()==1) {
			System.out.println("i = " + (i-1));
			return cadena;
		}
		else return cadena.substring(cadena.length()-1)+invertirCadenaDecreciente(cadena.substring(0, cadena.length()-1), (i-1));
	}
	
	/*
	 *Pre: ---
	 *Post: Hace pruebas sobre los metodos de invertir cadena, creciente y decreciente 
	 */
	public static void main(String[] args) {
		String cadena = "cadena";
		System.out.println(invertirCadenaCreciente(cadena, 0));
		System.out.println(cadena.length());
		System.out.println(invertirCadenaDecreciente(cadena, cadena.length()));
	}

}
