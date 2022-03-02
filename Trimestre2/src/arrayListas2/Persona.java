package arrayListas2;

public class Persona {
	private String nombre;
	private int edad;
	
	public Persona() {
		nombre = "null";
		edad = 18;
	}
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		comprobarEdad(edad);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		comprobarEdad(edad);
	}
	
	/*
	 * Pre: ---
	 * Post: comprueba que la edad está entre 5 y 100, en cuyo caso introduce el valor por defecto
	 */
	public void comprobarEdad(int edad) {
		if(edad>=5 && edad<=100) this.edad = edad;
		else this.edad = 5;
	}
	
	@Override
	public String toString() {
		return "[Cliente: " + nombre + " edad: " + edad + "]";
	}
}
