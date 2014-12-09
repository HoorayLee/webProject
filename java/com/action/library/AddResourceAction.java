package com.action.library;
import java.io.File;

import com.database.*;
import com.bean.library.Resource;
import com.bean.library.User;


//����Ҫ����FILE����Ҫ�޸�USER���ϴ���Դ����
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
