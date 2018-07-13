package fr.epita.iam.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDabases {

	public static void main(String[] args) throws Exception {
		// testConnection();
		final Connection connection = getConnection();
		final PreparedStatement pstmt = connection
				.prepareStatement("INSERT INTO IDENTITIES (IDENTITY_DISPLAYNAME, IDENTITY_EMAIL) VALUES (?, ?)");
		//pstmt.setString(1, "4");
		pstmt.setString(1, "user1");
		pstmt.setString(2, "user1@gmail.com");
		pstmt.execute();
		pstmt.close();
		connection.close();

	}

	
	private static void testConnection() throws Exception {

		final String currentSchema = "";
		final Connection connection = getConnection();
		// Then I should get the "TEST" string in the currentSchema
		if (!currentSchema.equals("TEST")) {
			throw new Exception("problem: connection not operational");
		}
	}

	private static Connection getConnection() throws SQLException {
		// Given this context
		final String url = "jdbc:derby://localhost:1527/testconnection;create=true";
		Connection connection = null;

		// When I connect
		connection = DriverManager.getConnection(url, "test", "test");
		return connection;

	}

}
