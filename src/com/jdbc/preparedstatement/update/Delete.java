package com.jdbc.preparedstatement.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class Delete {
static Connection con = null;
static PreparedStatement pstmt=null;
static JdbcUtility ob = new JdbcUtility();
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		try {
			boolean conStatus = true;
			while (conStatus == true) {
				System.out.println("Enter 1 to delete one row");
				System.out.println("Enter 2 delete multiple row");
				System.out.println("Enter 0 to exit");
				int choice = JdbcUtility.getInt();
				switch (choice) {
				case 1:
					singleRowDelete();
					break;
				case 2:
					multipleRowDelete();
					break;
				default: conStatus=false;
				}
			}
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
	static void singleRowDelete() {
		try {
			int count = 0;
			String query="delete from student where id=?";
			pstmt=con.prepareStatement(query);
			
			System.out.println("Enter the value of id");
			int id=JdbcUtility.getInt();
			pstmt.setInt(1,id);
			
			count=pstmt.executeUpdate();
			
			System.out.println("One row deleted successfully");
		}catch(Exception e) {
			System.out.println("Row not deleted");
		}
	}
	static void multipleRowDelete() {
		try {
			int count = 0;
			System.out.println("Enter number of rows you want to delete");
			int rows=JdbcUtility.getInt();
			for(int i=1;i<=rows;i++) {
			String query="delete from student where id=?";
			pstmt=con.prepareStatement(query);
			
			System.out.println("Enter the value of id");
			int id=JdbcUtility.getInt();
			pstmt.setInt(1,id);
			
			count=pstmt.executeUpdate();
			
			System.out.println("One row deleted successfully");
			}
		}catch(Exception e) {
			System.out.println("Row not deleted");
		}
	}
}
