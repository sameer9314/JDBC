package com.jdbc.statement.delete;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class DeleteOp {
static Connection con = null;
	
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		Statement stmt = null;
		int count = 0;
				
		try {
			String query="drop table emp";
			stmt=con.createStatement();
			count=stmt.executeUpdate(query);
			
			System.out.println("Table Deleted");
		}
		catch(Exception e) {
			System.out.println("Table Not Deleted");
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
