package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Q_7UpdateMultipleRecords {

	private static final String url="jdbc:mysql://localhost:3306/jfs44";
	private static final String username="root";
	private static final String password="Dev@2024";

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter number of records to update");
			int noOfRecords = sc.nextInt();
            String updateQuery = "UPDATE TEACHER SET TSAL = ?, TADDR = ? WHERE TNO = ?";

            PreparedStatement ps = con.prepareStatement(updateQuery);
			for(int i=0; i<noOfRecords; i++) {
                System.out.println("Enter details for record " + (1+i)+": ");
            System.out.println("Enter Teacher Number: ");
            int tno = sc.nextInt();
            System.out.println("Enter Teacher Salary: ");
            Double salary = sc.nextDouble();
            System.out.println("Enter Teacher Address: ");
            String address = sc.next();
            
            ps.setDouble(1, salary);
            ps.setString(2, address);
            ps.setInt(3, tno);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected ==1) {
				System.out.println("Record Updated sucessfully");
			} else {
				System.out.println("Teacher Not found");
			}
            System.out.println();

			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
