package regis.dao;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import regis.model.User;
import regis.model.regstuclass;



public class regstudao {
	private String jdbcURL = "jdbc:mysql://remotemysql.com:3306/6dO9xvYDBl";
	private String jdbcUsername = "6dO9xvYDBl";
	private String jdbcPassword = "uBQpS0PirH";

	

	
	private static final String SELECT_ALL_USERS = "select RollNumber,CompanyName from Registrations";
	

	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	

	

	public List<regstuclass> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<regstuclass> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String roll=rs.getString("RollNumber");
				
				String company = rs.getString("CompanyName");
				
				users.add(new regstuclass(roll,company));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	

	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}