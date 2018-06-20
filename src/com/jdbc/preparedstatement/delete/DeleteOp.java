package com.jdbc.preparedstatement.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.utility.JdbcUtility;

public class DeleteOp {
static Connection con = null;
	
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		int count = 0;
		PreparedStatement pstmt=null;
				
		try {
			String query="drop table student";
			pstmt=con.prepareStatement(query);
			
			count=pstmt.executeUpdate();
			
			System.out.println("Table Deleted");
		}
		catch(Exception e) {
			System.out.println("Table Not Deleted");
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
