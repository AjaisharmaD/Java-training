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
<div class="contact">
    <h3>Details of the Contacts</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email Id</th>
        <th>Phone Number</th>
        <th>Company name</th>
        <th>Role</th>
    </tr>
<c:forEach var="contact" items="${contacts}">
    <tr>
        <td>${contact.getId()}</td>
        <td>${contact.getName()}</td>
        <td>${contact.getEmailId()}</td>
        <td>${contact.getPhoneNumber()}</td>
        <td>${contact.getCompanyName()}</td>
        <td>${contact.getType()}</td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>
