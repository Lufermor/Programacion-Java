package clubesSociales;

//import java.io.File;
import java.util.Scanner;

public class MainClubes {
	
	/*
	 * Pre: ---
	 * Post: Este comprueba si una cadena dada es un numero entero
	 */
	private static boolean esEntero(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: gestiona la selección del usuario, ejecutando la acción adecuada para cada opción
	 */
	public static void laGestion(String opcion, Menu menu, Scanner entrada) {
		if(!esEntero(opcion)) System.out.println("La opción no es correcta");
		else {
			int o = Integer.parseInt(opcion);
			String seleccion = "";
			String nombre = "";
			String primerApellido = "";
			String segundoApellido = "";
			switch(o) {
				case 1:
					System.out.println("Introduzca el nombre del nuevo club: ");
					seleccion = entrada.nextLine();
					if(menu.crearClub(seleccion)) System.out.println("Se ha creado el club: " + seleccion);
					else System.out.println("No se ha podido crear el club.");
					break;
				case 2:
					System.out.println("Introduzca la ruta completa de la carpeta: ");
					seleccion= entrada.nextLine();
					menu.setRutaFicheros(seleccion);
					System.out.println("Carpeta de trabajo cambiada correctamente. ");
					menu.cargarClubes();
					break;
				case 3:
					System.out.println("Escriba el nombre del club que desea seleccionar:");
					seleccion= entrada.nextLine();
					if(menu.elegirClub(seleccion)) System.out.println("Se ha seleccionado el club");
					break;
				case 4: 
					System.out.println("Escriba el nombre del nuevo socio:");
					nombre = entrada.nextLine();
					System.out.println("Escriba el primer apellido:");
					primerApellido = entrada.nextLine();
					System.out.println("Escriba el segundo apellido:");
					segundoApellido = entrada.nextLine();
					menu.altaSocio(nombre, primerApellido, segundoApellido);
					break;
				case 5:
					System.out.println("1. Eliminar por numero de socio\n"
									+ "2. Eliminar por datos de socio");
					seleccion= entrada.nextLine();
					if(esEntero(seleccion)) {
						switch(Integer.parseInt(seleccion)) {
							case 1:
								System.out.println("Escriba el numero del socio que desea eliminar:");
								seleccion= entrada.nextLine();
								if(esEntero(seleccion)) {
									menu.bajaSocio(Integer.parseInt(seleccion)-1);
								}
								break;
							case 2:
								System.out.println("Escriba el nombre del socio a eliminar:");
								nombre = entrada.nextLine();
								System.out.println("Escriba el primer apellido:");
								primerApellido = entrada.nextLine();
								System.out.println("Escriba el segundo apellido:");
								segundoApellido = entrada.nextLine();
								menu.bajaSocio(nombre, primerApellido, segundoApellido);
								break;
							default: 
								System.out.println("Opcion incorrecta.");
								break;
						}
					}else System.out.println("Opción incorrecta");
					break;
				case 6:
					System.out.println("Escriba el nombre del club que desea fusionar:");
					seleccion= entrada.nextLine();
					menu.fusionarClub(seleccion);
					break;
				case 7:
					System.out.println("Escriba el nombre del socio a comprobar:");
					nombre = entrada.nextLine();
					System.out.println("Escriba el primer apellido:");
					primerApellido = entrada.nextLine();
					System.out.println("Escriba el segundo apellido:");
					segundoApellido = entrada.nextLine();
					menu.comprobarPertenencia(nombre, primerApellido, segundoApellido);
					break;
				case 8:
					menu.isClubEmpty();
					break;
				case 9:
					menu.isClubEmpty();
					break;
				case 10:
					menu.visualizarSociosClub();
					break;
				case 11:
					menu.visualizarClubesNombres();
					break;
				case 12:
					menu.visualizarClubes();
					break;
				case 13:
					menu.guardarClubes();
					break;
				case 14:
					System.out.println("Escriba el nombre del club que desea eliminar:");
					seleccion= entrada.nextLine();
					menu.eliminarClub(seleccion);
					break;
				case 0:
					System.out.println("¿Desea guardar los clubes antes de salir? (s/n)");
					seleccion= entrada.nextLine();
					if(seleccion.equalsIgnoreCase("s")) {
						System.out.println("Guardando clubes");
						menu.guardarClubes();
						System.out.println("Hasta luego!");
					}
					else if(seleccion.equalsIgnoreCase("n")) System.out.println("Hasta luego!");
					else {
						System.out.println("Opcion no valida");
						break;
					}
					System.exit(0);
					break;
				default:
					System.out.println("La opción no es correcta");
					break;
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Simula el comportamiento de un sistema de gestión de clubes, 
	 * caracterizados principalmente por un nombre y una lista de socios.
	 */
	public static void main(String[] args) {
		String index = "\nSeleccione una opcion: \n"
				+ "1. \tCrear nuevo club.\n"
				+ "2. \tCargar clubes de una carpeta especifica (cambia la carpeta de trabajo)\n"
				+ "3. \tSeleccionar un club. \n"
				+ "4. \tAgregar un socio a un club seleccionado.\n"
				+ "5. \tEliminar un socio de un club seleccionado.\n"
				+ "6. \tFusionar un club al club seleccionado.\n"
				+ "7. \tConsultar la pertenencia de un socio al club seleccionado.\n"
				+ "8. \tConsultar si el club seleccionado está vacío.\n"
				+ "9. \tConsultar el numero de socios del club seleccionado.\n"
				+ "10. \tVisualizar los socios del club seleccionado.\n"
				+ "11. \tVisualizar los nombres de todos los clubes cargados.\n"
				+ "12. \tVisualizar todos los clubes cargados y sus socios.\n"
				+ "13. \tGuardar los clubes cargados en disco.\n"
				+ "14. \tEliminar un club.\n"
				+ "0. \tSalir.";
		Scanner entrada = new Scanner(System.in);
//		Club club1 = new Club("club1");
//		club1.add(new Socio("Luis", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Juan", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Juan", "Perez", "Zabala", "club1"));
//		club1.add(new Socio("Juan", "Acosta", "Perez", "club1"));
//		club1.add(new Socio("Juan", "Perez", "Garcia", "club1"));
//		club1.add(new Socio("Luis", "Garcia", "Garcia", "club1"));
//		club1.add(new Socio("Melisa", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Diego", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Ana", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Luis", "Perez", "Garcia", "club1"));
//		club1.add(new Socio("Amelia", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Zuleima", "Perez", "Perez", "club1"));
//		club1.add(new Socio("Ernesto", "Perez", "Perez", "club1"));
//		club1.imprimir();
//		club1.delMember(new Socio("Ernesto", "Perez", "Perez", "club1"));
//		club1.delMember(new Socio("Juan", "Perez", "Perez", "club1"));
//		club1.delMember(new Socio("Amelia", "Perez", "Perez", "club1"));
//		club1.delMember(new Socio("Zuleima", "Perez", "Perez", "club1"));
//		System.out.println("borrados");
//		club1.imprimir();
		Menu menu = new Menu("D:/Documentos/GradosuperiorDAM2021/Programación/Trimestre3/"
							+ "PracticaClubesSociales/FicherosClubes/");
//		menu.guardarClubFichero(club1);
//		menu.cargarClubes();
//		menu.visualizarClubes();
		System.out.println("\nBienvenido al sistema de gestion de clubes");
		while(true) {
			System.out.println(index);
			laGestion(entrada.nextLine(), menu, entrada);
		}
	}
}
