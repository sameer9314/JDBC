package com.jdbc.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class JdbcUtility {
	
	private static Scanner scn = null;

	public JdbcUtility() {
		scn = new Scanner(System.in);
	}
	public static Connection loadAndConnect() {

		Connection con = null;
		Driver driverRef;
		try {

			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			String dbUrl = "jdbc:mysql://localhost:3306/bridgelabzJdbc?useSSL=false";
			con = DriverManager.getConnection(dbUrl, "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	/*****************************************
	 * Generate one Integer
	 *****************************************/
	/**
	 * Function is written to generate one integer number.
	 */
	public static int getInt() {
		try {
			int number = scn.nextInt();
			return number;
		}catch(Exception e) {
			scn.nextLine();
			System.out.println("Invalid type of Input, must be integer Please try again... ");
			return getInt();
		}
		
	}
	
	/****************************************
	 * Generate one String
	 ****************************************/
	/**
	 * Function is written to generate one String.
	 */
	public static String getString() {
		return scn.next();
	}
	
	/**
	 * Function is written to generate one String.
	 */
	public static String getStringLine() {
		return scn.nextLine();
	}

}
