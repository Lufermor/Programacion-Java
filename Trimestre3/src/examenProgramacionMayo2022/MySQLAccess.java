package examenProgramacionMayo2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLAccess {
	
	/*
	 * Almacenamos la conexiÛn con nuestra bd en 
	 * un objeto de tipo Connection. La abrimos cuando
	 * queremos empezar a operar con la BD y siempre
	 * debemos cerrarla al finalizar.
	 */
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	/*
	 * Almacena el resultado de las consultas en un dato de 
	 * tipo ResultSet, que tiene sus propios mÈtodos para trabajar
	 * con las tablas y columnas.
	 */
	private ResultSet resultSet = null;
	
	/*
	 * Almacenamos los datos de conexÛn con nuestra BD.
	 */
	final private String host = "localhost:3306/registroDB";
	final private String user = "root";
	final private String passwd = "root";
	
	/*
	 * Pre: ---
	 * Post: guarda en la base de datos un nuevo registro de un personaje
	 */
	public void insertRegistro(String letra, String palabra, int linea) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);

			preparedStatement = connect.prepareStatement("INSERT INTO registro "
					+ "(letra, palabra, linea) VALUES (?, ?, ?)");

			preparedStatement.setString(1, letra);
			preparedStatement.setString(2, palabra);
			preparedStatement.setInt(3, linea);

			System.out.println("INSERT INTO registro "
					+ "(letra, palabra, linea)");
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	
	protected void writeResultSet(String nombreTabla) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?"     + "user=" + user + "&password=" + passwd);
			/*
		    * Creamos statement para que la BD nos permita realizar
		    * consultas
		    */
		   statement = connect.createStatement();
		   /*
		    * Almacenamos en resultTest el resultado de ejecutar la consulta
		    * select.
		    */
		   resultSet = statement
		       .executeQuery("select * from " + nombreTabla.toLowerCase());
		   System.out.println("QUERY ---> select * from " + nombreTabla.toLowerCase());
		   /*
		    * Invocamos al m√©todo escribir, que muestra por pantalla
		    * el resultado de la consulta anterior.
		    */
		   writeResultSet(resultSet);
		}catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
		
	/**
	 * Pre: ---
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		//Nombre de la tabla:
		System.out.println("\t " + resultSet.getMetaData().getTableName(1).toUpperCase());
		//Imprimimos los nombes de las columnas:
		for  (int i = 2; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.print("\t"+ resultSet.getMetaData().getColumnName(i));
		}System.out.println();
		/*
		 * Mientras resultSet contenga m·ss registros, seguimos avanzando
		 * de manera similar a los ficheros de texto.
		 */
		while (resultSet.next()) {

			/*
			 * Podemos seleccionar la columna de la que queremos leer el dato poniendo su
			 * nombre, o tambiÈn indicando su n˙mero de columna...
			 */
			for (int i = 2; i <= resultSet.getMetaData().getColumnCount(); i++) {
				System.out.print("\t" + resultSet.getString(i));
			}System.out.println();
		}
	}

	/**
	 * Pre: ---
	 * Post: cerramos todas las conexiones abiertas, el resultSet
	 * 		y el statement. Si no se cierran correctamente, puede
	 * 		ocurrir que las consultas no devuelvan el resultado esperado.
	 * 		Adem√°s, si dejamos muchas conexiones a la BD abiertas
	 * 		podemos llegar a saturarla y no aceptar√° m√°s conexiones. 
	 */
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			} if (statement != null) {
				statement.close();
			} if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {}
	}

}