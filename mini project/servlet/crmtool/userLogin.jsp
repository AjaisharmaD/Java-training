<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<p> Please give your Credentials to Login </p><br>
<div class="form">
<form action = "UserLogin" method = "post">
    <lable>Email Id: </lable>
    <input class="input" type = "email" name= "email" autofocus autocomplete="on">
    <lable>Password: </lable>
    <input class="input" type = "password" name = "password">
    <div class="btndiv">
        <input class="button" type = "submit" value ="Login">
    </div>
</form>
<div>
<p>${status}</p>
</body>
<style>
body {
    background: #FBEAEB;
}

.form {
    padding: 7% 25%;
}


.btndiv {
    padding-left: 8%;
}

.input {
    width: 100%;
    border: 1px solid black;
    border-radius: 2%;
    padding: 1%;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
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
</style>
</html>