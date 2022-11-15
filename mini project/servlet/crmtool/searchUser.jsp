<html>
<h1>Details of the User</h1>

<form action="Search">
<lable>Search ID:</lable>
<input type="text" name="id">
<input type="submit" value="Search">
</form>

<br><br>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email Id</th>
        <th>Phone Number</th>
    </tr>
    <tr>
        <td>${user.getId()}</td>
        <td>${user.getName()}</td>
        <td>${user.getEmailId()}</td>
        <td>${user.getPhoneNumber()}</td>
    </tr>
</table>
<br><br>
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

<br>
<br>

</p>
</html>