package com.jdbc.statement.update;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class Delete {
static Connection con = null;
	
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		Statement stmt = null;
		int count = 0;
				
		try {
			String query="delete from emp where id=1";
			stmt=con.createStatement();
			count=stmt.executeUpdate(query);
			
			System.out.println("One row deleted successfully");
		}
		catch(Exception e) {
			System.out.println("Row not deleted");
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
