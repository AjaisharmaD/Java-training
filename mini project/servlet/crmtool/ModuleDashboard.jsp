<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
    margin: 0px;
    padding: 0px 0px;
}

body {
    background-color: #FBEAEB;
}

.nav {
    background-color: #FFD132;
    color: black;
    font-weight: bold;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    width: 18%;
}

a {
    text-decoration: none;
    color: black;
}

.nav:hover {
    background-color: #2F3C7E;
    color: white;
}

.content {
    color: white;
    display: none;
    padding: 100px 20px;
    height: 100%;
}

#Lead {
    background-color: red;
    color: black; 
}

#Account {   
    background-color: #FBEAEB;
    color: black; 
}

#Contact {
    background-color: #FBEAEB;
    color: black; 
}

#Opportunity {
    background-color: #FBEAEB;
    color: black; 
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
</style>
</head>
<body>
<h1> Welcome ${name} </h1>
<a href="get-leads"><button class="nav">Lead</button></a>
<a class="nav" href="get-contacts">Contact</a>
<a class="nav" href="get-accounts">Account</a>
<a class="nav" href="get-opportunities">Opportunity</a>

<div class="Lead">
        <h3>Details of the Leads</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email Id</th>
        <th>Phone Number</th>
        <th>Company name</th>
        <th>Status</th>
    </tr>
<c:forEach var="lead" items="${leads}">
    <tr>
        <td>${lead.getId()}</td>
        <td>${lead.getName()}</td>
        <td>${lead.getEmailId()}</td>
        <td>${lead.getPhoneNumber()}</td>
        <td>${lead.getCompanyName()}</td>
        <td>${lead.getStatus()}</td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>
