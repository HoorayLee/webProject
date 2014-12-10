package com.database;

import java.util.ArrayList;

import com.bean.library.*;

public interface FileDAO {
	 public int returnNextUseFileID()throws Exception;
	
	 public void insert(Resource file)throws Exception;
	
     public void delete(int file_id)throws Exception;//暂时根据主码进行删除
     
	 public void update_DownloadNum(int file_id)throws Exception; //默认加1
	 
	 public void update_Praise(int file_id)throws Exception;
	 
	 public void update_Criticize(int file_id)throws Exception;
	 
	 public ArrayList<Resource> query_by_requests(String grade, String className) throws Exception ;
	 
	 public ArrayList<Resource> query_by_requests_bygrade(String grade) throws Exception ;
	 
	 public ArrayList<Resource> query_by_requests_byname( String className) throws Exception ;
	
     public ArrayList<Resource> query_by_authorID(String user_id)throws Exception;
   
     public  ArrayList<Resource>  recommend_file_byDownloadNum()throws Exception;
     
     public  ArrayList<Resource>  recommend_file_byPriseNum()throws Exception;
     
     
     
	
	
	
}
