package clubesSociales;

public class DoubleSociosLinkedList {
	private Socio first;
	private int size;
	private Socio last;
	
	public DoubleSociosLinkedList() {
		this.first = null;
		this.size = 0;
		this.last = null;
	}

	public DoubleSociosLinkedList(Socio first) {
		this.first = first;
		this.last = first;
		this.size = 1;
	}

	public Socio getFirst() {
		return first;
	}

	public void setFirst(Socio first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	public Socio getLast() {
		return last;
	}

	public void setLast(Socio last) {
		this.last = last;
	}
	
	/*
	 * Pre: ---
	 * Post: Añade un Socio a la lista, en orden alfabético según su nombre, primer y segundo apellido.
	 */
	public boolean add(Socio socio){
		try {
			if(size == 0) {
				first = socio;
				last = socio;
				socio.setNext(null);
				socio.setPrevious(null);
			} else {
				int n1 = socio.getNombre().compareTo(first.getNombre());
				int a1 = socio.getPrimerApellido().compareTo(first.getPrimerApellido());
				int a2 = socio.getSegundoApellido().compareTo(first.getSegundoApellido());
				boolean agregado = false;
				if((n1<0) || (n1 == 0 && a1 < 0) || (n1 == 0 && a1 == 0 && a2 < 0)) {
					socio.setNext(first);
					first.setPrevious(socio);
					first= socio;
					agregado = true;
				}else {
					Socio p = first;
					for(int i = 1; i < size; i++) {
						p = p.getNext();
						n1 = socio.getNombre().compareTo(p.getNombre());
						a1 = socio.getPrimerApellido().compareTo(p.getPrimerApellido());
						a2 = socio.getSegundoApellido().compareTo(p.getSegundoApellido());
						if((n1<0) || (n1 == 0 && a1 < 0) || (n1 == 0 && a1 == 0 && a2 < 0)) {
							socio.setNext(p);
							socio.setPrevious(p.getPrevious());
							p.getPrevious().setNext(socio);
							p.setPrevious(socio);
							agregado = true;
							break;
						}
					}
				}if(!agregado) {
					last.setNext(socio);
					socio.setPrevious(last);
					socio.setNext(null);
					last = socio;
				}
			} size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: El índice debe estar entre 0 y size-1, incluidos. La lista no debe estar vacía.
	 * Post: Elimina el Socio en la posición indicada.
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
				System.out.println("Se ha eliminado al socio " + first.getNombre()
									+ " del club " + first.getClubName());
				first = first.getNext();
			}else if(indice == size-1) {
				last.getPrevious().setNext(null);
				System.out.println("Se ha eliminado al socio " + last.getNombre()
				+ " del club " + last.getClubName());
				last = last.getPrevious(); 
			}else {
				Socio p = first;
				for(int i = 0; i < indice-1; i++) p = p.getNext();
				p.getNext().getNext().setPrevious(p);
				p.setNext(p.getNext().getNext());
				System.out.println("Se ha eliminado al socio " + p.getNext().getNombre()
				+ " del club " + p.getNext().getClubName());
			}size--;
			return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	/*
	 * Pre: La lista no debe estar vacía.
	 * Post: Elimina el primer socio cuyos parámetros [nombre, primerApellido, segundoApellido, clubName]
	 * coincidan con el objeto pasado como parámetro
	 */
	public boolean delete(Socio socio) {
		try {
			if(isEmpty()) {
				System.out.println("La lista está vacía");
				return false;
			}
			if(first.equals(socio)) {
				first.getNext().setPrevious(null);
				System.out.println("Se ha eliminado al socio " + first.getNombre()
				+ " del club " + first.getClubName());
				first = first.getNext();
				size--;
				return true;
			}else {
				Socio p = first.getNext();
				for(int i = 1; i <= this.size-1; i++) {
					if(p.equals(socio)) {
						p.getPrevious().setNext(p.getNext());
						if(i != this.size-1) p.getNext().setPrevious(p.getPrevious());
						System.out.println("Se ha eliminado al socio " + p.getNombre()
								+ " del club " + p.getClubName());
						size--;
						return true;
					}
					p = p.getNext();
				}
			}
			System.out.println("Ningun socio coincide con el socio introducido");
			return false;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	/*
	 * Pre: ---
	 * Post: Devuelve el socio que se encuentra en la posición indicada de la lista.
	 */
	public Socio get(int position) {
		try {
			if(size == 0) return null;
			else if(position<0 || size<=position) return null;
			else if(position == 0) return first;
			else if (position ==(size-1)) return last;
			else {
				Socio p = first;
				for(int i = 1; i <= position; i++) p = p.getNext();
				return p;
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}return null;
	}

	/*
	 * Pre: ---
	 * Post: Método que comprueba la pertenencia o no de un socio al club, 
	 * devuelve true si pertenece, o false si no pertenece.  
	 */
	public boolean comprobarPertenencia(Socio socio) {
		Socio p = first;
		for(int i = 0; i < size; i++) {
			if(p.equals(socio)) return true;
			p = p.getNext();
		}
		return false;
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
		Socio p = first;
		for (int i = 1; i<=size; i++) {
			System.out.println("[" +i + "] -> " + p.toString());
			p = p.getNext();
		}
	}
}
