package Login;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("Login ID");
		String upsw = request.getParameter("Password");
//		HttpSession session = request.getSession();
//		PrintWriter out = response.getWriter();
		Boolean status = false;
		RequestDispatcher rd = null;
		Connection con=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");  
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","Loki@123");
	    PreparedStatement pst = con.prepareStatement("select * from register where Name=? and password=?");
	    
	    pst.setString(1, uname);
	    pst.setString(2, upsw);
	  
	    ResultSet rs=pst.executeQuery();
	    status=rs.next();
	    
	    if(status) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("uname", uname);
//	    	rd= request.getRequestDispatcher("IndexServlet");
	    	response.sendRedirect("IndexServlet"); 
	    	
	    }else {
	    	
	    	rd=request.getRequestDispatcher("login2.jsp");
	    	request.setAttribute("status", "failed");
	    }
	    rd.forward(request, response);
	    
	}catch(Exception e) {
		e.printStackTrace();
	
	}
	}

}
