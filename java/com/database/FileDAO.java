package com.database;

import java.util.ArrayList;

import com.bean.library.*;

public interface FileDAO {
	/** *//**
     * 插入对象
     * @throws Exception
     */
	 public void insert(Resource file)throws Exception;
     /** *//**
      * 更新对象
      * @throws Exception
      */
	 
    // public void update(Resource file)throws Exception;//根据主码进行更新
	 public void update_DownloadNum(int file_id,int DownloadNum)throws Exception;
	 
	 public void update_Praise(int file_id,int Praise)throws Exception;
	 
	 public void update_Criticize(int file_id,int Criticize)throws Exception;
	 
	 public ArrayList<Resource> query_by_requests(String grade, String className) throws Exception ;
	 
	 
	 public ArrayList<Resource> query_by_requests_bygrade(String grade) throws Exception ;
	 public ArrayList<Resource> query_by_requests_byname( String className) throws Exception ;
	 
	 
     /** *//**
      * 删除某一对象
      * @param id
      * @throws Exception
      * 依据主码进行更新
      * 
      */
     public void delete(int file_id)throws Exception;//暂时根据主码进行删除
   
     /** *//**
      * 按照Author_ID查询
      * @param id
      * @return
      * @throws Exception
      */
     public ArrayList<Resource> query_by_authorID(String user_id)throws Exception;
     
     /*
      * 返回 DownloadNum 前10 的 文件集合      
      * 
      */
     public  ArrayList<Resource>  recommend_file_byDownloadNum()throws Exception;
     
     
     /*
      * 返回 Prise 前10 的 文件集合      
      * 
      */
     public  ArrayList<Resource>  recommend_file_byPriseNum()throws Exception;
     
     /*
      * 返回 Criticize 前10 的 文件集合      
      * 
      */
    
     
	
	
	
}
