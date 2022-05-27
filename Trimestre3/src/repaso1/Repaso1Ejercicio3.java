package repaso1;

import doubleLinkedList.copy.DoubleLinkedList;
import doubleLinkedList.copy.Node;

/*
 * Dada una lista doblemente enlazada que almacena datos de tipo entero, 
 * con el método añadir() y eliminar(). Diseña un método llamado sePuedeObtener(int numero) que 
 * devuelve true sí y solo sí, el número pasado como parámetro se puede obtener 
 * de la suma de dos de los nodos de la lista. Ejemplo:
 */
public class Repaso1Ejercicio3 {
	
	/*
	 * Pre: ---
	 * Post: comprueba si el numero pasado como parametro se puede obtener como la suma de 
	 * dos elementos de la lista pasada
	 */
	public static boolean comprobarNumero(DoubleLinkedList l, int n) {
		Node p = l.getFirst();
		
		while(p.getNext() != null) {
			Node g = p.getNext();
			if(p.getContent() + g.getContent() ==n) {
				System.out.println("El numero SÍ se puede obtener como suma de dos elementos de la lista");
				return true;
			}
			while(g.getNext() != null) {
				g= g.getNext();
				if(p.getContent() + g.getContent() ==n) {
					System.out.println("El numero SÍ se puede obtener como suma de dos elementos de la lista");
					return true;
				}
			}
			p = p.getNext();
		}
		System.out.println("El numero NO se puede obtener como suma de dos elementos de la lista");
		return false;
	}
	
	/*
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		DoubleLinkedList l = new DoubleLinkedList();
		
		for(int i= 1; i<= 5; i++) l.add(new Node(i*3, null, null));
		l.show();
		comprobarNumero(l, 22);
	}

}
