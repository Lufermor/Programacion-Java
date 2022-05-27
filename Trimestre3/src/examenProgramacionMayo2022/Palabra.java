package examenProgramacionMayo2022;

public class Palabra {
	private String letra;
	private String palabra;
	private int nLinea;
	
	public Palabra(String letra, String palabra, int nLinea) {
		super();
		this.letra = letra;
		this.palabra = palabra;
		this.nLinea = nLinea;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public int getnLinea() {
		return nLinea;
	}

	public void setnLinea(int nLinea) {
		this.nLinea = nLinea;
	}

	@Override
	public String toString() {
		return "Registro [letra=" + letra + ", palabra=" + palabra + ", nLinea=" + nLinea + "]";
	}
	
}
