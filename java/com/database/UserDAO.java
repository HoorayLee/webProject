package com.database;
import java.awt.List;
import java.util.ArrayList;

import com.bean.library.*;
public interface UserDAO {
	/** *//**
     * �������
     * @throws Exception
     */
	 public void insert(User user)throws Exception;
     /** *//**
      * ���¶���
      * @throws Exception
      */
	 
     public void update(User user)throws Exception;
     /** *//**
      * ɾ��ĳһ����
      * @param id
      * @throws Exception
      * ����������и���
      * 
      */
     public void delete(String user_id)throws Exception;
   
     /** *//**
      * ����ID��ѯ
      * @param id
      * @return
      * @throws Exception
      */
     public User queryById(String user_id)throws Exception;
     /** *//**
      * ��ѯȫ�����
      * @return
      * @throws Exception
      */
     public ArrayList<User>  queryAll()throws Exception; 
     /** *//**
      * ģ����ѯ
      * @param code
      * @return
      * @throws Exception
      */
     public  ArrayList<User>  queryByLike(String code)throws Exception;
     

}
