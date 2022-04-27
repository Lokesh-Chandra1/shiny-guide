<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yeswanth Bill</title>
<style>

#table{
  margin-left: 40%;
}
#total{
  margin-left: 15%;
}
h1{
  text-align: center;
}
#shop{
font-family:mistral;
color:green;
font-size:30px;
text-decoration:none;
}
#shop:hover{
color:blue;
}

</style>
</head>
<body>
<h1>Bill</h1>
    <div id="table">
        <table border= "1">
<tr><td>Product</td>
    <td>Quantity</td>
    <td>Cost</td>
    <td>Amount</td>
</tr>
<%!int sum=0;  %>
<%
try{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?useSSL=false","root","Loki@123");
Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select product , quantity from database.bill");


int sum=0;

while(rs.next()){
	int temp=rs.getInt(2);
	sum=sum+temp; 
	
//Thread.sleep(5000); // sleep 5 seconds

out.print("<tr>");
out.print(" <td>"+rs.getString(1)+"</td> ");     
out.print( "<td>"+rs.getString(2)+"</td>");
out.print("  <td>"+10+"</td>");
out.print(" <td>"+temp*10+"</td>");
out.print("</tr>");


 }
out.print("</table>");
 %>



 
      <table border="2px" id="total">
        <tr>
          <td> Total </td>
          <td width="50px"><%=sum*10%></td>
        </tr>
      </table>
      <button onclick="window.print()">Print</button>
    </div>
    <br>
  <center>  <a id="shop" href="LogoutServlet">Happy Shopping.....</a></center>
 <%} catch(Exception e) {
	e.printStackTrace();

}%>
</body>
</html>