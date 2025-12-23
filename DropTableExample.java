package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTableExample {

	private static final String url = "jdbc:mysql://localhost:3306/jfs44";
	private static final String username = "root";
	private static final String password = "Dev@2024";

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement()) {
			String sqlQuery = "DROP TABLE IF EXISTS TEACHER";
			st.executeUpdate(sqlQuery);
			System.out.println("Table Employee deleted succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
