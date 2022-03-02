package interacciones_1;


public class Moto {
	//Variables:
	String marca;
	String modelo;
	int kilometraje;
	String color;
	
	public Moto(String marca, String modelo, int kilometraje, String color) {
		this.marca = marca;
		this.modelo = modelo;
		this.kilometraje = kilometraje;
		this.color = color;
	}
	
	public String getMarca() {
		return marca;	
	}
	
	public String getModelo() {
		return modelo;	
	}
	
	public int getKilometraje() {
		return kilometraje;	
	}
	
	public String getColor() {
		return color;	
	}
	
	public String toString() { 
	    return("La marca de mi moto es: " + this.getMarca()+ 
	        ".\nPertenece al modelo " +this.getModelo()+
	        ".\nTiene " +this.getKilometraje()+ " Kilometros"+
	        "\nEs de color " + this.getColor()); 
	}
	
	public static void main(String[] args) {
		
	    Moto miMoto = new Moto("Yamaha","Special", 55000, "Negro"); 
	    System.out.println(miMoto.toString());
	    
	 }
}

