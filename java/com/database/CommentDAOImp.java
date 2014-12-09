package com.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import com.bean.library.Comment;
import com.bean.library.Resource;

public class CommentDAOImp implements  CommentDAO{

	
	public ArrayList<Comment> query_by_fileID(int file_id) throws Exception {
		String sql = "select * from Comment WHERE FileID=?";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<Comment> all = null;
		try
		{
			all = new ArrayList<Comment>();
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    st.setInt(1, file_id);
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				Comment comment = new Comment();
				comment.setsComment(result.getString(3));
				comment.setCommentTime(result.getTimestamp(4));
				all.add(comment);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in CommentDAOImp query ");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}

	
	public boolean insert_comment(int file_id, String content) throws Exception {
		String sql = "insert into Comment(FileID,Content,Comment_time) values (?,?,now())";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		try{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			st.setInt(1, file_id);
			st.setString(2,content);
			st.executeUpdate();
			st.close();
			
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in CommentDAOImp insert_comment");
			
		}
		finally
		{
			conn.close();
		}
		
		return true;
	}

	
	public boolean delete_comment(int comment_id) throws Exception {
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql = "DELETE from Comment WHERE CommentID=?";
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    
			st.setInt(1, comment_id);
			st.executeUpdate();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in CommentDAOImp delete");
			
		}
		finally
		{
			conn.close();
		}	
		
		return true;
	}

	/*
	public static void main(String[] args) throws Exception {
		
		CommentDAOImp a = new CommentDAOImp();
		ArrayList<Comment> s = new ArrayList<Comment>();
		s = a.query_by_fileID(2);
		Iterator it = s.iterator();
		while (it.hasNext())
		{
			Comment user = (Comment) it.next();	
			System.out.println(user.getsComment());
		}
	}
	
	*/
	
}
