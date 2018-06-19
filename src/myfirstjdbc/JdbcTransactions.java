package myfirstjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;



public class JdbcTransactions {
	 JdbcUtility obj= new JdbcUtility();

	 static Connection con=null;
	 static Connection con1=null;
	 public static void main(String[] args) {
		 JdbcUtility obj= new JdbcUtility();
		 
		 con=JdbcUtility.loadAndConnect();
		 con1=JdbcUtility.loadAndConnect();
		 Statement stmt=null;
		 ResultSet rs=null;
		 PreparedStatement pstmt=null;
		 try {
			// con.setAutoCommit(false);  
			 stmt=con.createStatement(); 
			 System.out.println("Transactions using Statement");
			 System.out.println("Printing table emp");
			 String query="Select * from emp";
			 rs=stmt.executeQuery(query);
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
				System.out.println("*************************************");
//				query = "delete from emp where f_name=\"saket\"";
//				 stmt.executeUpdate(query);
//				 query = "delete from emp where f_name=\"sameer\"";
//				 stmt.executeUpdate(query);
			
			 //static query	----> so con.statement(query); used . 
			 stmt.executeUpdate("insert into emp values(4,'sameer','saurabh','7537864493')");  
			 stmt.executeUpdate("insert into emp values(5,'saket','anand','987654311')"); 
			 System.out.println("*************************************");			 
			 // dynamic query ----> so con.preparedStatement(query); used.
//			 System.out.println("Transactions using Prepared Statement");
//			 query="insert into emp "+"values(?,?,?,?)";
//			 pstmt=con1.prepareStatement(query);
//			 System.out.println("Enter your id");
//				int id = JdbcUtility.getInt();
//				System.out.println("Enter your first name");
//				String f_name = JdbcUtility.getString();
//				System.out.println("Enter your last name");
//				String l_name = JdbcUtility.getString();
//				System.out.println("Enter your phone number");
//				String ph_number = JdbcUtility.getString();
//				
//			 pstmt.setInt(1,id);
//			 pstmt.setString(2, f_name);
//			 pstmt.setString(3, l_name);
//			 pstmt.setString(4, ph_number);
//			 
//			 int count=pstmt.executeUpdate();
//			 
//			 System.out.println(count);
			 
			 
			 System.out.println("Printing table after insreting row emp");
			 query="Select * from emp";
			 rs=stmt.executeQuery(query);
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
//				System.out.println();
//				System.out.println("commit/rollback");  
//				String answer=JdbcUtility.getString();  
//				if(answer.equalsIgnoreCase("commit")){  
//				con.commit();  
//				}  insert into emp values(4,'sameer','saurabh','7537864493')
//				if(answer.equalsIgnoreCase("rollback")){  
//				con.rollback();  
//				} 
//				
		//	 con.commit();
			 con.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
}

