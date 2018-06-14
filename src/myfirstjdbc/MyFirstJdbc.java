package myfirstjdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Driver;
public class MyFirstJdbc {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		int count=0;
		PreparedStatement pstmt=null;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			String dbUrl="jdbc:mysql://localhost:3306/bridgelabz?useSSL=false";
			con=DriverManager.getConnection(dbUrl,"root","root");
			
			// Retrieving data of user table from database.
			String query="Select * from users";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String age=rs.getString("age");
				String password=rs.getString("password");
				
				System.out.print("\"id\" = "+id+" ");
				System.out.print("\"name\" "+name+" ");
				System.out.print("\"age\" "+age+" ");
				System.out.println("\"password\" "+password);
			}
			
			
			// creating table in database.
			query="create table dept(id int(5),f_name varchar(10),l_name varchar(10),ph_number varchar(10))";
			pstmt= con.prepareStatement(query);
			count=pstmt.executeUpdate();
			
			// inserting values into the table emp.
			System.out.println("Insert values for the emp table ");
			System.out.println("Mention number of rows you want to insert");
			int rows=sc.nextInt();
			while(rows!=0) {
			System.out.println("Enter your id");
			int id=sc.nextInt();
			System.out.println("Enter your first name");
			String f_name=sc.next();
			System.out.println("Enter your last name");
			String l_name=sc.next();
			System.out.println("Enter your phone number");
			String ph_number=sc.next();
			query="insert into emp "+"values(?,?,?,?)";
			pstmt= con.prepareStatement(query);
			pstmt.setInt(1,id);
			pstmt.setString(2,f_name);
			pstmt.setString(3,l_name);
			pstmt.setString(4,ph_number);
			count=pstmt.executeUpdate();
			rows--;
			}
			
			// deleting rows from emp table.
			query="delete from emp where f_name=\"shit\"";
			pstmt=con.prepareStatement(query);
			count=pstmt.executeUpdate();
			System.out.println("Rows affected : "+count);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
