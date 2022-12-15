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
    font-weight: bold;
    display: flex;
    align-items: center;
    padding: 1%;
}

.right-nav {
    float: right;
}

a {
    color: black;
    text-decoration: none;
}

.title {
    margin: auto;
}

/* --------- Buttons --------- */
.btn {
    border: none;
    background-color: #FFD132;
    color: black;
    padding: 10px;
    font-weight: bold;
    border-radius: 10px;
}

.btn:hover {
    background-color: #2F3C7E;
    color: white;
}

.search-btn {
    border: 2px solid #2F3C7E;
}

.btndiv {
    padding: 10px;
}

.form-btn {
    border: none;
    background-color: #FFD132;
    color: black;
    padding: 10px;
    font-weight: bold;
    border-radius: 8px;
    width: 49.5%;
}

.login-btn:hover {
    background-color: green;
    color: white;
}

.close-btn:hover {
    background-color: red;
    color: white;
}

/* ----------- Input Box -----------*/
.form-input, select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    border-radius: 8px;
}

.select-role {
    background-color: white;
    font-weight: bold;
}

/* ----------- Description Bar ------------ */
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

.sub-para {
    font-size: 16px;
    text-align: center;
    line-height: 25px;
}

.para {
    font-size: 16px;
    text-align: center;
    line-height: 25px;
    padding:0 20%;
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

/* ----------- Form Styles ---------- */
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

.form .heading {
    text-align: center;
    padding-top: 20px;
}

.container {
    padding: 30px;
    padding-top: 20px;
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
    <div class="title">
         <a href="index.jsp"><h1>IdeaCRM</h1></a>
    </div>
    <div class="right-nav">
    <button class="btn" onclick="popUp('parent','login-form')" style="width:auto;">LOGIN</button>
    </div>
</div>

<!-- Description bar -->
<h3 class="heading"> Win more Deals with the world's Emerging CRM Platform</h3>

<h3 style="color:red; text-align: center;">${message}</h3>

<!-- Content to show -->
<div class="crm-content">
    <h3 class="heading">Everything you need to know about CRM</h3>
    <h4 class="title">What is CRM (customer relationship management) and what can it do for you?</h4>

    <p class="para">CRM software allows businesses to manage customer and prospect relationships with data. You can store, track, and analyse customer and prospect information in one central location, including contact and account information, sales opportunities, service cases, and marketing campaigns. With data in one central location, organisations have a complete picture of customers and prospects that can be shared and analysed by teams across the company in real-time.</p>

    <h3 class="heading"> Here's how Salesforce can benifit your business</h3>
        <div class="benifit-component">
            <div class="head-component">
                <span class="title"> World's Emergin CRM</span>
            </div>
            <div class="content-component">
                <span class="sub-para">Integrated platform, AI, app development, best in class apps</span>
            </div>
   
            <div class="head-component">
                 <span class="title">Single Source of Truth</span>
            </div>
            <div class="content-component">
                 <span class="sub-para">Connect sales, service, marketing, commerce, and IT, personalise experiences</span>
            </div>

            <div class="head-component">
                <span class="title">Fast Time to Value</span>
            </div>
            <div class="content-component">
                <span class="sub-para">Ease of design and implementation at speed with high ROI</span>
            </div>
    
            <div class="head-component">
                <span class="title">Scalable and Flexible</span>
            </div>
            <div class="content-component">
                <span class="sub-para">Solutions for any size company or industry</span>
            </div>

            <div class="head-component">
                <span class="title">Trailblazer Success and Community</span>
            </div>
            <div class="content-component">
                <span class="sub-para">96% of customers say they met or exceeded ROI expectations</span>
            </div>
        </div>
</div>

<!-- User Login Form -->
<div class="parent" id="parent" onclick="closeParent('parent')">
<div id="login-form" class="form">
    <form class="form-content animate" action="login" method="post">
    <h3 class="heading"> User Login Form </h3>
    <div class="container">
        <input type="hidden" name = "path" value = "login">
        <label for="email">Email ID:</label>
        <input class="form-input" type="text" placeholder="Enter Email Id" name="email" required>
        <label for="password">Password:</label>
        <input class="form-input" type="password" placeholder="Enter Password" name="password" required>
        <div class="btndiv">
        <button class="form-btn login-btn" type="submit">Login</button>
        <button class="form-btn close-btn" type="button" onclick="closePopUp('login-form','parent')">Cancel</button>
        </div>
    </div>
    </form>
</div>
</div>

<c:if test="${wrong ne null}">
    popUp('parent','error-form')
</c:if>

<!-- Login Error Form -->
<div class="parent" id="parent" onclick="closeParent('parent')">
<div id="login-form" class="form">
    <form class="form-content animate" action="user-login" method="post">
    <h3 class="heading"> Message </h3>
    <div class="container">
        <h1 class="message">${message}</h1>
        <div class="btndiv">
        <button class="form-btn close-btn" type="button" onclick="closePopUp('error-form','parent')">Cancel</button>
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

    function popUp(elem, prelem) {
        document.getElementById(elem).style.display='block';
        document.getElementById(prelem).style.display='block';    
    }
	
    function closePopUp(elem, prelem) {
	document.getElementById(elem).style.display='none'; 
        document.getElementById(prelem).style.display='none';
    }

    var login = document.getElementById('login-form');
    var par = document.getElementById('parent');
    window.onclick = function(event) {
        if (event.target == login) {
            login.style.display = "none";
            par.style.display = "none";
        } 
    }
</script>
</body>
</html>