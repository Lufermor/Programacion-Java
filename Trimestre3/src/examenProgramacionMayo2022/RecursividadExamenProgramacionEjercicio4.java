package examenProgramacionMayo2022;

/*
 * Implementa un método recursivo en Java llamado tablaMultiplicar() que muestre por
 * pantalla la tabla de multiplicar (únicamente de los multiplicadores pares) del número solicitado
 * (hasta multiplicar por 100).
 */
public class RecursividadExamenProgramacionEjercicio4 {
	
	/*
	 * Pre: ---
	 * Post: Muestra por pantalla la tabla de multiplicar del número indicado,
	 * y hasta el factor indicado, pero únicamente con multiplicadores pares. 
	 */
	private static void tablaMultiplicar(int num, int factor) {
		if(factor%2 != 0) factor--;
		if(factor >0) {
			tablaMultiplicar(num, (factor-2));
		}
		System.out.println(num + " * " + factor + " = " + (num*factor));
	}
	
	/*
	 * Pre: ---
	 * Post: Este método main realiza pruebas sobre el método tablaMultiplicar
	 * al método se debe enviar el numero del que se quiere obtener la tabla, 
	 * y el número hasta el cuál se quieren obtener los valores de la multiplicación
	 */
	public static void main(String[] args) {
		tablaMultiplicar(2, 101);
	}

}
