package com.action.library;
import java.io.File;

import com.database.*;
import com.bean.library.Resource;
import com.bean.library.User;


//不仅要增加FILE，还要修改USER的上传资源数量
public class AddResourceAction {
	public boolean addResource(Resource r) {
		boolean result=false;
		User user=new User();
		UserDAOImp userDAOImp=new UserDAOImp();
		FileDAOImp fileDAOImp=new FileDAOImp();
		
		try {
			userDAOImp.update(user); 
			fileDAOImp.insert(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

}
