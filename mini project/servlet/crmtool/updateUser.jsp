<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div class="navbar">
<h2> Update User </h2>
</div>

<div class="form">

<form action="update-user" method="post">
        <label for="id">ID:</label>
        <input class="input" id="id" type="text" name="id" value=${user.getId()} readonly />

        <label for="name">NAME:</label>
        <input class="input" id="name" type="text" name ="name" value=${user.getName()} />

        <label for="email">EMAIL:</label>
        <input class="input" id="email" type="email" name ="email" value=${user.getEmailId()} />

        <label for="phone">PHONE NUMBER:</label>
        <input class="input" id="phone" type="text" name ="phone" value=${user.getPhoneNumber()} />  
<div class="btndiv">
    <input class="button" type = "submit" value = "Update" />
    <input class="button" type = "reset" value= "Reset" />
    <span>
    <a href="user-dashboard" class="button">Back</a>
    </span>

</div>
</form>



</div>

<div class="status">
<h3>${status}</h3>
</div>
</body>
<style>
* {
    margin: 0px;
    padding: 0px 0px;
}

body {
    background:#FBEAEB;
}

.navbar {
    overflow: auto;
    background-color: #FFD132;
    text-align: center;
    padding: 1%;
}

.form {
    padding: 7% 25%;
    display: inline-block;
}

.input {
    width:100%;
    border: 1px solid black;
    border-radius: 2%;
    padding: 1%;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
}

.btndiv {
    padding-left: 8%;
}

.button {
    padding: 2% 5%;
    margin-left: 5%;
    background-color: #2F3C7E;
    border-radius: 10px;
    border: 1px;
    color: white;
    font-weight: bold;
}

.button:hover {
    background-color: #FFD132;
    border: 3px solid #2F3C7E;
}

.backbtn {
    float: right;
    right: 5%;
}

h2 {
    text-align: center;
}
.status h3 {
    text-align: center;
}
</style>
</html>