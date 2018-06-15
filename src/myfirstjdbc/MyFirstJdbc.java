package myfirstjdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;

public class MyFirstJdbc {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		PreparedStatement pstmt = null;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			String dbUrl = "jdbc:mysql://localhost:3306/bridgelabz?useSSL=false";
			con = DriverManager.getConnection(dbUrl, "root", "root");
			stmt=con.createStatement();
		
			//Database meta data
			System.out.println("Database meta data");
			DatabaseMetaData dbmd=con.getMetaData();  
			  
			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			System.out.println();
			
			// printing all database name.
			System.out.println("Databases names : ");
			String query = "show databases";
			rs=stmt.executeQuery(query);
			System.out.println();
			
			while(rs.next()) {
			String database_name = rs.getString(1);
			System.out.println(database_name);
			}
			System.out.println();
			
			
			// Retrieving data of user table from database.
		    query = "Select * from users";
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();  
			
			//result set meta data
			System.out.println("ALl tabel name in database");
			while(rs.next()) {
			System.out.println(rsmd.getTableName(1));
			//System.out.println(rsmd.getTableName(2));
//			System.out.println(rsmd.getTableName(3));
//			System.out.println(rsmd.getTableName(4));
			}
			System.out.println();
			
			System.out.println("Printing meta data of user table");
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1)); 
			System.out.println("Column Name of 2nd column: "+rsmd.getColumnName(2)); 
			System.out.println("Column Name of 3rd column: "+rsmd.getColumnName(3)); 
			System.out.println("Column Name of 4th column: "+rsmd.getColumnName(4)+"\n"); 
			
			System.out.println("Printing type of meta data of user table");
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
			System.out.println("Column Type Name of 2nd column: "+rsmd.getColumnTypeName(2));
			System.out.println("Column Type Name of 3rd column: "+rsmd.getColumnTypeName(3));
			System.out.println("Column Type Name of 4th column: "+rsmd.getColumnTypeName(4)+"\n");
			
			System.out.println("Printing all rows of user table");
			query = "Select * from users";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String password = rs.getString("password");

				System.out.print("\"id\" = " + id +", ");
				System.out.print("\"name\" =" + name +", ");
				System.out.print("\"age\" =" + age +", ");
				System.out.println("\"password\" =" + password);
			}
			System.out.println();
			
			System.out.println("Calling stored procedure printrow :");
			CallableStatement callstmt=con.prepareCall("{call printrow()}");
			rs=callstmt.executeQuery();
			while(rs.next()) {
			int id=rs.getInt("id");
			String fname=rs.getString("f_name");
			String lname=rs.getString("l_name");
			String ph_number=rs.getString("ph_number");
			System.out.print("id = "+id+", ");
			System.out.print("fname = "+fname+", ");
			System.out.print("lname = "+lname+", ");
			System.out.println("ph_number = "+ph_number);
		}
 			// creating table in database.
//			query = "create table dept(id int(5),f_name varchar(10),l_name varchar(10),ph_number varchar(10))";
//			pstmt = con.prepareStatement(query);
//			count = pstmt.executeUpdate();
//
//			// inserting values into the table emp.
//			System.out.println("Insert values for the emp table ");
//			System.out.println("Mention number of rows you want to insert");
//			int rows = sc.nextInt();
//			while (rows != 0) {
//				System.out.println("Enter your id");
//				int id = sc.nextInt();
//				System.out.println("Enter your first name");
//				String f_name = sc.next();
//				System.out.println("Enter your last name");
//				String l_name = sc.next();
//				System.out.println("Enter your phone number");
//				String ph_number = sc.next();
//				query = "insert into emp " + "values(?,?,?,?)";
//				pstmt = con.prepareStatement(query);
//				pstmt.setInt(1, id);
//				pstmt.setString(2, f_name);
//				pstmt.setString(3, l_name);
//				pstmt.setString(4, ph_number);
//				count = pstmt.executeUpdate();
//				rows--;
//			}

			// deleting rows from emp table.
//			query = "delete from emp where f_name=\"shit\"";
//			pstmt = con.prepareStatement(query);
//			count = pstmt.executeUpdate();
//			System.out.println("Rows affected : " + count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
