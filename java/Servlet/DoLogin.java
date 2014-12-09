package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.PostInfo;
import com.bean.library.Resource;
import com.bean.library.User;
import com.database.FileDAO;
import com.database.FileDAOImp;
import com.database.UserDAOImp;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	FileDAOImp newtest = new FileDAOImp();
	UserDAOImp newU = new UserDAOImp();
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 boolean judge = true;
		 String username=request.getParameter("account");
		 String password=request.getParameter("password");
		 
		 System.out.println(username + " " + password);
		 //judge = PostInfo.Login(username, password);
		 if (judge == true){
			
			 try {
				request.getSession().setAttribute("resource", newtest.recommend_file_byPriseNum());
				request.getSession().setAttribute("account",username); 
				User user = newU.queryById(username);
				request.getSession().setAttribute("nickname",user.getsNickName()); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 response.sendRedirect("/app/main.html");
			 
			 
			 System.out.println("cool!");// TODO Auto-generated method stub
		 }
		 else{
			 
			 response.sendRedirect("/app/login.jsp");// TODO Auto-generated method stub
		 }
	}

}
