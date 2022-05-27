package clubesSociales;

public class DoubleClubesLinkedList {
	private Club first;
	private int size;
	private Club last;
	
	public DoubleClubesLinkedList() {
		this.first = null;
		this.size = 0;
		this.last = null;
	}

	public DoubleClubesLinkedList(Club first) {
		this.first = first;
		this.last = first;
		this.size = 1;
	}

	public Club getFirst() {
		return first;
	}

	public void setFirst(Club first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public Club getLast() {
		return last;
	}

	public void setLast(Club last) {
		this.last = last;
	}
	/*
	 * Pre: ---
	 * Post: Añade un nodo a la lista, en la última posición de esta.
	 */
	public boolean add(Club club){
		try {
			if(size == 0) {
				first = club;
				last = club;
			} else {
				Club p = first;
				for(int i = 0; i < size; i++) {
					if(p.getNombre().equals(club.getNombre())) {
						System.out.println("El club ya existe!!");
						return false;
					}
					p = p.getNext();
				}
				last.setNext(club);
				club.setPrevious(last);
				last = club;
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
	public boolean add(int position, Club Club) {
		try {
			if (position<0 || position > (size)) return false;
			else if(position == 0) {
				Club.setNext(first);
				first.setPrevious(Club);
				Club.setPrevious(null);
				first = Club;
			} else if(position == size) { 
				return add(Club);
			} else {
				Club p = first;
				for(int i = 1; i < position; i++) p = p.getNext();
				Club.setNext(p.getNext());
				p.getNext().setPrevious(Club);
				Club.setPrevious(p);
				p.setNext(Club);
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
			if(isEmpty()) {
				System.out.println("La lista está vacía");
				return false;
			}
			else if (indice<0 || indice > (size-1)) {
				System.out.println("El índice no es correcto");
				return false;
			}
			else if(indice == 0) {
				first.getNext().setPrevious(null);
				first = first.getNext();
			}else if(indice == size-1) {
//				Club p = first;
//				for(int i = 1; i < indice; i++) p = p.getNext();
//				p.setNext(null);
//				last = p;
				last.getPrevious().setNext(null);
				last = last.getPrevious(); 
			}else {
				Club p = first;
				for(int i = 0; i < indice-1; i++) p = p.getNext();
				p.getNext().getNext().setPrevious(p);
				p.setNext(p.getNext().getNext());
			}size--;
			return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: La lista no debe estar vacía.
	 * Post: Elimina el primer club cuyos nombre coincida con el pasado como parámetro.
	 */
	public boolean delete(String nombre) {
		try {
			if(isEmpty()) {
				System.out.println("No hay ningun club para borrar");
				return false;
			}
			if(first.getNombre().equals(nombre)) {
				first.getNext().setPrevious(null);
				first = first.getNext();
				size--;
				System.out.println("Se ha eliminado el club " + nombre);
				return true;
			}else {
				Club p = first.getNext();
				for(int i = 1; i <= this.size-1; i++) {
					if(p.getNombre().equals(nombre)) {
						p.getPrevious().setNext(p.getNext());
						if(i != this.size-1) p.getNext().setPrevious(p.getPrevious());
						size--;
						System.out.println("Se ha eliminado el club " + nombre);
						return true;
					}
					p = p.getNext();
				}
			}
			System.out.println("Ningun club coincide con el nombre introducido");
			return false;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Devuelve el nodo que se encuentra en la posición indicada de la lista.
	 */
	public Club get(int position) {
		try {
			if(size == 0) return null;
			else if(position<0 || size<=position) return null;
			else if(position == 0) return first;
			else if (position ==(size-1)) return last;
			else {
				Club p = first;
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
		Club p = first;
		System.out.println();
		for (int i = 1; i<=size; i++) {
			System.out.println("\n[" +i + "] -> " + p.toString());
			p.getSocios().show();
			p = p.getNext();
		}
	}
}
