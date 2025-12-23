package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Q_9DeleteSingleRecordDynamic {

	private static final String url = "jdbc:mysql://localhost:3306/jfs44";
	private static final String username = "root";
	private static final String password = "Dev@2024";

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
				Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter Teacher Number to Delete: ");
			int tno = sc.nextInt();
			
			String deleteQuery = "DELETE FROM TEACHER WHERE TNO=?";
			
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			
			ps.setInt(1, tno);
			int rowsAffected  = ps.executeUpdate();
			
			if(rowsAffected == 1) {
				System.out.println("Record Deleted Successfully");
			} else {
				System.out.println("Teacher not found");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
