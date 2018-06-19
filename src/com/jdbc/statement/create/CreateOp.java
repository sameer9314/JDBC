package com.jdbc.statement.create;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class CreateOp {
	static Connection con = null;
	public static void main(String[] args) {
		con=JdbcUtility.loadAndConnect();
		
		Statement stmt = null;
		int count = 0;
				
		try {
			String query="create table emp(id int(5) not null primary key,user_name varchar(20),phone_number varchar(20))";
			stmt=con.createStatement();
			
			count=stmt.executeUpdate(query);
				System.out.println("Table created");
		}
		catch(Exception e) {
			System.out.println("Table not created");
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
