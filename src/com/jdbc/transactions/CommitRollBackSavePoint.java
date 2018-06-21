package com.jdbc.transactions;

import java.sql.Connection;
import java.sql.Savepoint;
import java.sql.Statement;

import com.jdbc.utility.JdbcUtility;

public class CommitRollBackSavePoint {
	JdbcUtility obj= new JdbcUtility();

	 static Connection con=null;
	 public static void main(String[] args) {
		 new JdbcUtility();
		 con=JdbcUtility.loadAndConnect();
		 Statement stmt=null;
		 try {
			 String query="insert into student values(1,'sameer','9876543211')";
			 stmt=con.createStatement();
			 stmt.executeUpdate(query);
			 
			 con.setAutoCommit(false);  
			 
			 
			 query="insert into student values(2,'saurabh','9876543211')";
			 stmt.executeUpdate(query);
			 
			 Savepoint savepoint1 = con.setSavepoint("ROWS_DELETED_1");
			 query="delete from student where student_name='saurabh'";
			 stmt.executeUpdate(query);
			 
			 con.setSavepoint();
			 
				System.out.println();
				System.out.println("commit/rollback");  
				String answer=JdbcUtility.getString();  
				if(answer.equalsIgnoreCase("commit")){  
				con.commit();  
				}  
				if(answer.equalsIgnoreCase("rollback")){  
				con.rollback();  
				}
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 try {
				 if(stmt!=null) {
					 stmt.close();
				 }
				 if(con!=null) {
				 con.close();}
			 }catch(Exception e){
				 
			 }
		 }
	}
}
