package com.jdbc.preparedstatement.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class Insert {
	static Connection con = null;
	static JdbcUtility ob = new JdbcUtility();
	static PreparedStatement pstmt = null;

	public static void main(String[] args) {
		try {
			con = JdbcUtility.loadAndConnect();
			boolean conStatus = true;
			while (conStatus == true) {
				System.out.println("Enter 1 to insert one row");
				System.out.println("Enter 2 insert multiple row");
				System.out.println("Enter 0 to exit");
				int choice = JdbcUtility.getInt();
				switch (choice) {
				case 1:
					singleInsert();
					break;
				case 2:
					multipleInsert();
					break;
				default: conStatus=false;
				}
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void singleInsert() {
		try {
			int count = 0;
			String query = "insert into student values(?,?,?)";
			pstmt = con.prepareStatement(query);

			System.out.println("Enter student id");
			int id = JdbcUtility.getInt();
			System.out.println("Enter student name");
			String student_name = JdbcUtility.getString();
			System.out.println("Enter student phone number");
			String phone_number = JdbcUtility.getString();
			pstmt.setInt(1, id);
			pstmt.setString(2, student_name);
			pstmt.setString(3, phone_number);

			count = pstmt.executeUpdate();
			
			System.out.println("One row inserted successfully");
		} catch (Exception e) {
			System.out.println("Row not inserted");
		}

	}
	
	static void multipleInsert() {
		try {
			System.out.println("Enter number of rows you want to enter");
			int rows=JdbcUtility.getInt();
			for(int i=1;i<=rows;i++) {
			int count = 0;
			String query = "insert into student values(?,?,?)";
			pstmt = con.prepareStatement(query);

			System.out.println("Enter student id");
			int id = JdbcUtility.getInt();
			System.out.println("Enter student name");
			String student_name = JdbcUtility.getString();
			System.out.println("Enter student phone number");
			String phone_number = JdbcUtility.getString();
			pstmt.setInt(1, id);
			pstmt.setString(2, student_name);
			pstmt.setString(3, phone_number);

			count = pstmt.executeUpdate();

			System.out.println("One row inserted successfully");
		
		}
		}
		 catch (Exception e) {
				System.out.println("Row not inserted");
	}
	}
}
