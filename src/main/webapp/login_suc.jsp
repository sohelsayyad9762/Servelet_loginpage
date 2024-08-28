<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Log in sucecfull</h1>

<h1>if you "Delete" any student information</h1>
<form action="delete">
username<input type="text" name="uname"></br></br>
<input type="submit" value="Delete"/>
</form>



<h1>if you "Update" any student information</h1>
<form action="update">
Name<input type="text" name="name"></br></br>
Email<input type="text" name="email"/></br></br>
Password<input type="text" name="pass"></br></br>
Contact<input type="text" name="contact"/></br></br>
<input type="submit" value="update"/>
</form>

</body>
</html>