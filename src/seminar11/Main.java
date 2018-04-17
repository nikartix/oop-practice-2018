package seminar11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	private static final String DATABASE_SERVER = "mysql-rfam-public.ebi.ac.uk";
	private static final int DATABASE_PORT = 4497;
	private static final String DATABASE_USERNAME = "rfamro";
	private static final String DATABASE_PASSWORD = "";
	private static final String DATABASE_SCHEMA_NAME = "Rfam";
	
	private static final String JDBC_DATABASE_URL = "jdbc:mysql://" + DATABASE_SERVER + ":" + DATABASE_PORT;
	
	private Connection conn;
	
	public Main() {
		try {
			Class.forName("com.mysql.jdbc.Driver");		// Called to just initialize JDBC driver
			conn = DriverManager.getConnection(JDBC_DATABASE_URL, // Connect to database
					DATABASE_USERNAME, DATABASE_PASSWORD);
			
			Statement stmt = conn.createStatement();
			stmt.execute("USE " + DATABASE_SCHEMA_NAME);
			
			messWithConnection();
			
			System.out.println("==============");
			System.out.println(getAutorDescription("Bateman A"));
			
			conn.close();
		} catch (ClassNotFoundException e) {
			// No com.mysql.jdbc.Driver class found in classpath
			e.printStackTrace();
		} catch (SQLException e) {
			// There is a driver but something went wrong while astablishing connection,
			//   e.g. username or password is wrong, or server url is not correct.
			e.printStackTrace();
		}
		
	}
	
	private void messWithConnection() throws SQLException {
		Statement stmt = conn.createStatement();

		ResultSet set = stmt.executeQuery("SELECT author, description FROM family LIMIT 10");
		
		while (set.next()) {
			System.out.println("--------------------------");
			System.out.println(set.getString("author"));
			System.out.println(set.getString("description"));
		}
	}
	
	private String getAutorDescription(String authr) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT description FROM family WHERE author = ? LIMIT 1");
		pstmt.setString(1, authr);
		
		ResultSet set = pstmt.executeQuery();
		if (set.next()) {
			return set.getString(1);
		} else {
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
