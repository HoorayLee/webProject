package com.action.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bean.library.User;
import com.bean.library.Resource;
import com.database.*;

public class SearchUserInfo {
	
	public User searchUser(String iUserID2) {
		
	UserDAOImp userDAOImp=new UserDAOImp();
	User user=new User();
	String iUserID=iUserID2;
	try {
		user = userDAOImp.queryById(iUserID);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String nameString=user.getsNickName();
	if(nameString==null)
		user.setsNickName(" ");
	return user;
	}
}
