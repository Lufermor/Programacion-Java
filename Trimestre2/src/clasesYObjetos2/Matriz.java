package clasesYObjetos2;

public class Matriz {
	private int rows;
	private int columns;
	private int[][] matrix;
	
	public Matriz() {
		rows = 2;
		columns = 2;
		matrix = new int[rows][columns];
	}
	
	public Matriz(int rows, int columns) {
		this.rows = comprobarDato(rows);
		this.columns = comprobarDato(columns);
		matrix = new int[rows][columns];
	}
	
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	/*No se implementan los métodos setter de filas y columnas, 
	 * porque la tabla no puede cambiar sus longitudes una vez creada*/
	
	/*
	 * Pre: tanto x como j pasados como parámetros, deben estar dentro de las dimensiones de la matriz local.
	 * Post: cambia el valor de la matriz en [x][j] por el valor de [element].
	 */
	public void setElement(int x, int j, int element) {
		if((0<=x && x< matrix.length)&& (0<=j && j< matrix[0].length)) matrix[x][j] = element;
	}
	
	/*
	 * Pre: La matriz a sumar debe tener las mismas dimensiones que la matriz actual
	 * Post: Suma todos los elementos de la matriz pasada como parámetro, a la matriz local.
	 */
	public void addMatrix(int[][] matrix) {
		if(matrix.length == this.matrix.length && matrix[0].length == this.matrix[0].length ) {//Comprobamos que tienen las mismas dimensiones
			for(int i = 0; i<matrix.length; i++) {
				for(int j = 0; j<matrix[0].length; j++) {
					this.matrix[i][j] += matrix[i][j];//Sumamos los elementos correspondientes de ambas matrices.
				}
			}
		}else System.out.println("Las matrices no tienen iguales dimensiones, no se puede realizar la operacion.");
	}
	
	/*
	 * Pre: La matriz a sumar debe tener las mismas dimensiones que la matriz actual
	 * Post: multiplica todos los elementos de la matriz pasada como parámetro, con los de la matriz local.
	 */
	public void multMatrix(int[][] matrix) {
		if(matrix.length == this.matrix.length && matrix[0].length == this.matrix[0].length ) {//Comprobamos que tienen las mismas dimensiones
			for(int i = 0; i<matrix.length; i++) {
				for(int j = 0; j<matrix[0].length; j++) {
					this.matrix[i][j] = this.matrix[i][j]*matrix[i][j];//Multiplicamos los elementos correspondientes de ambas matrices.
				}
			}
		}else System.out.println("Las matrices no tienen iguales dimensiones, no se puede realizar la operacion.");
	}
	
	/*
	 * Pre: ---
	 * Post: Comprueba que el dato es positivo, de lo contrario devuelve 2
	 */
	public int comprobarDato(int dato) {
		if(dato>0) return dato;
		else return 2;
	}
}
