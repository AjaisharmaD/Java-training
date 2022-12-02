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
    background-color: white;
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
.heading {
    text-align: center;
    color: #032d60;
    font-size: 20px;
    margin-bottom: 3%;
    margin-top: 2%;
}

/* -----------crm content------------*/
.crm-content {
    padding: 20px 20px;
    margin: auto;
}

.para {
    font-size: 16px;
    text-align: center;
    line-height: 25px;
}

.benifit-component {
    padding-left: 10%;
}

.title {
    font-size: 16px;
    text-align: center;
    line-height: 25px;
    font-weight: bold;
}

.head-component {
    text-align: left;
    line-height: 18px;
}

/* -----------button division------------ */
.btndiv {
    margin-bottom: 3%;
    margin: auto;
    text-align: center;
    width: 100%;
}

/* ----------style of a admin and user login button------- */
.formbtn {
    margin: 10px 10px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    width: 80%;
    background-color: #FFD132;
    color: #000000;
    font-size: 16px;
    font-weight: bold;
    padding: 20px 20px;  
}

.formbtn:hover {
    opacity: 0.8;
    background-color: green;
    color: white;
}

.btn {
    margin: 20px 40px;
    padding: 20px 50px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    width: 80%;
    background-color: #FFD132;
    color: #000000;
    font-size: 16px;
    font-weight: bold;
}

.btn:hover {
    opacity: 0.8;
    background-color: #2F3C7E;
    color: white;
}

.btnclose:hover {
    opacity: 0.8;
    background-color: red;
    color: white;
}

/* ----------- login form---------- */
.parent {
    display: none;
    background-color: rgba(0,0,0,0.5);
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
}

.parentt {
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
}

.form-content {
    background-color: #fefefe;
    margin: 5% auto 10% auto;
    border: 1px solid #888;
    width: 40%;
}

label {
    float: left;
}

.chechbox {
    margin-bottom: 2%;
    width: 100%;
}

.form .heading {
    text-align: center;
    margin-top: 5%;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 8px;
}

.container {
    padding: 50px;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color:  #FFD132;
}

/* -------animating the form to zoom----- */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s;
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
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>

<!-- Navigation bar -->
<div class ="nav">
<a href="index.jsp"><h1>IdeaCRM</h1></a>
</div>

<!-- Description bar -->
<h3 class="heading"> Win more Deals with the world's Emerging CRM Platform</h3>

<!-- Admin and User login buttons -->
<div class="btndiv">
<h3> Please Click to Login </h3>
<button class="btn" onclick="popUp('parent','admin-login')" style="width:auto;">Admin</button>
<button class="btn" onclick="popUp('parentt','user-login')" style="width:auto;">User</button>
</div>

<!-- Content to show -->
<div class="crm-content">
<h3 class="heading">Everything you need to know about CRM</h3>
<h4 class="title">
What is CRM (customer relationship management) and what can it do for you?</h4>

<p class="para">CRM software allows businesses to manage customer and prospect relationships with data. You can store, track, and analyse customer and prospect information in one central location, including contact and account information, sales opportunities, service cases, and marketing campaigns. With data in one central location, organisations have a complete picture of customers and prospects that can be shared and analysed by teams across the company in real-time.</p>

<h3 class="heading"> Here's how Salesforce can benifit your business</h3>
<div class="benifit-component">
    <div class="head-component">
        <span class="title"> World's Emergin CRM</span>
    </div>
    <div class="content-component">
        <span class="para">Integrated platform, AI, app development, best in class apps</span>
    </div>
   
    <div class="head-component">
        <span class="title">Single Source of Truth</span>
    </div>
    <div class="content-component">
        <span class="para">Connect sales, service, marketing, commerce, and IT, personalise experiences</span>
    </div>

    <div class="head-component">
        <span class="title">Fast Time to Value</span>
    </div>
    <div class="content-component">
        <span class="para">Ease of design and implementation at speed with high ROI</span>
    </div>
    
    <div class="head-component">
        <span class="title">Scalable and Flexible</span>
    </div>
    <div class="content-component">
        <span class="para">Solutions for any size company or industry</span>
    </div>

    <div class="head-component">
        <span class="title">Trailblazer Success and Community</span>
    </div>
    <div class="content-component">
        <span class="para">96% of customers say they met or exceeded ROI expectations</span>
    </div>
</div>

<!-- Admin login form -->
<div class="parent" id="parent" onclick="closeParent('parent')">
<div id="admin-login" class="form">
    <form class="form-content animate" action="admin-dashboard" method="post">
    <h3 class="heading"> Admin Login Form </h3>
    <div class="container">
        <label for="email">Email ID: </label>
        <input type="text" placeholder="Enter Email Id" name="email" required>
        <label for="password">Password: </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <input type="hidden" value="admin" name="role">
        <div class="btndiv">
        <button class="formbtn" type="submit">Login</button>
        <button class="formbtn btnclose" type="button" onclick="closePopUp('admin-login','parent')">Cancel</button>
        </div>
    </div>
    </form>
</div>
</div>

<!-- User Login Form -->
<div class="parentt" id="parentt" onclick="closeParent('parentt')">
<div id="user-login" class="form">
    <form class="form-content animate" action="user-dashboard" method="post">
    <h3 class="heading"> User Login Form </h3>
    <div class="container">
        <label for="email">Email ID: </label>
        <input type="text" placeholder="Enter Email Id" name="email" required>
        <label for="password">Password: </label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <label class="checkbox">
            <input type="checkbox" name="role" value="manager">Manager
        </label>
        <div class="btndiv">
        <br><br><button class="formbtn" type="submit">Login</button>
        <button class="formbtn btnclose" type="button" onclick="closePopUp('user-login','parentt')">Cancel</button>
        </div>
    </div>
    </form>
</div>
</div>

<!-- A script to pop up the Form on to the Screen --!>
<script>
    function closeParent(prelem) {
	if(event.target == document.getElementById(prelem)){
		document.getElementById(prelem).style.display = "none";
	}
    }

    function popUp(elem,prelem) {
        document.getElementById(elem).style.display='block';
        document.getElementById(prelem).style.display='block';    
    }
	
    function closePopUp(elem,prelem) {
	document.getElementById(elem).style.display='none'; 
        document.getElementById(prelem).style.display='none';
    }

   
    var user = document.getElementById('user-login');
    var parr = document.getElementById('parentt');

    var admin = document.getElementById('admin-login');
    var par = document.getElementById('parent');
    window.onclick = function(event) {
        if (event.target == admin) {
            admin.style.display = "none";
            par.style.display = "none";
        } else if (event.target == user) {
           user.style.display = "none";
           parr.style.display = "none";
       }
    }
</script>
</body>
</html>