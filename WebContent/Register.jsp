<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "stylesheet" href = "css/Login.css" type = text/css>

<title>Register</title>
</head>
<body>
<h1 align="center"> Register Account</h1>
<div>
 <form method="POST" name="frmLogin" action="RegisterAccount" onsubmit = "return validateRegister()">
        <table border="1" align="center" id ="loginview">
        	<tr>
        		<td>Account: <input type="text" name="username" size="20" maxlength="20" /></td>
        	</tr>
        	<tr>
        		<td>Password: <input type="password" name="pwd" size="20" maxlength="20" /></td>
        	</tr>
			<tr align = "center">
        		<td>
        		<input type="submit" name="Submit" value="Submit"/>
        		</td>
        	</tr>
        </table>
    </form>
</div>
</body>
</html>