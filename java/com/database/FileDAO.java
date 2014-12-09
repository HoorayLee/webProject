package com.database;

import java.util.ArrayList;

import com.bean.library.*;

public interface FileDAO {
	/** *//**
     * �������
     * @throws Exception
     */
	 public void insert(Resource file)throws Exception;
     /** *//**
      * ���¶���
      * @throws Exception
      */
	 
    // public void update(Resource file)throws Exception;//����������и���
	 public void update_DownloadNum(int file_id,int DownloadNum)throws Exception;
	 
	 public void update_Praise(int file_id,int Praise)throws Exception;
	 
	 public void update_Criticize(int file_id,int Criticize)throws Exception;
	 
	 public ArrayList<Resource> query_by_requests(String grade, String className) throws Exception ;
	 
	 
	 public ArrayList<Resource> query_by_requests_bygrade(String grade) throws Exception ;
	 public ArrayList<Resource> query_by_requests_byname( String className) throws Exception ;
	 
	 
     /** *//**
      * ɾ��ĳһ����
      * @param id
      * @throws Exception
      * ����������и���
      * 
      */
     public void delete(int file_id)throws Exception;//��ʱ�����������ɾ��
   
     /** *//**
      * ����Author_ID��ѯ
      * @param id
      * @return
      * @throws Exception
      */
     public ArrayList<Resource> query_by_authorID(String user_id)throws Exception;
     
     /*
      * ���� DownloadNum ǰ10 �� �ļ�����      
      * 
      */
     public  ArrayList<Resource>  recommend_file_byDownloadNum()throws Exception;
     
     
     /*
      * ���� Prise ǰ10 �� �ļ�����      
      * 
      */
     public  ArrayList<Resource>  recommend_file_byPriseNum()throws Exception;
     
     /*
      * ���� Criticize ǰ10 �� �ļ�����      
      * 
      */
    
     
	
	
	
}
