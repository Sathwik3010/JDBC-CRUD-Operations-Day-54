package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Q_8DeleteSingleRecordDirect {

	private static final String url = "jdbc:mysql://localhost:3306/jfs44";
	private static final String username = "root";
	private static final String password = "Dev@2024";

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement()){
			
			String deleteQuery = "DELETE FROM TEACHER WHERE TNO=3";
			
			int rowsAffected = st.executeUpdate(deleteQuery);
			if(rowsAffected == 1) {
				System.out.println("Record deleted successfully");
			} else {
                System.out.println("Record not found");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
