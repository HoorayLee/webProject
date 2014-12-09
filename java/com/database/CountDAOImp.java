package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountDAOImp {
	public int getCount()throws Exception{
		String sql = "SELECT number FROM count ";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ResultSet rs=null;
		int number=0;
		try{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			rs=st.executeQuery(sql);
			st.close();
			
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp insert");
			
		}
		finally
		{
			conn.close();
		}
		
		while(rs.next()){
			number=rs.getInt(1);
		}
		
		return number;
	}
}
