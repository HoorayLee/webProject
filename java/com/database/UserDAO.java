package com.database;
import java.awt.List;
import java.util.ArrayList;

import com.bean.library.*;
public interface UserDAO {
	/** *//**
     * 插入对象
     * @throws Exception
     */
	 public void insert(User user)throws Exception;
     /** *//**
      * 更新对象
      * @throws Exception
      */
	 
     public void update(User user)throws Exception;
     /** *//**
      * 删除某一对象
      * @param id
      * @throws Exception
      * 依据主码进行更新
      * 
      */
     public void delete(String user_id)throws Exception;
   
     /** *//**
      * 按照ID查询
      * @param id
      * @return
      * @throws Exception
      */
     public User queryById(String user_id)throws Exception;
     /** *//**
      * 查询全部结果
      * @return
      * @throws Exception
      */
     public ArrayList<User>  queryAll()throws Exception; 
     /** *//**
      * 模糊查询
      * @param code
      * @return
      * @throws Exception
      */
     public  ArrayList<User>  queryByLike(String code)throws Exception;
     

}
