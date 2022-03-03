package correctorDeErrores;
import java.util.Scanner;

public class CorregirExamen {
	/*
	 * Pre: ---
	 * Post: Este metodo le pide un dato al usuario
	 */
	private static String pedirDato(String frase) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(frase);
		return entrada.nextLine();
	}
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si una cadena introducida es un entero
	 */
	private static boolean esEntero(String a) {
		try {
			Integer.parseInt(a);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo solicita las respuestas de un examen al usuario, y las guarda
	 * en una tabla de un largo que se le especifica; Luego devuelve esa tabla.
	 */
	private static int[] solicitarRespuestas(int largo) {
		String aux;
		boolean romper1 = false;//variable auxiliar que usaremos para romper un bucle
		boolean romper2 = false;
		int[] respuestas = new int[largo];
		while(true) {//Iniciamos un bucle infinito para asegurarnos de que el usuario introduce una respuesta valida
			aux = pedirDato("Seleccione el modo de introducir las respuestas:(introduzca el digito):"
					+ "\n1. Todas juntas(deben ir separadas por espacios)"
					+ "\n2. Una a una");
			switch(aux) {
				case "1":
					romper1 = true;
					while(true) {
						aux = pedirDato("Introduzca las respuestas en orden, separadas por espacios:");
						aux = aux.trim();
						String[] respuestasAux = aux.split("\\s+");//creamos una tabla con los datos introducidos por el usuario
						if(respuestasAux.length != largo) {
							romper2=true;
							System.out.println("Los datos introducidos son incorrectos, "
									+ "recuerde que el numero de respuestas es: " + largo +
									"\nIntentelo de nuevo");
						}else {
							for(int i = 0; i < respuestasAux.length; i++) {
								if(esEntero(respuestasAux[i])) {
									respuestas[i] = Integer.parseInt(respuestasAux[i]);
								}else {
									System.out.println("Los datos introducidos son incorrectos, "
											+ "recuerde que las respuestas deben ser numeros enteros."
											+ "\nIntentelo de nuevo");
									romper2 = true;
									break;
								}
							}
						}
						if(!romper2) {
							break;
						}else {
							romper2 = false;
						}
					}
					break;
				case "2":
					romper1 = true;
					for(int i = 0; i < largo; i++) {
						while(true) {
							aux  = pedirDato("Introduzca la respuesta para la pregunta " + (i+1) 
									+ ", debe ser un numero entero");
							if(esEntero(aux)) {
								respuestas[i] = Integer.parseInt(aux);
								break;
							}else {
								System.out.println("El dato es incorrecto");
							}
						}
					}
					break;
				default:
					System.out.println("La opción es incorrecta");
			}
			if(romper1) {
				break;
			}
		}
		return respuestas;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo recibe una tabla de respuestas correctas, solicita al usuario las
	 * respuestas de un test, las almacena en una tabla, luego compara las tablas y 
	 * muestra por pantalla el número de respuestas correctas y el porcentaje 
	 * de preguntas acertadas; y devuelve el numero de preguntas correctas.
	 */
	private static int puntuarTest(int[] correctas, int preguntas) {
		System.out.println("Vamos a introducir las respuestas del siguiente test.");
		int[] respuestas = new int[preguntas];
		respuestas = comprobarInput(preguntas);
		int aciertos = 0;
		for(int i = 0; i < preguntas; i++) {
			if(respuestas[i] == correctas[i]) {
				aciertos++;
			}
		}
		System.out.println("El numero de preguntas acertadas es: " + aciertos);
		System.out.println("El porcentaje de preguntas acertadas es: " 
		+ (100*aciertos/preguntas) + "%");
		return aciertos;
	}
	/*
	 * Pre: ---
	 * Post: Este metodo llama al metodo solicitarRespuestas para pedir las respuestas
	 * de un test al usuario, luego le muestra al usuario los datos introducidos y le pregunta
	 * si es correcto, el metodo implementa un bucle infinito que se repite hasta 
	 * que el usuario da su visto bueno.
	 */
	private static int[] comprobarInput(int preguntas) {
		String aux;
		int[] respuestas = new int[preguntas];
		while(true) {
			respuestas = solicitarRespuestas(preguntas);//llamamos al metodo para pedir las respuestas correctas
			System.out.println("Las respuestas introducidas son: ");
			for(int i=0; i < preguntas; i++) {
				System.out.println("pregunta nº " + (i+1) +": " + respuestas[i]);
			}
			boolean romper = false;//Variable auxiliar que usaremos para romper un bucle
			while(true) {//Vamos a darle al usuario la oportunidad de rectificar las respuestas
				aux = pedirDato("¿Es correcto? \n(s/n)");
				if(aux.equals("s")) {
					romper = true;
					break;
				}else if(aux.equals("n")) {
					break;
				}else {
					System.out.println("Lo siento, no le he entendido");
				}
			}
			if(romper) {
				break;
			}
		}
		return respuestas;
	}
	/*
	 * Pre: ---
	 * Post:Este metodo main pregunta al usuario por el numero de preguntas de un examen
	 * y sus respuestas, muestra estas respuestas para preguntar al usario si son correctas
	 * y si no lo son se las vuelve a pedir; 
	 */
	public static void main(String[] args) {
		int preguntas = 0;
		String aux;
		while(true) {/*pedimos un dato al usuario y usamos un bucle infito para
		 				asegurarnos de que introduce un dato valido*/
			aux = pedirDato("Introduzca el numero de preguntas");
			if(esEntero(aux)) {
				preguntas = Integer.parseInt(aux);
				break;
			}else {
				System.out.println("El dato es incorrecto");
			}
		}
		int[] respuestasCorrectas = new int[preguntas];
		System.out.println("Primero introduzca las respuestas correctas:");
		respuestasCorrectas = comprobarInput(preguntas);
		int preguntasAcertadas = 0;
		int preguntasTotales = 0;
		System.out.println("A continuacion vamos a calificar los test");
		boolean romper2 = false;//Variable auxiliar que usaremos para romper el bucle
		while(true) {
			preguntasAcertadas += puntuarTest(respuestasCorrectas, preguntas);//llamamos al metodo para puntuar el test
			preguntasTotales += preguntas;
			while(true) {
				aux = pedirDato("¿Desea corregir un nuevo test? \n(s/n)");
				if(aux.equals("s")) {
					break;
				}else if(aux.equals("n")) {
					System.out.println("El numero total de preguntas acertadas es: " + preguntasAcertadas);
					System.out.println("El porcentaje total de preguntas acertadas es: " 
					+ (100*preguntasAcertadas/preguntasTotales) + "%");
					romper2 = true;
					break;
				}else {
					System.out.println("Lo siento, no le he entendido");
					//si el usuario no introduce una respuesta valida, el bucle le vuelve a preguntar
				}
			}
			if(romper2) {
				break;
			}
		}
	}
}
