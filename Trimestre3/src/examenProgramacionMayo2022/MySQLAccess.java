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
	 * Almacenamos la conexi�n con nuestra bd en 
	 * un objeto de tipo Connection. La abrimos cuando
	 * queremos empezar a operar con la BD y siempre
	 * debemos cerrarla al finalizar.
	 */
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	/*
	 * Almacena el resultado de las consultas en un dato de 
	 * tipo ResultSet, que tiene sus propios m�todos para trabajar
	 * con las tablas y columnas.
	 */
	private ResultSet resultSet = null;
	
	/*
	 * Almacenamos los datos de conex�n con nuestra BD.
	 */
	final private String host = "localhost:3306/registroDB";
	final private String user = "root";
	final private String passwd = "root";
	
	
	/*
	 * Pre: ---
	 * Post: guarda en la base de datos un nuevo registro de un arma
	 */
	public void insertArma(String nombre, int ataque) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);

			preparedStatement = connect.prepareStatement(
					"INSERT INTO miprimervideojuego.armas (damage, nombre) VALUES (?, ?)");

			preparedStatement.setInt(1, ataque);
			preparedStatement.setString(2, nombre);

			System.out.println("QUERY ---> INSERT INTO miprimervideojuego.armas (damage, nombre)");
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	/*
	 * Pre: ---
	 * Post: guarda en la base de datos un nuevo registro de un evento
	 */
	public void insertEvento(String pregunta, String respuesta1, String respuesta2, 
			String consecuencia1, String consecuencia2, int efecto1, int efecto2) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);

			preparedStatement = connect.prepareStatement("INSERT INTO miprimervideojuego.eventos "
					+ "(pregunta, respuesta1, respuesta2, consecuencia1, "
					+ "consecuencia2, consecuencia1_impl, consecuencia2_impl) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, pregunta);
			preparedStatement.setString(2, respuesta1);
			preparedStatement.setString(3, respuesta2);
			preparedStatement.setString(4, consecuencia1);
			preparedStatement.setString(5, consecuencia2);
			preparedStatement.setInt(6, efecto1);
			preparedStatement.setInt(7, efecto2);

			System.out.println("QUERY ---> INSERT INTO miprimervideojuego.eventos"
					+ "(pregunta, respuesta1, respuesta2, consecuencia1, "
					+ "consecuencia2, consecuencia1_impl, consecuencia2_impl)");
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	/*
	 * Pre: ---
	 * Post: guarda en la base de datos un nuevo registro de un personaje
	 */
	public void insertRegistro(String letra, String palabra, int linea) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);

			preparedStatement = connect.prepareStatement("INSERT INTO miprimervideojuego.personajes "
					+ "(nombre, vida, habilidad, descripcion_habilidad, habilidad_impl, "
					+ "tipo_habilidad) VALUES (?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, nombre);
			preparedStatement.setInt(2, vida);
			preparedStatement.setString(3, habilidad);
			preparedStatement.setString(4, descripcionHabilidad);
			preparedStatement.setInt(5, efectoHabilidad);
			preparedStatement.setInt(6, tipoHabilidad);

			System.out.println("QUERY ---> INSERT INTO miprimervideojuego.personajes "
					+ "(nombre, vida, habilidad, descripcion_habilidad, habilidad_impl, "
					+ "tipo_habilidad)");
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}
	
	/*
	 * Pre: ---
	 * Post: guarda en la base de datos un nuevo registro del ranking
	 */
	public void insertRank(String nombre, int puntos) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);

			preparedStatement = connect.prepareStatement(
					"INSERT INTO miprimervideojuego.ranking " + "(nombre, puntos) VALUES (?, ?)");

			preparedStatement.setString(1, nombre);
			preparedStatement.setInt(2, puntos);

			System.out.println("QUERY ---> INSERT INTO miprimervideojuego.ranking " + "(nombre, puntos)");
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
		    * Invocamos al método escribir, que muestra por pantalla
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
		 * Mientras resultSet contenga m�ss registros, seguimos avanzando
		 * de manera similar a los ficheros de texto.
		 */
		while (resultSet.next()) {

			/*
			 * Podemos seleccionar la columna de la que queremos leer el dato poniendo su
			 * nombre, o tambi�n indicando su n�mero de columna...
			 */
			for (int i = 2; i <= resultSet.getMetaData().getColumnCount(); i++) {
				System.out.print("\t" + resultSet.getString(i));
			}System.out.println();
		}
	}
	
	public void readDataBase() throws Exception {
		try {
			/*
			 * Cargamos el driver MySQL que hemos descargado anteriormente.
			 * Cada BD tiene su propio driver, este únicamente es para 
			 * las BD MysSQL.
			 */
			Class.forName("com.mysql.jdbc.Driver");
   
			// Setup the connection with the DB
			/*
			 * Establecemos la conexión con nuestra BD utilizando
			 * los datos de conexión que teníamos almacenados
			 * anteriormente.
			 */
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?"
							+ "user=" + user + "&password=" + passwd );

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
		       .executeQuery("select * from user");
		   System.out.println("QUERY ---> select * from user");
		   /*
		    * Invocamos al método escribir, que muestra por pantalla
		    * el resultado de la consulta anterior.
		    */
		   writeResultSet2(resultSet);
		   /*
		    * Cuando queremos utilizar variables para realizar las consultas y 
		    * además queremos hacerlas de forma más eficiente podemos usar
		    * preparedStatement.
		    */
		   preparedStatement = connect
		       .prepareStatement("insert into user(id, password, username) values (?, ?, ?)");
		   /*
		    * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que 
		    * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set con 
		    * la posición del parametro que estamos colocando y su valor. LAS POSICIONES
		    * EMPIEZAN DESDE 1!.
		    */
		   preparedStatement.setInt(1, 500);
		   preparedStatement.setString(2, "password");
		   preparedStatement.setString(3, "Juan Carlos");
		   //preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		   System.out.println("QUERY ---> insert into user(id, password, username)");
		   preparedStatement.executeUpdate();
		
		   preparedStatement = connect
				   .prepareStatement("SELECT * from user");
		   System.out.println("QUERY ---> select * from user");
		   resultSet = preparedStatement.executeQuery();
		   writeResultSet2(resultSet);
		
		   // Remove again the insert comment
		   preparedStatement = connect
				   .prepareStatement("delete from user where username= ?");
		   preparedStatement.setString(1, "Juan Carlos");
		   preparedStatement.executeUpdate();		
		   System.out.println("QUERY ---> delete from user where");
		   writeResultSet2(resultSet);
		   
		   preparedStatement = connect
				   .prepareStatement("SELECT * from user");
		   System.out.println("QUERY ---> select * from user");
		   resultSet = preparedStatement.executeQuery();
		   writeResultSet2(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
		    close();
		}
	}

	/**
	 * Pre: ---
	 * Post: muestra por pantalla el nombre de la tabla sobre la que se ha ejecutado
	 * 		la consulta, seguido de todas sus columnas. 
	 */
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("The columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		}
	}

	/**
	 * Pre: ---
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeResultSet2(ResultSet resultSet) throws SQLException {
		/*
		 * Mientras resultSet contenga más usuarios, seguimos avanzando
		 * de manera similar a los ficheros de texto.
		 */
		while (resultSet.next()) {
			/*
			 * Podemos seleccionar la columna de la que queremos leer el dato
			 * poniendo su nombre, o también indicando su número de columna...
			 * siempre empezando desde 1!
			 * 				EJ: resultSet.getSTring(2);
			 */
		   int id = resultSet.getInt(1);
		   String username = resultSet.getString(2);
		   String password = resultSet.getString(3);
		   System.out.println("\tID: " + id);
		   System.out.println("\tUsername: " + username);
		   System.out.println("\tPassword: " + password);
		}
	}

	/**
	 * Pre: ---
	 * Post: cerramos todas las conexiones abiertas, el resultSet
	 * 		y el statement. Si no se cierran correctamente, puede
	 * 		ocurrir que las consultas no devuelvan el resultado esperado.
	 * 		Además, si dejamos muchas conexiones a la BD abiertas
	 * 		podemos llegar a saturarla y no aceptará más conexiones. 
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