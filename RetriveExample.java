package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RetriveExample {

	private static final String url="jdbc:mysql://localhost:3306/jfs44";
	private static final String username = "root";
	private static final String password = "Dev@2024";

	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement()){
			String selectQuery = "select * from teacher";
			ResultSet rs = st.executeQuery(selectQuery);
			System.out.println("TNO/ TNAME/ TSAL/ TADDR");
			System.out.println("----------------------------");
			while(rs.next()) {
				int tno=rs.getInt(1);
				String tname = rs.getString(2);
				double tsal = rs.getDouble(3);
				String taddr =rs.getString(4);
				System.out.println(tno+"\t"+tname+"\t"+tsal+"\t"+taddr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
