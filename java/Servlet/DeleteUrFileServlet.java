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
		
		FileDAOImp fileDAOImp=new FileDAOImp();
		int fileID=(int)request.getSession().getAttribute("deleteResourceID");
		String userID=(String) request.getSession().getAttribute("account");
		//�û���Դ����Ҫ-1
		try {
			fileDAOImp.delete(fileID);//�û���Դ����һ
			System.out.println("�û�"+userID+"ɾ��"+fileID+"���ļ�");
		} catch (Exception e) {
			e.printStackTrace();
		}


}
}