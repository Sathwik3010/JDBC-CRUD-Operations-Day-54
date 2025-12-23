package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Q_10DeleteMultipleRecords {

	 private static final String url = "jdbc:mysql://localhost:3306/jfs44";
	    private static final String username = "root";
	    private static final String password = "Dev@2024";
	    
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
				Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter number of records to delete: ");
			int n = sc.nextInt();
			
			String DeleteQuery = "DELETE FROM TEACHER WHERE TNO=?";
			
			PreparedStatement ps = con.prepareStatement(DeleteQuery);
			for(int i=0;i<n; i++) {
                System.out.println("Enter Teacher Number to delete "+(i+1)+" record ");
                int no = sc.nextInt();
                ps.setInt(1, no);
                int rowsAffected = ps.executeUpdate();
                
                if(rowsAffected == 1) {
                	 System.out.println("Record deleted successfully");
                } else {
                    System.out.println("Teacher not found");
                }
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
