package com.jdbc.preparedstatement.read;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class ReadOp {
static Connection con = null;
static JdbcUtility ob = new JdbcUtility();
static PreparedStatement pstmt = null;
static ResultSet rs=null;
	
	public static void main(String[] args) {
		
		con=JdbcUtility.loadAndConnect();
		try {
			boolean conStatus = true;
			while (conStatus == true) {
				System.out.println("Enter 1 to select one row");
				System.out.println("Enter 2 select multiple row");
				System.out.println("Enter 0 to exit");
				int choice = JdbcUtility.getInt();
				switch (choice) {
				case 1:
					singleRowRead();
					break;
				case 2:
					multipleRowRead();
					break;
				default:
					conStatus = false;
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
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	static void singleRowRead() {
		try {
			String query="select * from student where id=?";
			pstmt = con.prepareStatement(query);
			
			System.out.println("Enter id to display row");
			int id=JdbcUtility.getInt();
			
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			int id1=rs.getInt("id");
			String student_name=rs.getString("student_name");
			String phone_number=rs.getString("phone_number");
			
			System.out.print("id : "+id1+", ");
			System.out.print("student name : "+student_name+", ");
			System.out.println("phone number : "+phone_number);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
	static void multipleRowRead() {
		try {
			System.out.println("Enter number of rows you want to see");
			int rows=JdbcUtility.getInt();
			for(int i=1;i<=rows;i++) {
				String query="select * from student where id=?";
				pstmt = con.prepareStatement(query);
				
				System.out.println("Enter id to display row");
				int id=JdbcUtility.getInt();
				
				pstmt.setInt(1,id);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
				int id1=rs.getInt("id");
				String student_name=rs.getString("student_name");
				String phone_number=rs.getString("phone_number");
				
				System.out.print("id : "+id1+", ");
				System.out.print("user_name : "+student_name+", ");
				System.out.println("phone_number : "+phone_number);
			}
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
