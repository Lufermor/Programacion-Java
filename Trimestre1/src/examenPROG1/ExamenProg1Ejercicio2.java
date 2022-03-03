package examenPROG1;
/*
 * Esta clase java, dada una lista de fechas en un formato especifico, comprueba 
 * si las fechas en la lista son validas
 */

public class ExamenProg1Ejercicio2 {
	/*
	 * Pre: ---
	 * Post: Este metodo recorre las fechas en una lista, se apoya en el 
	 * metodo esValido para comprobar si son fechas reales, y luego las imprime
	 * señalando si son correctas o no. 
	 */
	public static void comprobarFechas(String[] t) {
		for(int i = 0; i<t.length; i++) {
			int dia = Integer.parseInt(t[i].substring(0, 2));
			int mes = Integer.parseInt(t[i].substring(3, 5));
			int anio = Integer.parseInt(t[i].substring(6));
			System.out.print(t[i] + " -> ");
			if(esValido(dia, mes, anio)) {
				System.out.println("OK");
			}else {
				System.out.println("ERROR");
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo devuelve [true] si los datos introducidos (dia, mes, ano) 
	 * se corresponden con una fecha real. En caso contrario, devuelve [false]
	 */
	private static boolean esValido(int dia, int mes, int ano) {
		int maxDias = 0;
		switch(mes) {
			case 1:
				maxDias = 31;
				break;
			case 2:
				if(esBisiesto(ano)) {
					maxDias = 29;
				}else {
					maxDias = 28;
				}
				break;
			case 3:
				maxDias = 31;
				break;
			case 4:
				maxDias = 30;
				break;
			case 5:
				maxDias = 31;
				break;
			case 6:
				maxDias = 30;
				break;
			case 7:
				maxDias = 31;
				break;
			case 8:
				maxDias = 31;
				break;
			case 9:
				maxDias = 30;
				break;
			case 10:
				maxDias = 31;
				break;
			case 11:
				maxDias = 30;
				break;
			case 12:
				maxDias = 31;
				break;
			default:
				return false;
		}
		if(!(0<dia && dia<= maxDias)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Pre: ---
	 * Post: devuelve [true] sí y solo sí el [ano] pasado como
	 * 		parámetro es bisiesto. En caso contrario, devuelve [false].
	 */
	private static boolean esBisiesto(int ano) {
		if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0)))
			return true;
		else
			return false;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main contiene una tabla de fechas, las cuales comprueba 
	 * llamando al metodo comprobarFechas.
	 */
	public static void main(String[] args) {
		String[] t = {"28/02/1995", "28/03/2010", 
				"32/12/1995", "02/01/2019", "29/02/2024"};
		comprobarFechas(t);
	}
}
