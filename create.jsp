<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<link rel="stylesheet" href="createstyle.css">
</head>

<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
<form method ="post" action="RegistrationServlet">
<div id="main">
<div id="reg"> 

<h1><u>Register</u></h1>

<div id="details">
<label type="text">Name:</label>
<input type="text" name="name">
<br><br>
<label type="number">Phone_Number:</label>
<select name="Name:" id="Name:">
<option value=""></option>
<option value="+91">+91</option>
<option value="+72">+72</option>
<option value="+80">+80</option>
</select>
<input type="text" name="phno" pattern="\d{10}" maxlength="10">
<br><br>
Enter your Gender:<br>
<input type="radio" id="male" name="gender" value="male">
<label for="male">male</label><br>
<input type="radio" id="female" name="gender" value="female">
<label for="female">female</label><br><br>
<label type="text">password: </label>
<input type="password" name="psw" pattern="[A-Za-z0-9]{8:}" title="The psw should be atleast 8  characters and only consists of alphabets,numbers and periods(.)" placeholder="Enter your password" required>

<br><br>
<button id="button" >Register</button>

</form>
</div>
</div>
</div>
<br>
<center><a href="login2.jsp">click here</a></center>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
 var status = document.getElementById("status").value;
 if(status=="success"){
	 swal("User Registered Successfully","success");
 }
</script>
</body>
</html>