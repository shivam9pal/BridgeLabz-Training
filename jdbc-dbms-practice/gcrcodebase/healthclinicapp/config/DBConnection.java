package week09.gcrcodebase.healthclinicapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String url="jdbc:postgresql://localhost:5432/clinic";
	private static String username="postgres";
	private static String password="Shivam@12345";
	
	public static Connection getConnection() throws SQLException {
		Connection connection=DriverManager.getConnection(url,username,password);
		return connection;
	}
}
