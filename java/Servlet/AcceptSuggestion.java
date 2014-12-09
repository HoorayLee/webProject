package Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.library.StoreSuggestion;

/**
 * Servlet implementation class AcceptSuggestion1
 */
@WebServlet("/AcceptSuggestion")
public class AcceptSuggestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptSuggestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		String suggestion=request.getParameter("suggestion");
		String userID=request.getSession().getAttribute("account").toString();
		StoreSuggestion store=new StoreSuggestion();
		store.store(suggestion);
		System.out.println("用户"+userID+"反馈建议，请查看！");
		
	}

}
