package aeropuerto;

public class SimpleAvionesLinkedList {
	private Avion first;
	private int size;
	private Avion last;
	
	public SimpleAvionesLinkedList() {
		this.first = null;
		this.size = 0;
	}

	public SimpleAvionesLinkedList(Avion first) {
		this.first = first;
		this.last = first;
		this.size = 1;
	}

	public Avion getFirst() {
		return first;
	}

	public void setFirst(Avion first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public Avion getLast() {
		return last;
	}

	public void setLast(Avion last) {
		this.last = last;
	}
	/*
	 * Pre: ---
	 * Post: Añade un nodo a la lista, en la última posición de esta.
	 */
	public boolean add(Avion node){
		try {
			if(size == 0) {
				first = node;
				last = node;
			} else {
//				Node p = first;
//				for(int i = 1; i < size; i++) p = p.getNext();
//				p.setNext(node);
				last.setNext(node);
				last = node;
			} size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: El valor de position se encuentra entre 0 y size, incluidos.
	 * Post: Añade un nodo en la posición indicada.
	 */
	public boolean add(int position, Avion node) {
		try {
			if (position<0 || position > (size)) return false;
			else if(position == 0) {
				node.setNext(first);
				first = node;
			} else if(position == size) { 
				return add(node);
			} else {
				Avion p = first;
				for(int i = 1; i < position; i++) p = p.getNext();
				node.setNext(p.getNext());
				p.setNext(node);
			} size++;
			return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	/*
	 * Pre: El índice debe estar entre 0 y size-1, incluidos. La lista no debe estar vacía.
	 * Post: Elimina el nodo en la posición indicada.
	 */
	public boolean delete(int indice) {
		try {
			if(size == 0) {
				System.out.println("La lista está vacía");
				return false;
			}
			else if (indice<0 || indice > (size-1)) {
				System.out.println("El índice no es correcto");
				return false;
			}
			else if(indice == 0) first = first.getNext();
			else if(indice == size-1) {
				Avion p = first;
				for(int i = 1; i < indice; i++) p = p.getNext();
				p.setNext(null);
				last = p;
			}else {
				Avion p = first;
				for(int i = 0; i < indice-1; i++) p = p.getNext();
				p.setNext(p.getNext().getNext());
			}size--;
			return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Devuelve el nodo que se encuentra en la posición indicada de la lista.
	 */
	public Avion get(int position) {
		try {
			if(isEmpty()) return null;
			else if(position<0 || size<=position) return null;
			else if(position == 0) return first;
			else if (position ==(size-1)) return last;
			else {
				Avion p = first;
				for(int i = 1; i <= position; i++) p = p.getNext();
				return p;
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}return null;
	}
	
	/*
	 * Pre: ---
	 * Post: Devuelve true si la lista está vacía, o false si no lo está.
	 */
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}
	
	/*
	 * Pre: ---
	 * Post: muestra el contenido de los elementos de la lista
	 */
	public void show() {
		Avion p = first;
		for (int i = 1; i<=size; i++) {
			System.out.println("[" +i + "] -> " + p.toString());
			p = p.getNext();
		}
	}
}
