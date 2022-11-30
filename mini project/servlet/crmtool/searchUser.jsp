<html>
<body>
<div class="navbar">
    <form action="user-dashboard">
        <input type="submit" value="Back" class="back">
    </form>
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
        <form action="search-to-update">
            <input type="hidden" value=${user.getId()} name="id" />
            <input class="button" type="submit" value="Update" />
        </form>
        <form action="delete">
            <input type="hidden" value=${user.getId()} name="id" />
            <input class="button" type="submit" value="Delete" />
        </form>
    </div>
</div>
<h3>${message}</h3>
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
    dispaly: inline;
    background-color: #FFD132;
    padding: 1%;
    margin-bottom: 5%;
}

.navbar h1 {
    margin-right: 10%;
}

.left-button form {
    display: inline-block;
    margin-right: 5%;
}

.buttons {
    margin-left: 37%;
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

.back {
    padding: 1% 3%;
    background-color: #2F3C7E;
    border-radius: 10px;
    border: 1px;
    float: left;
    font-weight: bold;
    color: white;
}

.back:hover {
    background-color: #FFD132;
    border: 3px solid #2F3C7E;
    font-weight: bold;
    color: black;
}
</style>

</html>