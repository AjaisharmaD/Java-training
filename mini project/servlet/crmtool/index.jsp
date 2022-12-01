<!-- Index page to open and close the CRM Tool-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
* {
    margin: 0px;
    padding: 0px 0px;
}

body {
    background-color: #FFFFE0;
}

/* ---------navigation bar-------------- */
.nav {
    background-color: #FFD132;
    text-align: center;
    font-weight: bold;
    font-size: 20px;;
    width: 100%;
}

a {
    color: black;
    text-decoration: none;
}

/* -----------description bar------------ */
.description {
    text-align: center;
    color: #0000FF;
    font-size: 20px;
    border-bottom: 1px solid #FFD132;
    margin-bottom: 3%;
}

/* -----------button division------------ */
.btndiv {
    margin-bottom: 3%;
    margin: auto;
    text-align: center;
    width: 80%;
}

/* ----------style of a admin and user login button------- */
button {
  margin: 30px 1px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  width: 100%;
  background-color: #FFD132;
  color: black;
  font-weight: bold;
  padding: 10px 10px;  
}

button:hover {
  opacity: 0.8;
    background-color: #2F3C7E;
    color: white;
}

/* -----------admin login form---------- */
.parent {
    display: none;
    background-color: rgba(0,0,0,0.5);
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
}

.form {
    display: none;
    z-index: 1;
    left: 0;
    right: 0;
    width:100%;
    height: 100%;
    overflow: auto;
    padding-top: 60px;
}

.form-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto;
    border: 1px solid #888;
    width: 80%;
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

.container {
    padding: 16px;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color:  #FFD132;
}

/* -------animating the form to zoom----- */
.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
  from {-webkit-transform: scale(0)} 
  to {-webkit-transform: scale(1)}
}
  
@keyframes animatezoom {
  from {transform: scale(0)} 
  to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<!-- Navigation bar -->
<div class ="nav">
<h1>IdeaCRM</h1>
</div>

<!-- Description bar -->
<h3 class="description"> Win more Deals with the world's Emerging CRM Platform</h3>

<!-- Admin and User login buttons -->
<div class="btndiv">
<h3> Please Click to Login </h3>
<button onclick="popUp()" style="width:auto;">Admin</button>
<button onclick="popUp()" style="width:auto;">User</button>
<div>

<!-- User login form -->
<div class="parent" id="parent" onclick="close()">
<div id="user-login" class="form">
    <form class="form-content animate" action="" method="post">
    <div class="container">
        <h3> User Login Form </h3>
        <label for="email">Email ID: </label>
        <input type="text" placeholder="Enter Email Id" name="email" required>
        <label for="password">Password: </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <button type="submit">Login</button>
        <label>
            <input type="checkbox" name="manager">Manager
        </label>

        <div class="container">
            <button type="button" onclick="document.getElementById('user-login').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>

<div id="admin-login" class="form">
    <form class="form-content animate" action="" method="post">
    <div class="container">
        <h3> Admin Login Form </h3>
        <label for="email">Email ID: </label>
        <input type="text" placeholder="Enter Email Id" name="email" required>
        <label for="password">Password: </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <button type="submit">Login</button>
        <label>
            <input type="checkbox" name="manager">Manager
        </label>

        <div class="container">
            <button type="button" onclick="document.getElementById('user-login').style.display='none'" class="cancelbtn">Cancel</button>
        </div>
    </form>
</div>
</div>
<!-- A script to pop up the Form on to the Screen --!>
<script>
    function popUp(){	
        document.getElementById('parent').style.display='block';
        document.getElementById('user-login').style.display='block';
        document.getElementById('admin-login').style.display='block';
    }
    var admin = document.getElementById('admin-login');
    window.onclick = function(event) {
        if (event.target == admin) {
            admin.style.display = "none";
            
        }
    }
    var user = document.getElementById('user-login');
    window.onclick = function(event) {
        if (event.target == user) {
            user.style.display = "none";
            
        }
    }

    function close() {
        document.getElementById('parent').style.display='block';
    }
    var back = document.getElementById('parent');
    window.onlclick = function(event) {
        if(event.target == back) {
            back.style.display = "none";
        }
    }
</script>
</body>
</html>