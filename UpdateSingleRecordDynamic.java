package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateSingleRecordDynamic {

	private static final String url="jdbc:mysql://localhost:3306/jfs44";
	private static final String username="root";
	private static final String password="Dev@2024";

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
//			Statement st = con.createStatement();
			Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter Teacher Number to Update:");
			int no=sc.nextInt();
			
			System.out.println("Enter New Teacher Name:");
            String name = sc.next();
            
            System.out.println("Enter Teacher Sal");
            Double sal = sc.nextDouble();
            
            System.out.println("Enter Teacher Address");
            String address = sc.next();
            
            String updateQuery = "UPDATE TEACHER SET TNAME= ?, TSAL=?, TADDR=? WHERE TNO = ?";
            
            PreparedStatement ps = con.prepareStatement(updateQuery);
            
            ps.setString(1, name);
            ps.setDouble(2, sal);
            ps.setString(3, address);
            ps.setInt(4, no);
            
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 1) {
            	System.out.println("Record Updated successfully");
            } else {
            	System.out.println("eacher not found");
            }
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
