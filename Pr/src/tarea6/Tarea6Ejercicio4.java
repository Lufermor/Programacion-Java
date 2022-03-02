package tarea6;
/*
 * Escribe un programa Java que muestre un patron de numeros y asteriscos
 * donde los numeros van reemplazando los asteriscos
 */
public class Tarea6Ejercicio4 {
	/*
	 * Pre: ---
	 * Post:Este metodo main implementa bucles para imprimir el patron deseado
	 */
	public static void main(String[] args) {
		String aux = "1******";
		/*
		System.out.println(aux);
		for(int i = 1; i < 7 ; i++) {
			aux = aux.replaceFirst("\\*", "" + (i+1));
			System.out.println(aux);
		}
		 */
		for(int i = 0; i < 7 ; i++) {
			/*if(i == 6) {
				aux = aux.substring(0,i) + (i+1);
			}else if(aux.charAt(i+1) == '*') {
				aux = aux.substring(0,i) + (i+1) + aux.substring(i+1);
			}*/
			if(aux.charAt(i) == '*') {
				aux = aux.replaceFirst("\\*", "" + (i+1));
			}
			System.out.println(aux);
		}
	}
}
