package highLevelFiles;

public class Persona {
	private String apellido;
	private String nombre;
	private String dni;
	
	public Persona(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void generarDNI() {
		String n = "";
		for(int i = 0; i < 8; i++) {
			n = n + (int)Math.floor(Math.random()*10);
		}
		int numero = Integer.parseInt(n);
		String caracteres[] = {"T","R","W","A","G","M","Y","F","P","D","X","B",
				"N","J","Z","S","Q","V","H","L","C","K","E"};
		int resto = numero%23;
		String dni = numero + caracteres[resto];
		this.dni = dni;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "Apellido: " + apellido + " - DNI: " + dni;
	}
}