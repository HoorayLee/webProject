package com.action.library;
import com.database.CommentDAOImp;

public class AddComent {
	public boolean addComent(int file_id,String content){
		boolean result=false;
		CommentDAOImp add=new CommentDAOImp();
		try {
			result=add.insert_comment(file_id,content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
