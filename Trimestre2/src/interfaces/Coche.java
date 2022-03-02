package interfaces;

public class Coche implements Vehiculo{
	private int velocidad;
	private int plazas;
	private String color;
	protected String[] colores = "blanco, negro, rojo, azul, gris".split(", ");
	
	public Coche() {
		System.out.println("Creando coche con constructor 0");
		this.velocidad = 0;
		this.plazas = 5;
		this.color = "Blanco"; 
	}
	
	public Coche(int plazas, String color) {
		System.out.println("Creando coche con constructor 1");
		this.velocidad = 0;
		this.plazas = plazas;
		this.color = color;
	}
	
	public int getVelocidad() {
		System.out.println("Obteniendo velocidad del coche");
		return velocidad;
	}
	
	public void setVelocidad(int velocidad) {
		System.out.println("Estableciendo velocidad del coche");
		comprobarVelocidad(velocidad);
	}
	
	public int getPlazas() {
		System.out.println("Obteniendo plazas del coche");
		return plazas;
	}
	
	public void setPlazas(int plazas) {
		System.out.println("Estableciendo plazas del coche");
		comprobarPlazas(plazas);
	}
	
	public String getColor() {
		System.out.println("Obteniendo color del coche");
		return color;
	}
	
	public void setColor(String color) {
		System.out.println("Estableciendo color del coche");
		comprobarColor(color);
	}
	
	public String[] getColores() {
		System.out.println("Obteniendo colores disponibles para el coche");
		return colores;
	}
	
	public void setColores(String[] colores) {
		System.out.println("Estableciendo colores disponibles para el coche");
		this.colores = colores;
	}
	
	public String frenar(int cuanto) {
		System.out.println("Frenando: ");
		if(cuanto<0) {
			return "No se puede hacer el cambio\n";
		}
		if(this.velocidad == 0) {
			return "El coche está detenido\n";
		}else if(this.velocidad>0) {
			if(this.velocidad - cuanto >0) {
				this.velocidad -= cuanto;
			}else {
				this.velocidad =0;
				return "El coche se ha detenido\n";
			}
		}else if(this.velocidad<0){
			if(this.velocidad + cuanto<0) {
				this.velocidad += cuanto;
			}else {
				this.velocidad =0;
				return "El coche se ha detenido\n";
			}
		}
		return "La velocidad del coche ha disminuido a " + this.velocidad + "km/h\n";
	}
	
	public String acelerar(int cuanto) {
		System.out.println("Acelerando: ");
		if(cuanto<0 && this.velocidad != 0) {
			return "No se puede hacer el cambio\n";
		}
		if(this.velocidad==0) {
			if(this.velocidad + cuanto > -20 && this.velocidad + cuanto< 350) {
				this.velocidad += cuanto;
			}else {
				return "El coche no puede alcanzar la nueva velocidad \n";
			}
		}else if(this.velocidad>0) {
			if(this.velocidad + cuanto<350) {
				this.velocidad += cuanto;
			}else {
				this.velocidad =350;
				return "Velocidad maxima del coche alcanzada: 350 km/h\n";
			}
		}else {
			if(this.velocidad - cuanto>-20) {
				this.velocidad -= cuanto;
			}else {
				this.velocidad = -20;
				return "Velocidad maxima del coche en marcha atras alcanzada: -20 km/h\n";
			}
		}
		return "La velocidad del coche ha aumentado a " + this.velocidad + "km/h\n";
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
		if(velocidad >= -20 && velocidad <= 350) {
			this.velocidad = velocidad;
		}else {
			this.velocidad = 0;
		}
	}
	/*
	 * Pre: ---
	 * Post: Este metodo comprueba si el dato introducido es valido,
	 * de no serlo, introduce en la variable local el valor por defecto
	 */
	private void comprobarPlazas(int plazas) {
		System.out.println("Comprobando plazas");
		if(plazas >=1 && plazas <= 40) {
			this.plazas = plazas;
		}else {
			this.plazas = 5;
		}
	}
	
	@Override
	public String toString() {
		return "Coche -> [color = " + color + 
				", plazas = " + plazas + ", Velocidad = " + velocidad + "]";
		
	}
}
