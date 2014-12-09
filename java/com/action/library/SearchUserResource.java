package com.action.library;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.library.Resource;
import com.database.*;

public class SearchUserResource {
	public List<Resource> searchUserResource(String ID) {
		FileDAOImp fileDAOImp=new FileDAOImp();
		String iUserID=ID;
		List<Resource> resourceList=new ArrayList<Resource>();
		try {
			resourceList = fileDAOImp.query_by_authorID(iUserID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resourceList;
	}

}
