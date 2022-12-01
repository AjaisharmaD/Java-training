<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
   margin : 0px;
   padding:0px 0px;
}

body {
    background-color: #FBEAEB;
}

.nav {
    background-color: #FFD132;
    color: black;
    text-align: center;
    font-weight: bold;
    padding: 1%;
    font-size: 25px;;
    width: 100%;
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
<div class="nav">
    <h3>Details of the Leads</h3>
</div>
<div id="Lead" class="content">
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
