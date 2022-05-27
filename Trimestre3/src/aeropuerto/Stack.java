package aeropuerto;

public class Stack {
	private int size;
	private Pasajero last;
	
	public Stack() {
		this.last = null;
		this.size = 0;
	}

	public Stack(Pasajero last) {
		this.last = last;
		this.size = 1;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public Pasajero getLast() {
		return last;
	}

	public void setLast(Pasajero last) {
		this.last = last;
	}
	/*
	 * Pre: ---
	 * Post: Añade un nodo a la pila, en la última posición de esta.
	 */
	public boolean push(Pasajero Pasajero) {
		try {
			if(size == 0) { last = Pasajero;
			}else {
				Pasajero.setNext(last);
				last = Pasajero;
			}size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: devuelve el elemento superior de la pila, y lo elimina de la pila.
	 */
	public Pasajero pop() {
		try {
			if(isEmpty()) {
				System.out.println("La pila está vacía");
				return null;
			}else {
				Pasajero p = last;
				last = last.getNext();
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
	 * Post: muestra el contenido de los elementos de la pila
	 */
	public void show() {
		Pasajero p = last;
		for (int i = 1; i<=size; i++) {
			System.out.println("[" +i + "] -> " + p.toString());
			p = p.getNext();
		}
	}
}
