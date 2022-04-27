package registration;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("name");
		String umobile = request.getParameter("phno");
		String ugender = request.getParameter("gender");
		String upsw = request.getParameter("psw");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		Connection con=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","Loki@123");
		PreparedStatement pst = con.prepareStatement("insert into register(Name, phone_no, gender, password) values (?,?,?,?)");
		
		pst.setString(1, uname);
		pst.setString(2, umobile); 
		pst.setString(3, ugender);
		pst.setString(4, upsw);
		
		int rowCount = pst.executeUpdate();
		rd= request.getRequestDispatcher("create.jsp");
		if(rowCount > 0) {
			request.setAttribute("status", "success");
		}else {
			request.setAttribute("status", "failed");
		}
		rd.forward(request, response);
	}catch(Exception e) {
		e.printStackTrace();

	}
	}

}
