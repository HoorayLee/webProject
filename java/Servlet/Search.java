package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.PostInfo;
import com.database.FileDAOImp;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FileDAOImp newtest = new FileDAOImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String grade = request.getParameter("grade");
		 System.out.println(grade);
		 String className = request.getParameter("className");
		 System.out.println(className);
		 
			 try {
				 if(grade == null && className != "")
				 {
				request.getSession().setAttribute("resource", newtest.query_by_requests_byname(className));
				 }
				 else if(className == "" && grade != null)
				 {
					 request.getSession().setAttribute("resource", newtest.query_by_requests_bygrade(grade));
				 }
				 else if(className != "" && grade != null)
				 {
					 request.getSession().setAttribute("resource", newtest.query_by_requests(grade,className));
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			// response.sendRedirect("/app/main.html");
	}

}
