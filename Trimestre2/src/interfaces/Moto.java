package interfaces;

public class Moto implements Vehiculo{
	private int velocidad;
	private String color;
	protected String[] colores = "blanco, negro, rojo, azul, gris".split(", ");
	
	public Moto() {
		System.out.println("Creando moto con constructor 0");
		this.velocidad = 0;
		this.color = "Blanco"; 
	}
	
	public Moto(String color) {
		System.out.println("Creando moto con constructor 1");
		this.velocidad = 0;
		this.color = color;
	}
	
	public int getVelocidad() {
		System.out.println("Obteniendo velocidad de la moto");
		return velocidad;
	}
	
	public void setVelocidad(int velocidad) {
		System.out.println("Estableciendo velocidad de la moto");
		comprobarVelocidad(velocidad);
	}
	
	public String getColor() {
		System.out.println("Obteniendo color de la moto");
		return color;
	}
	
	public void setColor(String color) {
		System.out.println("Estableciendo color de la moto");
		comprobarColor(color);
	}
	
	public String[] getColores() {
		System.out.println("Obteniendo colores posibles de la moto");
		return colores;
	}
	
	public void setColores(String[] colores) {
		System.out.println("Estableciendo colores posibles de la moto");
		this.colores = colores;
	}
	
	public String frenar(int cuanto) {
		System.out.println("Frenando: ");
		if(cuanto<0) {
			return "No se puede hacer el cambio\n";
		}
		if(this.velocidad == 0) {
			return "La moto está detenida\n";
		}else{
			if(this.velocidad - cuanto >0) {
				this.velocidad -= cuanto;
			}else {
				this.velocidad =0;
				return "La moto se ha detenido\n";
			}
		}
		return "La velocidad de la moto ha disminuido a " + this.velocidad + "km/h\n";
	}
	
	public String acelerar(int cuanto) {
		System.out.println("Acelerando: ");
		if(cuanto<0) {
			return "No se puede hacer el cambio\n";
		}
		if(this.velocidad + cuanto<350) {
			this.velocidad += cuanto;
		}else {
			this.velocidad =350;
			return "Velocidad maxima de la moto alcanzada: 350 km/h\n";
		}
		return "La velocidad de la moto ha aumentado a " + this.velocidad + "km/h\n";
	}
	
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si la cadena intruducida color se corresponde
	 * con alguno de los permitidos, en caso contrario
	 * introduce en la variable local el color por defecto.
	 */
	private void comprobarColor(String color) {
		System.out.println("Comprobando color");
		this.color = "Blanco";
		for(int i = 0; i < colores.length; i++) {
			if(colores[i].equalsIgnoreCase(color)) {
				this.color = color;
				break;
			}	
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si el dato introducido es valido,
	 * de no serlo, introduce en la variable local el valor por defecto
	 */
	private void comprobarVelocidad(int velocidad) {
		System.out.println("Comprobando velocidad");
		if(velocidad >= 0 && velocidad <= 350) {
			this.velocidad = velocidad;
		}else {
			this.velocidad = 0;
		}
	}
	
	@Override
	public String toString() {
		return "Moto -> [color = " + color + ", Velocidad = " + velocidad + "]";
		
	}
}
