package Servlet;

import com.action.library.AddComent;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.library.User;
import com.database.UserDAOImp;

/**
 * Servlet implementation class ChangeName
 */
@WebServlet("/StoreComment")
public class StoreComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User user = new User();
    UserDAOImp newuser = new UserDAOImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreComment() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		AddComent add=new AddComent();
		int file_id=(int)request.getSession().getAttribute("fileID");
		String content=request.getParameter("comment");
		boolean result=add.addComent(file_id, content);
		if(result==false)
			System.out.println("添加"+file_id+"的评论，无法存入数据库！");
	}

}
