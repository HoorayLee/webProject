package Servlet;

import java.io.IOException;

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
@WebServlet("/ChangeName")
public class ChangeName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    User user = new User();
    UserDAOImp newuser = new UserDAOImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeName() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String newNickName = request.getParameter("nickName");
		 String number = (String) request.getSession().getAttribute("account");
		 user.setsUserID(number);;
		 user.setsNickName(newNickName);
		 try {
			 System.out.println(newNickName);
			newuser.update(user);
			request.getSession().setAttribute("nickname", newNickName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		//response.sendRedirect("/app/UrZoneFrame.html");
		
	}

}
