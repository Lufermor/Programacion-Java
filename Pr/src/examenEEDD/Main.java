package examenEEDD;

public class Main {
	/* Pre: ---
	 * Post: Inicializa el código Java que se encarga de visualizar 
	 * una matriz de 5x5 y mostrar su diagonal principal y secundaria.*/
	public static void main(String[] args) {
		int[][] matriz = new int[5][5];
		OperacionesArrays.inicializar(matriz);
		OperacionesArrays.visualizarMatriz(matriz);
		int[] diagoPrincipal = new int[matriz.length];
		int[] diagoSecundaria = new int[matriz.length];
		//Rellenamos la matriz de 5x5
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz[i].length;j++) {
				if(i==j) {
					diagoPrincipal[i] = matriz[i][j];
				}
				if(i+j == matriz.length-1) {
					diagoSecundaria[i] = matriz[i][j];
				}
			}
		}
		// Mostramos la diagonal principal y secundaria de la matriz 5x5
		System.out.println("\nDiagonal Principal");  
		OperacionesArrays.visualizarArray(diagoPrincipal); 
		System.out.println("\n\nDiagonal Secundaria");
		OperacionesArrays.visualizarArray(diagoSecundaria);
		System.out.println("\n\n");
	}
}
