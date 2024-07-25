package HotelManagementSystem;

import java.sql.*;

public class conn implements AutoCloseable {

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hotel?useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = ""; // Replace with your actual password

	Connection c;
	Statement s;

	public conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			s = c.createStatement();
		} catch (Exception e) {
			System.err.println("Error connecting to database: " + e.getMessage());
			// You might want to handle the error differently, like displaying an error message
		}
	}

	@Override
	public void close() throws Exception {
		if (s != null) {
			try {
				s.close();
			} catch (SQLException e) {
				System.err.println("Error closing statement: " + e.getMessage());
			}
		}
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				System.err.println("Error closing database connection: " + e.getMessage());
			}
		}
	}

	// Add a method to get the Connection object
	public Connection getConnection() {
		return c;
	}

	public static void main(String[] args) {
	}
}