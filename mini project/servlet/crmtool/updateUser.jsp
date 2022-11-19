<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<h2> Update User </h2>

<form action="SearchToUpdate">
<lable>Enter ID:</lable>
<input type="text" name="id">
<input type="submit" value="Search">
</form>

<p>${user}</p>

<form action="UpdateUser" method="post">
ID:<input type="text" name ="id" value=${user.getId()}><br><br>
NAME:<input type="text" name ="name" value=${user.getName()}><br><br>
EMAIL:<input type="email" name ="email" value=${user.getEmailId()}><br><br>
PHONE NUMBER:<input type="" name ="phone" value=${user.getPhoneNumber()}><br><br>
<input type = "submit" value = "Save">
<input type = "reset" value= "Reset">
</form>
<a href="UserDashboard">
    <button id="backbtn">Back</button>
</a>
<h3>${status}</h3>

<style>
table,th,tr,td {
    border: 1px solid black;
    border-collapse: collapse;
    margin: 0 auto;
    width: 900px;
}

th {
    background-color: #89CFF0;
}

td {
    text-align: center;
    height: 30px;
}

lable{
    margin-left:545px;
}

h1 {
    text-align: center;
}

#backbtn {
    position:fixed;
    z-index:99;
    bottom:400px;
    right:250px;
}

</style>
</html>