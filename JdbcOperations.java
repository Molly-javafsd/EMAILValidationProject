package com.simplilearn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JdbcOperations {
	public static final String DB_URL="jdbc:mysql://localhost:3306/db_1";		//IMP LINE
	public static final String USERNAME="root";
	public static final String PASSWORD="123456";
	public static Connection con=null;
	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.jdbc.Driver"); 														//Step(1)...Register the Vendor Drive
	
	
	con=DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);				//Step(2)...Establish the connection
	if(con!=null) {
		System.out.println("Connection established!!");
	}
	else {
		System.out.println("Check connection details!!");
	}
	

	Statement st=con.createStatement();															//Step(3)...a)STATEMENT..OR..b)PreparedStatement
	
	
//	String sql="insert into department values(3,'ENGG',2)";					//for insert		//Step(4)...execute (CRUD-insert,select,update,delete)
//	String sql1="update department set dname='English' where sid=1";  //for update
//	String sql2="delete from department where did=2";							//for delete
	
//	int row=st.executeUpdate(sql);				                                         //(i)executeUpdate--for insert,update,delete--return type is int rows
//	int row1=st.executeUpdate(sql1);
//	int row2=st.executeUpdate(sql2);
//	if(row>0) {
//		System.out.println("Insertion is successful");
//	}
//	else {
//		System.out.println("Not inserted");
//	}
	
	
	
	                                                                                               //(ii)executeQuery---for select--return type is ResultSet
	String sql3="select * from department";
	ResultSet rs=st.executeQuery(sql3);
	while(rs.next()) {
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  //1,2,3 are column number
	}
	
	
	con.close();																								//Step(5)..Close Connection
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
