package com.jdbc.statement.read;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class ReadOp {
	static Connection con = null;
	
	
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		Statement stmt = null;
		int count = 0;
		ResultSet rs=null;
				
		try {
			
			String query="select * from emp";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
			int id=rs.getInt("id");
			String user_name=rs.getString("user_name");
			String phone_number=rs.getString("phone_number");
			
			System.out.print("id : "+id+", ");
			System.out.print("user_name : "+user_name+", ");
			System.out.println("phone_number : "+phone_number);
			}
			
		}
		catch(Exception e) {
			System.out.println("Table Not Found");
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
