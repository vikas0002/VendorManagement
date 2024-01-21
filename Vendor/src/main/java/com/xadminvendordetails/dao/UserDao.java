package com.xadminvendordetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xadminvendordeatails.bean;

public class UserDao {
	
	
	
	
		private String jdbcURL = "jdbc:mysql://localhost:3306/bankmanagement?useSSL=false";
		private String jdbcUsername = "root";
		private String jdbcPassword = "Root@123";
		
		
		
		private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES "
				+ " (?, ?, ?);";
		
		
		private static final String SELECT_USER_BY_ID = "select VendorName,BankAccountNo,BankName,Address_line1,Address_line2,City,Country,zip from users where id =?";
		private static final String SELECT_ALL_USERS = "select * from users";
		private static final String DELETE_USERS_SQL = "delete from users where VendorName= ?;";
		private static final String UPDATE_USERS_SQL = "update users set VendorName = ?,BankAccountNo= ?, BankName=? ,Address_line1=?,Address_line2=?,City=?,Country=?,zip=?where VendorName= ?";
		
		
		
		
		public USerDAO() {
		}

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
		
		
		
		public void insertUser(User user) throws SQLException {
			System.out.println(INSERT_USERS_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, user.getVendorName());
				preparedStatement.setString(2, user.getBankAccountNo());
				preparedStatement.setString(3, user.getBankName());
				preparedStatement.setString(4, user.Address_line1());
				preparedStatement.setString(5, user.Address_line2());
				preparedStatement.setString(6, user.City());
				preparedStatement.setString(7, user.Country);
				preparedStatement.setString(8, user.zip);
				
				
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
		
		
		
		
		public User selectUser(String VendorName) {
			User user = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_VendorName);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String name = rs.getString("VendorName");
					String email = rs.getString("BankAccountNo");
					String country = rs.getString("BankName");
					user = new User(VendorName, BankAccountNo, BankName, Address_line1);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
	
			return users;
		}

		public boolean deleteUser(int id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

		public boolean updateUser(User user) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
				System.out.println("updated USer:"+statement);
				statement.setString(1, user.getName());
				statement.setString(2, user.getEmail());
				statement.setString(3, user.getCountry());
				statement.setInt(4, user.getId());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
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


}
