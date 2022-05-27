package heap;

public class Heap {
	private int size;
	private Node first;
	private Node last;
	
	public Heap() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public Heap(Node first) {
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
		
	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}
	
	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	/*
	 * Pre: ---
	 * Post: Añade un nodo a la cola, en la última posición de esta.
	 */
	public boolean push(Node node) {
		try {
			if(isEmpty()) { first = node; last = node;
			}else { last.setNext(node); last = node;
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
	public Node pop() {
		try {
			if(isEmpty()) {
				System.out.println("La cola está vacía");
				return null;
			}else {
				Node p = first;
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
		Node p = first;
		for (int i = 1; i<=size; i++) {
			System.out.println("[" +i + "] -> " + p.getContent());
			p = p.getNext();
		}
	}
}
