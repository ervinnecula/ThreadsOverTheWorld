package codepro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestSqlInj {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	// Database credentials
	static final String USER = "username";
	static final String PASS = "password";

	static final String nickname = "CEVA";
	static final String password = "ALTCEVA";

	public static void checkNickPass(String nickname, String password) {

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			/* SQL INJ*/
			String query = "SELECT * FROM users WHERE nickname = '" + nickname + "' AND password ='" + password + "'";
			boolean rs = stmt.execute(query);
			
			if(rs){
				System.out.println("There is a match");
			}
			
			/* SAFE */
			String query2 = "SELECT * FROM users WHERE nickname = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(query2);
			ps.setString(1, nickname);
			ps.setString(2, password);
			boolean rs2 = ps.execute();

			if(rs2){
				System.out.println("There is a match");
			}


		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
