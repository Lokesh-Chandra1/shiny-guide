package Login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class bill
 */
@WebServlet("/bill")
public class bill extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cake1 = Integer.parseInt(request.getParameter("cake1"));
		int cake2 = Integer.parseInt(request.getParameter("cake2"));
		int cake3 = Integer.parseInt(request.getParameter("cake3"));
		int cake4 = Integer.parseInt(request.getParameter("cake4"));
		int cake5 = Integer.parseInt(request.getParameter("cake5"));
		int cake6 = Integer.parseInt(request.getParameter("cake6"));
		int cake7 = Integer.parseInt(request.getParameter("cake7"));
		int cake8 = Integer.parseInt(request.getParameter("cake8"));
		int cake9 = Integer.parseInt(request.getParameter("cake9"));
		int cake10 = Integer.parseInt(request.getParameter("cake10"));
		int cake11 = Integer.parseInt(request.getParameter("cake11"));
		int cake12 = Integer.parseInt(request.getParameter("cake12"));
		int cake13 = Integer.parseInt(request.getParameter("cake13"));
		int cake14 = Integer.parseInt(request.getParameter("cake14"));
		int cake15 = Integer.parseInt(request.getParameter("cake15"));
		int cake16 = Integer.parseInt(request.getParameter("cake16"));
		int cake17 = Integer.parseInt(request.getParameter("cake17"));
		int cake18 = Integer.parseInt(request.getParameter("cake18"));
		int flag=0;
		PrintWriter out = response.getWriter();
		Connection con=null;
		int[] Array = new int[]{ cake1,cake2,cake3,cake4,cake5,cake6,cake7,cake8,cake9,cake10,cake11,cake12,cake13,
				cake14,cake15,cake16,cake17,cake18}; 
		for(int i=0;i<Array.length;i++) {
			if(Array[i]>0) {
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","Loki@123");
					PreparedStatement pst = con.prepareStatement("insert into database.bill(product, quantity) values (?,?)");
					pst.setString(1, "cake"+(i+1));
					pst.setLong(2, Array[i]);
					int rowCount = pst.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag=1;
				
			}
		}
		if(flag==0) {
			
			out.println("Please Buy Something... :(");
//			out.println("<button action=login2.jsp>Back</button>");
			HttpSession session =request.getSession(false);
			session.invalidate();
			
		}
		else {
		RequestDispatcher rd = request.getRequestDispatcher("bill.jsp");
		rd.forward(request, response);
		}
	}

}
