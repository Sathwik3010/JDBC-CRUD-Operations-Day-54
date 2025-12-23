package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q_1CreateTable {

	private static final String driver= "com.mysql.cj.jdbc.Driver";
	private static final String url ="jdbc:mysql://localhost:3306/jfs44";
	private static final String username = "root";
	private static final String password = "Dev@2024";
	
	public static void main(String[] args) {
		Connection connection=null;
		Statement statement = null;
		
		try {
			//step1 load and register Driver
			Class.forName(driver);
			
			//step2 establish connection
			connection=DriverManager.getConnection(url, username, password);
			
			//step3 prepare statement
			statement=connection.createStatement();
			
			//Step4 prepare and execute our sql query
			String sqlQuery="CREATE TABLE IF NOT EXISTS TEACHER("
					+"TNO INT AUTO_INCREMENT PRIMARY KEY,"
						+"TNAME VARCHAR(50),"
							+"TSAL DECIMAL(10,2),"
								+ "TADDR VARCHAR(30)"+")";
			
			statement.execute(sqlQuery);
			//step5 process result from result reset
			// it is optional while we are performing non select queries
			// it is mandatory while we are performing select operations
			System.out.println("Table Created Succesfully");
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				if(connection != null) {
					try {
						connection.close();
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
	}

}
