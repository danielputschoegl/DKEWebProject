package dke.pr.g3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static final String dbUser = "dke83";
	public static final String dbPassword = "dkeproject";

	public static final String connectString = "jdbc:oracle:thin:@140.78.58.1:1521:lehre";

	public static boolean checkUserInformation(String username, String password) {
		Connection con = null;

		ResultSet rset = null;
		PreparedStatement stmt = null;

		try {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			con = DriverManager.getConnection(connectString, dbUser, dbPassword);

			con.setAutoCommit(false);

			try {
				String query = "SELECT * " + "FROM users u " + "WHERE u.username = ? " + "AND u.password = ?";

				stmt = con.prepareStatement(query);

				stmt.setString(1, username);
				stmt.setString(2, password);

				rset = stmt.executeQuery();

				int count = 0;
				while (rset.next()) {
					if (rset.getString("username").equals(username) && rset.getString("password").equals(password)) {
						return true;
					}

					if (count > 0) {
						return false;
					}

					count++;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			} finally {
				if (rset != null) {
					try {
						rset.close();
					} catch (SQLException ignore) {
						ignore.printStackTrace();
						throw ignore;
					}
				}

				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException ignore) {
						ignore.printStackTrace();
						throw ignore;
					}
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ignore) {
			}
		} finally {
			try {
				con.close();
			} catch (SQLException ignore) {
				ignore.printStackTrace();
			}
		}
		return false;
	}
}
