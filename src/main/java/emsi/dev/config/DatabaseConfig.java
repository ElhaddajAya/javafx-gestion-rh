package emsi.dev.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Connexion JDBC singleton	
public class DatabaseConfig {

	private static final String URL = "jdbc:mysql://localhost:3306/gestion_rh?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("Connexion à la BD resussie!");
			} catch (SQLException e) {
				System.err.println("Erreur MySQL : " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	public static void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
