<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script type="text/javascript" src = "js/validateLogin.js"></script>
<link rel = "stylesheet" href = "css/Login.css" type = "text/css"/>
<title>Login Page</title>
</head>

<body style="background:url('img/bgtable.jpg') no-repeat; background-size:cover; background-attachment: fixed;">
<div id="login">
    <form method="POST" name="frmLogin" action="CheckAccount" onsubmit = "return validate(this)">
        <h1 align="center">Login In</h1>
        <table border="1" align="center" id ="loginview">
        	<tr>
        		<td>Account: <input type="text" id = "username"  name="username" size="20" maxlength="20" /></td>
        	</tr>
        	<tr>
        		<td>Password: <input type="password" id = "pwd" name="pwd" size="20" maxlength="20" /></td>
        	</tr>
			<tr align = "center">
        		<td>
        		<input type="submit" name="Submit" value="Submit"/>
        		<input type="reset" name="Reset" value="Reset" />
        		<input type = "button" name="register" value = "Register" onclick = "location.href='Register.jsp'"/>
        		</td>
        	</tr>
        </table>
    </form>
</div>
</body>
</html>