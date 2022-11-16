<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<p> Please give your Credentials to Login </p><br>

<form action = "UserLogin" method = "post">
Email Id<input type = "email" name= "email" autofocus autocomplete="on"><br><br>

Password<input type = "password" name = "password" ><br><br>

<input type = "submit" value ="Login">
</form>

<p>${status}</p>
</html>