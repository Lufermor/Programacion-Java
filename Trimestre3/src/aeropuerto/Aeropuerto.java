package aeropuerto;

public class Aeropuerto {
	private Heap cola;
	private Stack pila;
	private SimpleAvionesLinkedList aviones;
	
	public Aeropuerto() {
		this.cola = new Heap();
		this.pila = new Stack();
		this.aviones = new SimpleAvionesLinkedList();
	}

	public Aeropuerto(Heap cola, Stack pila, SimpleAvionesLinkedList aviones) {
		this.cola = cola;
		this.pila = pila;
		this.aviones = aviones;
	}

	public Heap getCola() {
		return cola;
	}

	public void setCola(Heap cola) {
		this.cola = cola;
	}

	public Stack getPila() {
		return pila;
	}

	public void setPila(Stack pila) {
		this.pila = pila;
	}

	public SimpleAvionesLinkedList getAviones() {
		return aviones;
	}

	public void setAviones(SimpleAvionesLinkedList aviones) {
		this.aviones = aviones;
	}
	
	/*
	 * Pre: ---
	 * Post: permite la entrada de un pasajero al aeropuerto, si hay espacio
	 */
	public boolean pasajeroCheckIn(Pasajero pasajero) {
		if(cola.getSize()==2 && pila.getSize()==3) {
			System.out.println("El aeropuerto está lleno, no se puede hacer el check-in del pasajero");
			return false;
		}else if(cola.getSize()<2) {
			cola.push(pasajero);
			System.out.println("Se ha añadido al pasajero " + pasajero.getNombre() + " a la cola.");
			return true;
		}else {
			pila.push(pasajero);
			System.out.println("Se ha añadido al pasajero " + pasajero.getNombre() + " a la pila.");
			return true;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: tramita el abordaje de un pasajero a su avión
	 */
	public boolean pasajeroBoarding() {
		if(cola.isEmpty() && pila.isEmpty()) {
			System.out.println("El aeropuerto está vacío, no hay ningún pasajero para abordar.");
			return false;
		}else if(!cola.isEmpty()) {
			Pasajero p = cola.pop();
			p.setNext(null);
			for(int i=0; i<aviones.getSize(); i++) {
				if(aviones.get(i).getId() == p.getAvionID()) {
					aviones.get(i).board(p);
					System.out.println("El pasajero " + p.getNombre() + 
							" ha abordado el avion " + aviones.get(i).getId());
					break;
				}
			} return true;
		}else {
			Pasajero p = pila.pop();
			p.setNext(null);
			for(int i=0; i<aviones.getSize(); i++) {
				if(aviones.get(i).getId() == p.getAvionID()) {
					aviones.get(i).board(p);
					System.out.println("El pasajero " + p.getNombre() + 
							" ha abordado el avion " + aviones.get(i).getId());
					break;
				}
			} return true;
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Muestra los pasajeros que han abordado el avión del que se pasa su id.
	 */
	public void showAvion(int id) {
		for(int i=0; i<aviones.getSize(); i++) {
			if(aviones.get(i).getId() == id) {
				System.out.println(aviones.get(i).toString() + ":");
				aviones.get(i).getPasajeros().show();
				break;
			}
		}
	}
	
	/*
	 * Pre: ---
	 * Post: Imprime las colecciones del aeropuerto
	 */
	public void imprimir() {
		System.out.println(toString());
		System.out.println("Cola:");
		cola.show();
		System.out.println("Pila:");
		pila.show();
		for(int i =0; i< aviones.getSize(); i++) {
			Avion a = aviones.get(i);
			System.out.println(a.toString());
			a.getPasajeros().show();
		}
	}
	
	@Override
	public String toString() {
		return "Aeropuerto [cola= " + cola.getSize() + " pasajeros" + 
						", pila= " + pila.getSize() + " pasajeros"+ 
						", aviones=" + aviones.getSize() + "]";
	}
	
}
