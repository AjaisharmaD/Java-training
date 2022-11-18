<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<div class="navbar">
    <h1> Create User </h1>
</div>

<style>
* {
    margin: 0px;
    padding: 0px 0px;
}

.navbar {
    overflow: auto;
    background-color: #FFD132;
    text-align: center;
}

div {
    margin-bottom: 30px;
}

input {
    padding: 10px 35px;
    text-align: right;
    margin-bottom: 10px;
    border: 1px solid black;
    border-radius: 8px;
align-items: center;
}

#button {
    padding: 10px 35px;
    border-radius: 10px;
    background-color: #2F3C7E;
    border-radius: 10px;
    border:2px solid #2F3C7E;
}

#button:hover {
    background: #FFD132;
}

button {
    left: 60%;
    position: relative; 
}

#form {
    border: 2px solid black;
    margin-left:30%;
    margin-right:30%;
    margin-top: 7%; 
}

.label {
    float: left;
    width: 30%;
    margin-top: 6px;
}

.textbox {
    float: left;
    width: 80%;
    margin-top: 6px;
}

table {
    margin-left: 65px;
    text-align: right;
}

h2 {
    text-align: center;
    padding-top:3%;
}

</style>
</head>

<body> 
<div id="form" >

<form action="CreateUser" method="post">
<h2> Enter the Details </h2>
<table>
    <tr>
        <td class="lable">NAME:</td>
        <td class="textbox"><input type="text" name ="name" /></td>
    </tr>
   <br>
        <tr>
        <td>EMAIL:</td>
        <td><input type="email" name ="email" /></td>
        </tr>
<br>
         
        <tr>
        <td>PHONE NUMBER:</td>
        <td><input type="" name ="phone" /></td>
        </tr>
<br>    
        <tr>
        <td>PASSWORD:</td>
        <td><input type="text" name ="password" /></td>
        </tr>
    </table>
<br>
    <input id="button" type = "submit" value = "Create" />
    <input id="button"  type = "reset" value= "Reset" />
</form>
</div>
    <a href="UserDashboard">
        <button id="button"> Close </button>
    </a>
<h3>${status}</h3>
</body>
</html>