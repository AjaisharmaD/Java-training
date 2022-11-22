<html>
<body>
<div class="navbar">
    <h1>Details of the User</h1>
</div>

<div class="table">
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
</div>
<div class="buttons">
    <div class="left-button">
        <form action="SearchToUpdate">
            <input type="hidden" value=${user.getId()} name="id" />
            <input class="button" type="submit" value="Update" />
        </form>
        <form action="Delete">
            <input type="hidden" value=${user.getId()} name="id" />
            <input class="button" type="submit" value="Delete" />
        </form>
        <form action="UserDashboard">
            <input class="button" type="submit" value="Back"/>
        </form>
    </div>
</div>

<h3>${status}</h3>
</body>
<style>
* {
    margin: 0px;
    padding: 0px 0px;
}

table {
    width: 100%;
    margin-bottom: 10%;
}

th {
    background-color: #89CFF0;
}

td {
    text-align: center;
    height: 30px;
}

body {
    background:#FBEAEB;
}

.navbar {
    text-align: center;
    overflow: auto;
    background-color: #FFD132;
    padding: 1%;
    margin-bottom: 5%;
}

.left-button form {
    display: inline-block;
    margin-right: 5%;
}

.buttons {
    margin-left: 30%;
}

.button {
    background-color: #2F3C7E;
    border-radius: 10px;
    border:2px solid #2F3C7E;
    padding:14px 30px;
    font-weight: bold;
    color: white;
}

.button:hover {
    background: #FFD132;
    color: #101820FF;
    font-weight: bold;
}
</style>

</html>