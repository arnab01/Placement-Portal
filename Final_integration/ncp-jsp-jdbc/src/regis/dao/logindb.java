package regis.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import regis.model.login;
public class logindb {
	 public List<login> login() throws ClassNotFoundException, ParseException {
	        String SELECT_USERS_SQL = "select * from login";
	        List<login> Login = new ArrayList<>();

	       
	        
	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/6dO9xvYDBl","6dO9xvYDBl","uBQpS0PirH");
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.prepareStatement(SELECT_USERS_SQL)) {
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
					
					String username = rs.getString("username");
					String passwrd = rs.getString("passwrd");
					
					Login.add(new login(username,passwrd));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			
			return Login;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
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
