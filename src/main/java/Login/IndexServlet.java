package Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession(false);
		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();
		out.print("1");
		if(session!=null)
		{
			out.print("2");
			String uname = (String)session.getAttribute("uname");
			out.print(uname);
			response.sendRedirect("index.jsp");
		}
		else
		{
			out.print("3"); 
			response.sendRedirect("login2.jsp");
		}
	}
	

}
