package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.library.User;
import com.mysql.jdbc.Driver;
public class DataBaseConnection {
private final String DBDRIVER  = "com.mysql.jdbc.Driver";
private final String DBURL = "jdbc:mysql://localhost:3306/mydata";
private final String DBUSER = "root";
private final String DBPASSWORD = "13503102626";
private  Connection conn = null;
//public static void main(String[] args) throws Exception {
//	ArrayList<User> titles = new ArrayList<User>();
//	String sql = "select * from users";
//	DataBaseConnection a = new DataBaseConnection();
//    Connection coon = a.getConnection();
//    PreparedStatement st = coon.prepareStatement(sql);
//	ResultSet rs = st.executeQuery();
//	
//	User e = new User();
//		while (rs.next())
//		{
//			
//			e.setsUserID(rs.getString("UserID"));
//			titles.add(e);
//		}
//
//System.out.println(e.getsUserID());
//}
	public DataBaseConnection()throws Exception
	{
		
		try
		{
			
			 Class.forName(DBDRIVER);
			 this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}
		catch(Exception e)
		{
			throw new Exception("Error in DataBaseConnection");
		}
	}
	public Connection getConnection()
	{
		return this.conn;
	}
	public void close()
	{
		
		try {
			this.conn.close();
		    }
		catch(Exception e)
		{
			
		}
	}
	

	
}



