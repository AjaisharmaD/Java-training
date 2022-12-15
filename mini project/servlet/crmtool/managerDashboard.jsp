<!-- Managaer Dashboard of the CRM tool -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

/* --------- Navigation bar ------------- */
.nav {
    background-color: #FFD132;
    font-weight: bold;
    display: flex;
    align-items: center;
    padding: 1%;
}

.nav-left {
    float: left;
    disply: inline;
}

.nav-right {
    float: right;
}

a {
    text-decoration: none;
    color: black;
}

.title {
    margin: auto
}

/* --------- Buttons --------- */
.btn {
    border: none;
    background-color: #FFD132;
    color: black;
    padding: 10px;
    border: 2px solid #2F3C7E;
    font-weight: bold;
    border-radius: 8px;
}

.btn:hover {
    background-color: #2F3C7E;
    color: white;
}

.search-btn {
    border: 2px solid #2F3C7E;
}

.form-btn {
    border: none;
    background-color: #FFD132;
    color: black;
    padding: 10px;
    font-weight: bold;
    border-radius: 8px;
    width:32%;
}

.create-btn:hover {
    background-color: green;
    color: white;
}

.reset-btn:hover {
    background-color: blue;
    color: white;
}

.close-btn:hover {
    background-color: red;
    color: white;
}
/* -------- Input box --------*/
.search-box {
    padding: 10px;
    box-sizing: border-box;
}

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

/* --------- Table -----------*/
table {
    width:100%;
    padding: 5% 10%;
}

th {
    text-align: center;
    background-color: #89CFF0;
    width: 20%;
}

td {
    text-align: center;
    height: 30px;
    border-bottom: 1px solid #89CFF0;
    width: 20%;
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
<div class="nav">
    <div class="nav-left">    
        <a href="index.jsp"><buton class="btn">HOME</button></a>
        <button class="btn" onclick="popUp('create-form', 'parent')">CREATE EMPLOYEE</button>
        <button class="btn" onclick="popUp('assign-form', 'parentt')">ASIGN LEAD</button> 
    </div>
    <div class="title">
        <h1> Manager Dashboard </h1>
    </div>
    <div class="nav-right">    
        <form action="search-employee">
            <input class="search-box" type="text" name="id" placeholder="Enter Id">
            <input class="btn search-btn" type="submit" value="Search">
        </form>
    </div>
</div>

<h3 style="color:red; text-align:center;">${status}</h3>

<div class="table">
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email Id</th>
            <th>Phone Number</th>
            <th>Created Date</th>
        </tr>
     <c:choose>
     <c:when test = "${not empty users}">
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getEmailId()}</td>
            <td>${user.getPhoneNumber()}</td>
            <td>${user.getCreatedDate()}</td>
        </tr>
        </c:forEach>
     </c:when>
     </c:choose>
    </table>
</div>

<!-- Create From -->
<div class="parent" id="parent" onclick="closeParent('parent')">
<div id="create-form" class="form">
    <form class="form-content animate" action="create-employee" method="post">
    <h3 class="heading"> Create User Form </h3>
    <div class="container">
        <label for="name">Name:</label>
            <input class="form-input" type="text" placeholder="Enter Name" name="name" required>
        <label for="email">Email ID:</label>
            <input class="form-input" type="text" placeholder="Enter Email Id" name="email" required>
        <label for="phone">Phone Number:</label>
            <input class="form-input" type="text" placeholder="Enter Phone Number" name="phone" required>
        <label for="password">Password:</label>
            <input class="form-input" type="password" placeholder="Enter Password" name="password" required>
        <input type = "hidden" value="employee" name = "role">       
        <div class="btndiv">
        <button class="form-btn create-btn" type="submit">Create</button>
        <input class="form-btn reset-btn" type="reset" value="Reset">
        <button class="form-btn close-btn" type="button" onclick="closePopUp('create-form','parent')">Cancel</button>
        </div>
    </div>
    </form>
</div>
</div>

<!-- Assign From -->
<div class="parentt" id="parentt" onclick="closeParent('parentt')">
<div id="assign-form" class="form">
    <form class="form-content animate" action="assign-lead" method="post">
    <h3 class="heading"> Create User Form </h3>
    <div class="container">
        <label for="name">Lead ID:</label>
            <input class="form-input" type="text" placeholder="Enter Lead Id" name="lead-id" required>
        <label for="email">Employee ID:</label>
            <input class="form-input" type="text" placeholder="Enter Employee Id" name="employee-id" required>      
        <div class="btndiv">
        <button class="form-btn create-btn" type="submit">Assign</button>
        <input class="form-btn reset-btn" type="reset" value="Reset">
        <button class="form-btn close-btn" type="button" onclick="closePopUp('assign-form','parentt')">Cancel</button>
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

    var admin = document.getElementById('create-form');
    var par = document.getElementById('parent');

    var assign = document.getElementById('assign-form');
    var pare = document.getElementById('parentt');
    window.onclick = function(event) {
        if (event.target == admin) {
            admin.style.display = "none";
            par.style.display = "none";
        } else if (event.target == assign) {
            assign.style.display = "none";
            pare.style.display = "none";
        }
    }
</script>
</body>
</html>