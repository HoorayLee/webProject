package com.database;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.bean.library.User;
import com.database.*;

public class UserDAOImp implements UserDAO {
	public void insert(User user) throws Exception {
		String sql = "insert into Users (UserID,NickName,Credits,FileNumber,Status,UserType) VALUES (?,?,?,?,?,?)";
		
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		try{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			st.setString(1, user.getsUserID());
			st.setString(2, user.getsNickName());
			st.setInt(3, 0);
			st.setInt(4, 0);
			st.setInt(5, 1);
			st.setInt(6, 0);
			st.executeUpdate();
			st.close();
			
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in UserDAOImp insert");
			
		}
		finally
		{
			conn.close();
		}
		
	}
	public User queryById(String user_id) throws Exception {
		String sql_search = "select * from users where UserID = ?";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		User user = null;
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql_search);
			st.setString(1,user_id);
			ResultSet result= st.executeQuery();
			if(result.next())
			{
				user = new User();
				user.setsUserID(result.getString(1));
				user.setsNickName(result.getString(2));
				user.setiCredit(result.getInt(3));
				user.setiFileNumber(result.getInt(4));
				user.setiStatus(result.getInt(5));
				user.setiUserType(result.getInt(6));
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in UserDAOImp search");
			
		}
		finally
		{
			conn.close();
		}
		
		return user;
	}
	public void update(User user) throws Exception {  //主码不能变   根 据主码检索后进行更新操作
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql = "UPDATE users SET NickName=?,Credits=?,FileNumber=?,Status=?,UserType=? WHERE UserID=?";
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    
			
			st.setString(1,user.getsNickName());
			st.setInt(2, user.getiCredit());
			st.setInt(3, user.getiFileNumber());
			st.setInt(4, user.getiStatus());
			st.setInt(5, user.getiUserType());
			st.setString(6, user.getsUserID());
			
			
			st.executeUpdate();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in UserDAOImp update");
			
		}
		finally
		{
			conn.close();
		}
	}

	public void delete(String user_id) throws Exception {  //根据主码进行删除
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql = "DELETE from users WHERE UserID=?";
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    
			st.setString(1, user_id);
			
			
			st.executeUpdate();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in UserDAOImp delete");
			
		}
		finally
		{
			conn.close();
		}	
	}
	public ArrayList<User> queryAll() throws Exception {
		String sql = "select * from users";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		 ArrayList<User> all = new ArrayList<User>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		   
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				User user = new User();
				user.setsUserID(result.getString(1));
				user.setsNickName(result.getString(2));
				user.setiCredit(result.getInt(3));
				user.setiFileNumber(result.getInt(4));
				user.setiStatus(result.getInt(5));
				user.setiUserType(result.getInt(6));
				all.add(user);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in UserDAOImp search all user");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
		
		
	}
	public  ArrayList<User> queryByLike(String code) throws Exception {
		
		String sql = "select * from users WHERE UserID LIKE? or NickName LIKE?";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<User> all = new ArrayList<User>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    st.setString(1, "%"+code+"%");
		    st.setString(2, "%"+code+"%");
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				User user = new User();
				user.setsUserID(result.getString(1));
				user.setsNickName(result.getString(2));
				user.setiCredit(result.getInt(3));
				user.setiFileNumber(result.getInt(4));
				user.setiStatus(result.getInt(5));
				user.setiUserType(result.getInt(6));
				all.add(user);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in UserDAOImp search by part of information ");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}
	/*
	public static void main(String[] args) throws Exception {
		
		UserDAOImp s = new UserDAOImp();
		
		
		
		/* 模糊查询测试
		ArrayList <User> all = s.queryByLike("郭");
		Iterator it = all.iterator();
		while (it.hasNext())
		{
			User user = (User)it.next();	
			System.out.println(user.getsUserID());
			System.out.println(user.getsNickName());
		}
		*/
		
		/*   全部查询测试
		ArrayList <User> all = s.queryAll();
		Iterator it = all.iterator();
		while (it.hasNext())
		{
			User user = (User)it.next();	
			System.out.println(user.getsNickName());
		}
		*/
	//}

}
	
	




