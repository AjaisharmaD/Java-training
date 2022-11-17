<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div class="navbar">
    <a href="createUser.jsp">Create</a>
    <a href="searchUser.jsp">Search</a>
    <a href="updateUser.jsp">Update</a>
    <a href="deleteUser.jsp">Delete</a>
    <a href="assignUser.jsp">Assign</a>
</div>
<br><br>
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
<br><br>

<a href="userDashboard.jsp">
    <button class="backbtn">Back</button>
</a>
</body>

<style>
body {
    background-color: #FBEAEB;
}

.navbar {
    overflow: auto;
    background-color: #FFD132;
}

.navbar a{
    float: left;
    display: block;
    color: black;
    text-align:center;
    padding: 14px 16px;
    text-decoration:none;
}

.navbar a:hover {
    background: #2F3C7E;
}

table,th,tr,td {
    border: 1px solid black;
    border-collapse: collapse;
    margin: 0 auto;
}

table {
    width:100%;
}

th {
    background-color: #89CFF0;
}

td {
    text-align: center;
    height: 30px;
}

.backbtn {
    position:relative;
    float: right;
    z-index:95;
    background-color: #2F3C7E;
    border-radius: 10px;
    border:3px solid #2F3C7E;
    right:20%;
    padding:14px 30px;
}

.backbtn:hover {
    background: #FFD132;
}

</style>
</html> 