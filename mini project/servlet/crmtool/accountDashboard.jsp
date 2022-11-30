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
<div class="table">
    <h3>Details of the Accounts</h3>
<table>
    <tr>
        <th>Name</th>
        <th>Website</th>
        <th>Type</th>
        <th></th>
        <th>Status</th>
    </tr>
<c:forEach var="lead" items="${leads}">
    <tr>
        <td>${account.getName()}</td>
        <td>${account.getWebsite()}</td>
        <td>${account.getType()}</td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>
