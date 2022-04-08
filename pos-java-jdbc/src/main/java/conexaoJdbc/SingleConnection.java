package conexaoJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 * 
 * @author A classe SingleConnection conecta o projeto java com banco de dados
 *         (sql)
 *
 */
public class SingleConnection {

	private static String url = "jdbc:postgresql://localhost:5432/javaJdbc";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	

	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {

		try {

			// verificação da conexão projeto java ao banco de dados (sql)
			if (connection == null) {

				// Carrega o drive do sgdb (postgresql)
				Class.forName("org.postgresql.Driver");
				// conecta o drive do postgresql ao projeto java desde que a url, usuário e
				// password esteja corretos
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				// Envia mensagem ao console de conexão ao banco de dados
				
				String status = "Conectado ao SQL";
				
				JOptionPane.showMessageDialog(null, status);

			}

		} catch (Exception e) {
			
			e.printStackTrace();

		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
