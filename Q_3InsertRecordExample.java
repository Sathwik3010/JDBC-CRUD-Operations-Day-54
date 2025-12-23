package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Q_3InsertRecordExample {

	private static final String url = "jdbc:mysql://localhost:3306/jfs44";
	private static final String username = "root";
	private static final String password = "Dev@2024";
	
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				Scanner sc = new Scanner(System.in)){
			System.out.println("Enter number of records to insert: ");
			int noOfRecords = sc.nextInt();
			for(int i=0; i<noOfRecords;i++) {
				System.out.println("Enter Details for record "+(i+1)+" : ");
			System.out.println("Enter Teacher Name: ");
			String name = sc.next();
			System.out.println("Enter Teacher Salary: ");
			double salary = sc.nextDouble();
			System.out.println("Enter Teacher Address: ");
			String address = sc.next();
			
			String insertQuery = "INSERT INTO TEACHER(TNAME, TSAL, TADDR)"
									+"values('"+name+"',"+salary+",'"+address+"')";
			int rowsAffected = st.executeUpdate(insertQuery);
			if(rowsAffected ==1) {
				System.out.println("Record inserted sucessfully");
			} else {
				System.out.println("Record insertion failuer");
			}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
