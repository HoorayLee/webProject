package com.database;

import java.util.ArrayList;

import com.bean.library.*;

public interface CommentDAO {
	public ArrayList<Comment> query_by_fileID(int file_id)throws Exception;
	
	public boolean insert_comment(int file_id,String content)throws Exception;
	
	public boolean  delete_comment(int comment_id)throws Exception;
	
}
