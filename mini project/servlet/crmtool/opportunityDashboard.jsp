<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
    margin: 0;
    padding: 0 0;
}

body {
    background-color: #FBEAEB;
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
<div id="Lead" class="content">
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
<c:forEach var="opportunity" items="${opportunities}">
    <tr>
        <td>${opportunity.getId()}</td>
        <td>${opportunity.getName()}</td>
        <td>${opportunity.getAmount()}</td>
        <td>${opportunity.getStatus()}</td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>
