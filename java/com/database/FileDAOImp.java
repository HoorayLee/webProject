package com.database;

import com.bean.library.*;

import java.awt.List;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

public class FileDAOImp implements FileDAO, Serializable{

	@SuppressWarnings("finally")
	@Override
	public int returnNextUseFileID() throws Exception {
		int nextFileID;
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql = "SELECT MAX(FIleID) FROM file";
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			ResultSet result = st.executeQuery(sql);
			result.next();
			nextFileID = result.getInt(1);
			nextFileID++;
			
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp delete");
			
		}
		finally
		{
			conn.close();
			
		}	
		return nextFileID;
	}
	  
	public void insert(Resource file) throws Exception {
		String sql = "insert into File(FileName,AuthorID,UploadTime,Size,Institute,Grade,CourseName,Description) values (?,?,now(),?,?,?,?,?)";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		try{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			st.setString(1,file.getsFileName());
			st.setString(2, file.getsAuthorID());
			st.setLong(3, file.getlSize());
			st.setString(4,file.getsInstitute());
			st.setInt(5, file.getiGrade());
			st.setString(6,file.getsCourseName());
			st.setString(7, file.getsDescription());
			st.executeUpdate();
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
		
	}
	

	public void delete(int file_id) throws Exception {
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql = "DELETE from File WHERE FileID=?";
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    
			st.setInt(1, file_id);
			
			
			st.executeUpdate();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp delete");
			
		}
		finally
		{
			conn.close();
		}	
		
	}
	  
	
	public void update_DownloadNum(int file_id)
			throws Exception {
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql_query_download = "select DownloadNum from File WHERE FileID = ?";
		String sql = "UPDATE File SET DownloadNum=? WHERE FileID=?";
		int downloadNum ;
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql_query_download);
			st.setInt(1,file_id);
			ResultSet result= st.executeQuery();
			result.next();
			downloadNum  = result.getInt(1);
			st.close();
			conn.close();
			
			downloadNum++;
			conn  = new DataBaseConnection();
			st = conn.getConnection().prepareStatement(sql);
			st.setInt(1,downloadNum);
			st.setInt(2,file_id);
			
			st.executeUpdate();
			st.close();
			
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp update_DownloadNum");
			
		}
		finally
		{
			conn.close();
		}
		
		
		
	}


	public void update_Praise(int file_id) throws Exception {
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql_query_Praise = "select Praise from File WHERE FileID = ?";
		String sql = "UPDATE File SET Praise=? WHERE FileID=?";
		int Praise ;
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql_query_Praise);
			st.setInt(1,file_id);
			ResultSet result= st.executeQuery();
			result.next();
			Praise  = result.getInt(1);
			st.close();
			conn.close();
			
			Praise++;
			conn  = new DataBaseConnection();
			st = conn.getConnection().prepareStatement(sql);
			st.setInt(1,Praise);
			st.setInt(2,file_id);
			
			st.executeUpdate();
			st.close();
			
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp update_Praise");
			
		}
		finally
		{
			conn.close();
		}
		
		
		
	}

	public void update_Criticize(int file_id) throws Exception {
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		String sql_query_Criticize = "select Criticize from File WHERE FileID = ?";
		String sql = "UPDATE File SET Criticize=? WHERE FileID=?";
		int Criticize ;
		try
		{
			
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql_query_Criticize);
			st.setInt(1,file_id);
			ResultSet result= st.executeQuery();
			result.next();
			Criticize  = result.getInt(1);
			st.close();
			conn.close();
			
			Criticize++;
			conn  = new DataBaseConnection();
			st = conn.getConnection().prepareStatement(sql);
			st.setInt(1,Criticize);
			st.setInt(2,file_id);
			
			st.executeUpdate();
			st.close();
			
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp update_Criticize");
			
		}
		finally
		{
			conn.close();
		}
		
		
		
	}



	
	public ArrayList<Resource> query_by_requests(String grade, String className) throws Exception {
		
		String sql = "select * from File WHERE Grade =? and CourseName=?";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<Resource> all = new ArrayList<Resource>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    st.setString(1,grade);
		    st.setString(2,className );
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				Resource file = new Resource();
				file.setsFileName(result.getString(2));
				file.setsAuthorID(result.getString(3));
				file.setdUploadTime(result.getTimestamp(4));
				file.setiDownloadNum(result.getInt(5));
				file.setlSize(result.getLong(6));
				file.setiPraise(result.getInt(7));
				file.setiCriticize(result.getInt(8));
				file.setsInstitute(result.getString(9));
				file.setiGrade(result.getInt(10));
				file.setsCourseName(result.getString(11));
				file.setsDescription(result.getString(12));
				all.add(file);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp search by grade and coursename ");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}

	@Override
	public ArrayList<Resource> query_by_requests_bygrade(String grade)
			throws Exception {
		String sql = "select * from File WHERE Grade =? ";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<Resource> all = new ArrayList<Resource>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    st.setString(1,grade);
		   
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				Resource file = new Resource();
				file.setsFileName(result.getString(2));
				file.setsAuthorID(result.getString(3));
				file.setdUploadTime(result.getTimestamp(4));
				file.setiDownloadNum(result.getInt(5));
				file.setlSize(result.getLong(6));
				file.setiPraise(result.getInt(7));
				file.setiCriticize(result.getInt(8));
				file.setsInstitute(result.getString(9));
				file.setiGrade(result.getInt(10));
				file.setsCourseName(result.getString(11));
				file.setsDescription(result.getString(12));
				all.add(file);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp search by request only grade");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}


	@Override
	public ArrayList<Resource> query_by_requests_byname(String className)
			throws Exception {
		String sql = "select * from File WHERE CourseName=?";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<Resource> all = new ArrayList<Resource>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		   
		    st.setString(1,className );
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				Resource file = new Resource();
				file.setsFileName(result.getString(2));
				file.setsAuthorID(result.getString(3));
				file.setdUploadTime(result.getTimestamp(4));
				file.setiDownloadNum(result.getInt(5));
				file.setlSize(result.getLong(6));
				file.setiPraise(result.getInt(7));
				file.setiCriticize(result.getInt(8));
				file.setsInstitute(result.getString(9));
				file.setiGrade(result.getInt(10));
				file.setsCourseName(result.getString(11));
				file.setsDescription(result.getString(12));
				all.add(file);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp search by request only CourseName");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}
	
	
	public ArrayList<Resource> query_by_authorID(String user_id) throws Exception {
		
		String sql = "select * from File WHERE AuthorID=?";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<Resource> all = new ArrayList<Resource>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
		    st.setString(1,user_id );
			ResultSet result= st.executeQuery();
			while(result.next())
			{
				Resource file = new Resource();
				file.setsFileName(result.getString(2));
				file.setsAuthorID(result.getString(3));
				file.setdUploadTime(result.getTimestamp(4));
				file.setiDownloadNum(result.getInt(5));
				file.setlSize(result.getLong(6));
				file.setiPraise(result.getInt(7));
				file.setiCriticize(result.getInt(8));
				file.setsInstitute(result.getString(9));
				file.setiGrade(result.getInt(10));
				file.setsCourseName(result.getString(11));
				file.setsDescription(result.getString(12));
				all.add(file);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp search by AuthorID ");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}
	

	
	public ArrayList<Resource> recommend_file_byDownloadNum() throws Exception {
		
		String sql = "select * from File order by DownloadNum DESC";
		DataBaseConnection conn = null;
		PreparedStatement st = null;
		ArrayList<Resource> all = new ArrayList<Resource>();
		try
		{
			conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			ResultSet result= st.executeQuery();
			int i = 0;
			while(result.next())
			{
				i++;
				if(i>10)
				{
					break;
				}
				Resource file = new Resource();
				file.setsFileName(result.getString(2));
				file.setsAuthorID(result.getString(3));
				file.setdUploadTime(result.getTimestamp(4));
				file.setiDownloadNum(result.getInt(5));
				file.setlSize(result.getLong(6));
				file.setiPraise(result.getInt(7));
				file.setiCriticize(result.getInt(8));
				file.setsInstitute(result.getString(9));
				file.setiGrade(result.getInt(10));
				file.setsCourseName(result.getString(11));
				file.setsDescription(result.getString(12));
				all.add(file);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp recommend_file_byDownloadNum ");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}



	public ArrayList<Resource> recommend_file_byPriseNum() throws Exception {
		String sql = "select * from File order by Praise DESC";
		DataBaseConnection conn = new DataBaseConnection();
		PreparedStatement st = null;
		ArrayList<Resource> all = new ArrayList<Resource>();
		try
		{
			//conn  = new DataBaseConnection();
		    st = conn.getConnection().prepareStatement(sql);
			ResultSet result= st.executeQuery();
			int i = 0;
			while(result.next())
			{
				i++;
				if(i>10)
				{
					break;
				}
				Resource file = new Resource();
				file.setsFileName(result.getString(2));
				file.setsAuthorID(result.getString(3));
				file.setdUploadTime(result.getTimestamp(4));
				file.setiDownloadNum(result.getInt(5));
				file.setlSize(result.getLong(6));
				file.setiPraise(result.getInt(7));
				file.setiCriticize(result.getInt(8));
				file.setsInstitute(result.getString(9));
				file.setiGrade(result.getInt(10));
				file.setsCourseName(result.getString(11));
				file.setsDescription(result.getString(12));
				all.add(file);
			}
			result.close();
			st.close();
		}
		catch(Exception e)
		{
			
			throw new Exception("Error in FileDAOImp recommend_file_byPriseNum ");
			
		}
		finally
		{
			conn.close();
		}
		
		return all;
	}
	

	

	/*
	public static void main(String[] args) throws Exception {
	
	  FileDAOImp test = new FileDAOImp();
	System.out.println(test.returnNextUseFileID()); 
	}
*/

	
	  
	 /*
	  ArrayList <Resource> all = test.recommend_file_byDownloadNum();
	  Iterator it = all.iterator();
		while (it.hasNext())
		{
			Resource user = (Resource)it.next();	
			//System.out.println(user.getiFileID());
			System.out.println(user.getiDownloadNum());
			//System.out.println(user.getsNickName());
		}
	}
*/

}
