package com.jdbc.preparedstatement.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class Update {
	static Connection con = null;
	static JdbcUtility ob = new JdbcUtility();
	static PreparedStatement pstmt = null;

	public static void main(String[] args) {

		con = JdbcUtility.loadAndConnect();
		try {

			boolean conStatus = true;
			while (conStatus == true) {
				System.out.println("Enter 1 to upadte one row");
				System.out.println("Enter 2 update multiple row");
				System.out.println("Enter 0 to exit");
				int choice = JdbcUtility.getInt();
				switch (choice) {
				case 1:
					singleRowupdate();
					break;
				case 2:
					multipleRowupdate();
					break;
				default:
					conStatus = false;
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

	static void singleRowupdate() {
		try {
			int count = 0;
			String query = "update student set student_name=? where id=?";
			pstmt = con.prepareStatement(query);

			System.out.println("Enter the student name");
			String student_name = JdbcUtility.getString();
			System.out.println("Enter id of student to update name");
			int id = JdbcUtility.getInt();

			pstmt.setString(1, student_name);
			pstmt.setInt(2, id);

			count = pstmt.executeUpdate();

			System.out.println("One row updated successfully");
		} catch (Exception e) {
			System.out.println("Row not updated");
		}
	}

	static void multipleRowupdate() {
		try {
			System.out.println("Enter how many row you want to update");
			int rows = JdbcUtility.getInt();
			int count = 0;
			for (int i = 1; i <= rows; i++) {
				String query = "update student set student_name=? where id=?";
				pstmt = con.prepareStatement(query);

				System.out.println("Enter the student name");
				String student_name = JdbcUtility.getString();
				System.out.println("Enter id of student to update name");
				int id = JdbcUtility.getInt();

				pstmt.setString(1, student_name);
				pstmt.setInt(2, id);

				count = pstmt.executeUpdate();

				System.out.println("One row updated successfully");
			}
		} catch (Exception e) {
			System.out.println("Row not updated");
		}
	}
}
