package com.jdbc.statement.update;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class Insert {
	static Connection con = null;
	
	
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		Statement stmt = null;
		int count = 0;
				
		try {
			
			String query="insert into emp values(1,'sameer','7537864493')";
			stmt=con.createStatement();
			count=stmt.executeUpdate(query);
			
			System.out.println("One row inserted successfully");
		}
		catch(Exception e) {
			System.out.println("Row not inserted");
		}
		finally {
			try {
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
	
}
