package calculadora;

import java.util.Scanner;

public class Calculator {
	/*
	 * Pre: ---
	 * Post: Este método imprime por pantalla un mensaje dado
	 */
	private static void mostrarMensaje(String msj) {
		System.out.println(msj);
	}
	/*
	 * Pre: ---
	 * Post: Este metodo le pide un dato al usuario
	 */
	private static String pedirDato(String frase) {
		Scanner entrada = new Scanner(System.in);
		mostrarMensaje(frase);
		return entrada.nextLine();
	}
	/*
	 * Pre: ---
	 * Post: Este comprueba si una cadena dada es un numero
	 */
	private static boolean esNumero(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo suma dos numeros dados
	 */
	private static double suma(double a, double b) {
		return a + b;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo resta dos numeros dados
	 */
	private static double resta(double a, double b) {
		return a - b;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo multiplica dos numeros dados
	 */
	private static double multiplica(double a, double b) {
		return a * b;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo divide dos numeros dados
	 */
	private static double divide(double a, double b) {
		return a / b;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo pide al usuario un numero, comprueba que es numero
	 * y realiza la operacion solicitada. por ultimo devuelve la opcion introducida
	 */
	private static double menu() {
		String opcion = pedirDato("");
		double num = 0;
		String op1 = "";//se declara una variable auxiliar que ayudara en el proceso
		String op2 = "";//se declara una variable auxiliar que ayudara en el proceso
		if(esNumero(opcion)) {
			num = Double.parseDouble(opcion);
			if(num == 1) {//se comprueba la condicion para la operacion suma
				op1 = pedirDato("Introduzca el primer sumando:");
				op2 = pedirDato("Introduzca el segundo sumando:");
				if(esNumero(op1) && esNumero(op2)) {
					mostrarMensaje("El resultado es: " + 
				suma(Double.parseDouble(op1), Double.parseDouble(op2)) + "\n");
				}else {
					mostrarMensaje("Los datos introducidos no son correctos");
				}
			}else if(num == 2) {//se comprueba la condicion para la operacion resta
				op1 = pedirDato("Se realizara una resta de forma numero 1 - numero 2\n"
						+ "Introduzca el primer numero:");
				op2 = pedirDato("Introduzca el segundo numero:");
				if(esNumero(op1) && esNumero(op2)) {
					mostrarMensaje("El resultado es: " +
				resta(Double.parseDouble(op1), Double.parseDouble(op2)) + "\n");
				}else {
					mostrarMensaje("Los datos introducidos no son correctos");
				}
			}else if(num == 3) {//se comprueba la condicion para la operacion multiplicacion
				op1 = pedirDato("Introduzca el primer factor:");
				op2 = pedirDato("Introduzca el segundo factor:");
				if(esNumero(op1) && esNumero(op2)) {
					mostrarMensaje("El resultado es: " +
				multiplica(Double.parseDouble(op1), Double.parseDouble(op2)) + "\n");
				}else {
					mostrarMensaje("Los datos introducidos no son correctos");
				}
			}else if(num == 4) {//se comprueba la condicion para la operacion division
				op1 = pedirDato("Se realizara una division de forma numero 1/numero 2\n"
						+ "Introduzca el primer numero:");
				op2 = pedirDato("Introduzca el segundo numero:");
				if(esNumero(op1) && esNumero(op2)) {
					mostrarMensaje("El resultado es: " +
				divide(Double.parseDouble(op1), Double.parseDouble(op2)) + "\n");
				}else {
					mostrarMensaje("Los datos introducidos no son correctos");
				}
			}else if(num == 5) {//En esta opcion se debe hacer nada 
			}else {
				mostrarMensaje("Esa opcion no esta disponible!\n");
			}
		}else {
			mostrarMensaje("Esa opcion vendra en la proxima actualizacion!\n");
		}
		return num;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo main da la bienvenida al usuario y llama al metodo menu para 
	 * iniciar la calculadora
	 */
	public static void main(String[] args) {
		while(true) {
			mostrarMensaje("¡Bienvenidos a mi primera calculadora!\r\n"
					+ "1.- Sumar\r\n"
					+ "2.- Restar\r\n"
					+ "3.- Multiplicar\r\n"
					+ "4.- Dividir\r\n"
					+ "5.- Salir\r\n"
					+ "-----------------------------------------------------------------------------------------------------------------------------------------------\r\n"
					+ "\n"
					+ "¿Que acccion desea realizar? (Introduzca solo el digito de la accion)");
			if(menu() == 5) {
				break;
			}
		}
	}
}
