<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<style>
* {
    margin:0px;
    padding:0px 0px;
}

body {
    background-color: #FBEAEB;
}

.navbar {
    overflow: auto;
    background-color: #FFD132;
    padding: 1%;
    margin-bottom: 5%;
}

.nav-right {
    font-weight: bold;
    float: right;
    color: black;
    text-decoration:none;
}

.nav-right a {
    text-align: center;
    padding: 14px 16px;
}

.nav-center h2 {
    font-weight: bold;
    position: absolute;
    left: 43%;
    display: flex;
    color: black;
    text-align: center;
    padding: 10px 16px;
    text-decoration: none;
}

.nav-left a {
    font-weight: bold;
    float: left;
    display: block;
    color: black;
    text-align:center;
    padding: 14px 16px;
    text-decoration:none;
}

.nav-left  a:hover {
    background: #2F3C7E;
    color: white;
}

.nav-right a:hover {
    background: #2F3C7E;
    color: white;
}

.navbar .search{
    float: right; 
    background-color: #2F3C7E;
    color: white;
    font-weight: bold;
}

.search:hover {
    background: #FFD132;
    color: #101820FF;
    font-weight: bold;
}

.searchform {
    border: 2px solid #2F3C7E;
}

input {
    padding: 5.2% 10px;
    border: 0px;
}

table {
    padding: 5% 10%;
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
    border:2px solid #2F3C7E;
    right:20%;
    padding:14px 30px;
    font-weight: bold;
    color: white;
}

.backbtn:hover {
    background: #FFD132;
    color: #101820FF;
    font-weight: bold;
}

</style>
</head>
<body>
<div class="navbar">
    <div class="nav-left">    
        <a href="index.jsp">HOME</a>
        <a href="createUser.jsp">Create</a>
        <a href="assignUser.jsp">Assign</a>
    </div>
    <div class="nav-center">
        <h2> User Details </h2>
    </div>
    <div class="nav-right">
        <form action="search" class="searchform">
            <input class="search-input" type="text" name="id" placeholder="Enter Id" />
            <input type="submit" value="Search" class="search">
        </form>
    </div>
</div>
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
<h3>${message}</h3>
<h3>${status}</h3>
</body>
</html> 