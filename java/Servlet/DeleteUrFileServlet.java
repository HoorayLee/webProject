package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.FileDAOImp;


@WebServlet("/DeleteUrFileServlet")
public class DeleteUrFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteUrFileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @调用action中SearchUserFiles得用户已经上传的资料，调用action.SeachUserInfo得用户资料
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
		
		FileDAOImp fileDAOImp=new FileDAOImp();
		int fileID=(int)request.getSession().getAttribute("deleteResourceID");
		String userID=(String) request.getSession().getAttribute("account");
		//用户资源数还要-1
		try {
			fileDAOImp.delete(fileID);//用户资源数减一
			System.out.println("用户"+userID+"删除"+fileID+"号文件");
		} catch (Exception e) {
			e.printStackTrace();
		}


}
}