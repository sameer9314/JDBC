package com.jdbc.preparedstatement.create;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.utility.JdbcUtility;

public class CreateOp {
	static Connection con = null;
	public static void main(String[] args) {
		con=JdbcUtility.loadAndConnect();
		
		int count = 0;
		PreparedStatement pstmt=null;
		try {
			String query="create table student(id int(5) not null primary key,student_name varchar(20),phone_number varchar(20))";
			pstmt=con.prepareStatement(query);
			
			count=pstmt.executeUpdate();
				System.out.println("Table created");
		}
		catch(Exception e) {
			System.out.println("Table not created");
		}
		finally {
			try {
			if(pstmt!=null) {
				pstmt.close();
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
