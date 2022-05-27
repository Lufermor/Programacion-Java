package examenProgramacionMayo2022;

/*
 * Partiendo de la implementación de una Lista Simple Enlazada vista en clase (con nodos
cuyo contenido sea de tipo entero), diseña un nuevo método llamado eliminarMayor() que se
encargue de eliminar el nodo cuyo contenido tenga el número mayor de la lista.
 */
public class ListaSimpleExamenProgramacionEjercicio3 {
	
	/*
	 * Pre: ---
	 * Post: Elimina el nodo de la lista cuyo contenido (int) sea el mayor de la lista.
	 * Nota: Si existen dos nodos que tienen el mayor valor simultáneamente, el método elimina ambos.
	 */
	private static void eliminarMayor(SimpleLinkedList l) {
		Node p = l.getFirst();
		int mayor = p.getContent();
		for(int i =0; i<l.getSize(); i++) {
			if(p.getContent() > mayor) mayor = p.getContent();
			p = p.getNext();
		}
		System.out.println("Valor mayor = " + mayor);
		p = l.getFirst();
		for(int i =0; i<l.getSize(); i++) {
			if(p==null) break;
			if(p.getContent() == mayor) {
				l.delete(i); 
				i--;
			}
			p = p.getNext();
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Este método main crea una lista enlazada simple, y la rellena con nodos de contenido aleatorio.
	 * A continuación prueba el método eliminarMayor, 
	 * para comprobar en varias rondas que se elimina el nodo de mayor contenido en cada ronda.
	 */
	public static void main(String[] args) {
		SimpleLinkedList l = new SimpleLinkedList();
		for(int i=0; i<10; i++) {
			l.add(new Node(i));
		}
		for(int i=0; i<10; i++) {
			l.add(new Node(i));
		}
//		for(int i=0; i<10; i++) {
//			l.add(new Node((int)(Math.random()*100)));
//		}
		l.show();
		for(int i = 0; i<5; i++) {
			System.out.println();
			eliminarMayor(l);
			l.show();
		}
		
	}

}
