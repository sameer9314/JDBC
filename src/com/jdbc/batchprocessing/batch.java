package com.jdbc.batchprocessing;

import java.sql.Connection;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class batch {
	JdbcUtility obj = new JdbcUtility();

	static Statement stmt = null;
	static Connection con = null;

	public static void main(String[] args) {
		try {

			new JdbcUtility();
			con = JdbcUtility.loadAndConnect();
			stmt = con.createStatement();
			
			String query = "insert into student values(3,'sunil','1234567894')";
			stmt.addBatch(query);
			
			query = "insert into student values(4,'saket','6549735413')";
			stmt.addBatch(query);
			
			stmt.executeBatch();
			
			System.out.println("Row inserted");
		} catch (Exception e) {
			System.out.println("Row not inserted");
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}
	}
}
