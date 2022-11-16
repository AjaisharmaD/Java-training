<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<p> Here are the Employee Operations that You can do! </p>
<div>
    <a href="createUser.jsp"><input type ="submit" value="Create"></a>
    <a href="searchUser.jsp"><input type ="submit" value="Search"></a>
    <a href="updateUser.jsp"><input type ="submit" value="Update"></a>
    <a href="deleteUser.jsp"><input type ="submit" value="Delete"></a>
    <a href="assignUser.jsp"><input type ="submit" value="Assign"></a>
</div>
<br><br><br><br>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email Id</th>
        <th>Phone Number</th>
    </tr>
<c:forEach var="user" items="${users}">
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getName()}</td>
        <td>${user.getEmailId()}</td>
        <td>${user.getPhoneNumber()}</td>
    </tr>
</c:forEach>
</table>

<a href="userDashboard.jsp">
    <button id="backbtn">Back</button>
</a>

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

#backbtn {
    position:fixed;
    z-index:99;
    bottom:300px;
    right:250px;
}
</style>
</html> 