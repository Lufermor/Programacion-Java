package clasesYObjetos1;
/*
 * Los objetos de esta clase gestionan informacion basica sobre personas.
 */

public class Persona {
	
	private String nombre;
	private int edad;
	private String dni;
	private String sexo;
	private double peso;
	private double altura;
	
	public Persona() {
		this.nombre = "";
		this.edad = -1;
		generarDNI();
		this.sexo = "";
		this.altura = -1;
		this.peso = -1;
	}
	
	public Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		generarDNI();
		this.sexo = sexo;
		this.altura = -1;
		this.peso = -1;
	}
	
	public Persona(String nombre, int edad, String dni, String sexo, double altura, double peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		comprobarSexo(sexo);
		this.altura = altura;
		this.peso = peso;
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
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int calcularIMC() {
		double imc = (peso/(altura*altura));
		if(imc < 20) {
			return -1;
		} else if(imc >= 20 && imc <= 25) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public boolean esMayorDeEdad() {
		if(edad >= 18) {
			return true;
		} return false;
	}
	
	private void comprobarSexo(String sexo) {
		if(!sexo.equalsIgnoreCase("h") && !sexo.equalsIgnoreCase("m")) {
			this.sexo = "H";
		} else {
			this.sexo = sexo;
		}
	}
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + "\nEdad = " + edad + 
					"\nDNI = " + dni + "\nSexo = " + sexo + 
					"\nAltura = " + altura + "\nPeso = " + peso + "\n";
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
}
