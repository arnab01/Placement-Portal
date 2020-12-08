package regis.dao;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import regis.model.company;

public class regisdao {
	private static final String SELECT_ALL_COMPANYS = "select * from sched";
	private static final String DELETE_USERS_SQL = "delete from sched where scid = ?;";
	
    public void registerEmployee(company comp) throws ClassNotFoundException, ParseException {
        String INSERT_USERS_SQL = "insert into sched values(?,?,?,?,?,?)";

        int result = 0;
        //Date d=new SimpleDateFormat("dd/MM/yyyy").parse(comp.getTestdate());
        //Time t=java.sql.Time.valueOf(comp.getTestdate());
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/6dO9xvYDBl","6dO9xvYDBl","uBQpS0PirH");
                
               
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
           
            preparedStatement.setString(1, comp.getTestname());
            preparedStatement.setString(2,comp.getTestdate());
            preparedStatement.setString(3,comp.getStart());
            preparedStatement.setString(4,comp.getEnd());
            preparedStatement.setString(5,comp.getCompanyname());
            preparedStatement.setInt(6,comp.getRoundno());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
             preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
       
    }
    public List<company> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<company> companies = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/6dO9xvYDBl","6dO9xvYDBl","uBQpS0PirH");
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_COMPANYS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int roundno = rs.getInt("roundno");
			
				String testname = rs.getString("testname");
				String testdate = rs.getString("testdate");
				String compname = rs.getString("compname");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				companies.add(new company(compname,testname,testdate,roundno,starttime,endtime));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return companies;
	}

	public boolean deleteUser(int scid) throws SQLException {
		boolean rowDeleted;
		try (Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/6dO9xvYDBl","6dO9xvYDBl","uBQpS0PirH");
				PreparedStatement statement = con.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, scid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;  
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