<html>
<title>Login website</title>


<style type="text/css">
a:link{
color:yellow;
}
#link{
font-family:Sans-serif;
color:white;
}
a:hover{
color:#CD5C5C;
}
a{
animation:blinking .5s infinite;

}
@keyframes blinking{
0%{color:transparent;}
100%{color:yellow;}
}
body{
background: url("ali.jpg");
background-size:100%;
}
h1
{
color:white;
text-align:center;
}
#log{
background-color:rgba(0,0,0,0.5);
width:100%;
font-size:18px;
border-radius:5px;
border:1px solid green;
box-shadow:2px 2px 15px blue;
color:white;
margin:auto;
}
.main{
width:250px;
margin:100 auto 0 auto;
}

#reg{
margin:18px;
}
#submit{
width:50%;
font-size:18px;
background-color:orange;
border-radius:5px;
border:1px solid yellow;
}
</style>
<body>

<div class="main">
<div id="log"><h1>LOGIN</h1>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">

<form  method="post" action="LoginServlet2">
<div id="reg">
<label type="text">Login ID</label>
</br></br>
<input type="text" name="Login ID" id="login">
</br></br>

<label type="text" >Password</label>
</br></br>
<input type="password" name="Password" id="psw">
</br></br>
<input type="submit" name="submit" id="submit" >
</form>

</div>

</div>
<br>
<center><blink><div id="link">Don't have an account</div> <a href="create.jsp">Create one!....</a> </center></blink>
<script type="text/javascript" src="javascript.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<script type="text/javascript">
 var status = document.getElementById("status").value;
 if(status=="failed"){
	 swal("Login Failed","failed");
 }

</script>


</body>

</html>