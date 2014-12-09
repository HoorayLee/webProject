package Servlet;
import com.action.library.SearchUserResource;
import com.action.library.SearchUserInfo;
import com.bean.library.*;

import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowUrZoneServlet")
public class ShowUrZoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowUrZoneServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @����action��SearchUserFiles���û��Ѿ��ϴ������ϣ�����action.SeachUserInfo���û�����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try 
		{
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		String iUserID=(String) request.getSession().getAttribute("account");
		User user=new User();
		SearchUserInfo search=new SearchUserInfo();
		user=search.searchUser(iUserID);
		
		List<Resource> resourceList=null;
		SearchUserResource searchUserResource=new SearchUserResource();
		resourceList=searchUserResource.searchUserResource(iUserID);
		
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("resourceList", resourceList);
		response.setContentType("text/html;charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect("/app/WebContent/UrZoneFrame.jsp");
	}


}
