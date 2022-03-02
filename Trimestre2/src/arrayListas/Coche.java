package arrayListas;
import java.util.Random;

public class Coche {
	private String color;
	private String matricula;
	private int puertas;
	
	public Coche() {
		color = "Blanco";
		puertas = 4;
		generarMatricula();
	}
	
	public Coche(String color, int puertas) {
		this.color = color;
		this.puertas = puertas;
		generarMatricula();
	}
	
	public Coche(String color, String matricula, int puertas) {
		this.color = color;
		this.puertas = puertas;
		this.matricula = matricula;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public int getPuertas() {
		return puertas;
	}
	
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	
	public void generarMatricula() {
		String matri = "";
		//char[] letras = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Random rand = new Random();
		
		for (int i = 0; i < 7; i++) {
			if(i<4) {
				matri += rand.nextInt(10);
			}else if(i == 4){
				matri += (char)(rand.nextInt(12) + 65);
			}else {
				matri += (char)(rand.nextInt(25) + 65);
			}
		}
		matricula = matri;
	}
	/*
	 * public void generarMatricula() {
		String matri = "";
		char[] letras = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Random rand = new Random();
		
		for (int i = 0; i < 7; i++) {
			if(i<4) {
				matri += rand.nextInt(12);
			}else if(i == 4){
				matri += letras[rand.nextInt(7)];
			}else {
				matri += letras[rand.nextInt(26)];
			}
		}
		matricula = matri;
	}
	 */
	
	@Override
	public String toString() {
		return "Color = " + color + "\nMatricula = " + matricula + 
					"\nPuertas = " + puertas + "\n";
	}
}
