<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<h2> Create User </h2>

<form action="CreateUser" method="post">
NAME:<input type="text" name ="name"><br><br>
EMAIL:<input type="email" name ="email"><br><br>
PHONE NUMBER:<input type="" name ="phone"><br><br>
PASSWORD:<input type="text" name ="password"><br><br>
<input type = "submit" value = "Create">
<input type = "reset" value= "Reset">
<input type = "submit" formaction="userDashboard.jsp" value= "Close">
</form>
<h3>${status}</h3>

</html>