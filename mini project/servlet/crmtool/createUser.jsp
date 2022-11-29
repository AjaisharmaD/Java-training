<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
    border-radius: 5px;
    padding: 7% 25%;
}

input[type=text],input[type=email], input[type=password] {
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
    padding: 3% 7%;
    margin-left: 10%;
    background-color: #2F3C7E;
    border-radius: 10px;
    border: 1px;
}

.button:hover {
    background-color: #FFD132;
    border: 3px solid #2F3C7E;
}

.back {
    padding: 1% 3%;
    background-color: #2F3C7E;
    border-radius: 10px;
    border: 1px;
    float: left;
}

.back:hover {
    background-color: #FFD132;
    border: 3px solid #2F3C7E;
}

h2 {
    text-align: center;
}
.status h3 {
    text-align: center;
}
</style>
</head>
<body>
<div class="navbar">
        <form action="user-dashboard">
            <input type="submit" value="Back" class="back">
        </form>
    <h1> Create User </h1>
</div>

<div class="form">
<form action="create-user" method="post">
<h2> Enter the Details </h2>
        <label for="name">NAME:</label>
        <input id="name" type="text" name ="name" autofocus/>

        <label for="email">EMAIL:</label>
        <input id="email" type="email" name ="email" />

        <label for="phone">PHONE NUMBER:</label>
        <input id="phone" type="text" name ="phone" />
        
        <label for="password">PASSWORD:</label>
        <input id="password" type="password" name ="password" />
    <div class="btndiv">
        <input class="button" type = "submit" value = "Create" />
        <input class="button"  type = "reset" value= "Reset" />
    </div>
</form>
</div>

<div class="status">
<h3>${status}</h3>
</div>

</body>
</html>