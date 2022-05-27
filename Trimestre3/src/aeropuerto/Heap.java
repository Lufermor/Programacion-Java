package aeropuerto;

public class Heap {
	private int size;
	private Pasajero first;
	private Pasajero last;
	
	public Heap() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public Heap(Pasajero first) {
		this.first = first;
		this.last = first;
		this.size = 1;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public Pasajero getFirst() {
		return first;
	}

	public void setFirst(Pasajero first) {
		this.first = first;
	}
	
	public Pasajero getLast() {
		return last;
	}

	public void setLast(Pasajero last) {
		this.last = last;
	}

	/*
	 * Pre: ---
	 * Post: Añade un nodo a la cola, en la última posición de esta.
	 */
	public boolean push(Pasajero Pasajero) {
		try {
			if(isEmpty()) { first = Pasajero; last = Pasajero;
			}else { last.setNext(Pasajero); last = Pasajero;
			}size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: devuelve el primer elemento de la cola, y lo elimina de la cola.
	 */
	public Pasajero pop() {
		try {
			if(isEmpty()) {
				System.out.println("La cola está vacía");
				return null;
			}else {
				Pasajero p = first;
				first = first.getNext();
				size--;
				return p;
			}
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Devuelve true si la pila está vacía, o false si no lo está.
	 */
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}
	
	/*
	 * Pre: ---
	 * Post: muestra el contenido de los elementos de la cola
	 */
	public void show() {
		Pasajero p = first;
		for (int i = 1; i<=size; i++) {
			System.out.println("[" +i + "] -> " + p.toString());
			p = p.getNext();
		}
	}
}
