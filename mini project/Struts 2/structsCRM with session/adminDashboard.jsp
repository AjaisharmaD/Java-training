<!-- Admin page of the CRM Tool where admin can do CRUD on USERS -->
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
    position: fixed;
    width: 100%;
    padding: 1%;
}

.nav-right {
    margin-right: 20px;
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
.table-title {
    font-weight: bold;
    text-align: center;
    padding-top: 6%;
    font-size: 25px;
}

table {
    width:100%;
    padding: 5%;
    padding-top: 1%;
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
        <a href="get-profile">
        <button class="btn" onclick="popUp('parent','create-form')">CREATE USER</button>
        </a>
    </div>
    <div class="title">
        <h1> Admin Dashboard </h1>
    </div>
    <div class="nav-right">  
        <form action = "search-user" name = "searchForm" id = "search_form" method="GET"> 
            <input type="hidden" value="search-user" name = "path">
            <input class="search-box" type="text" name="id" id = "id" placeholder="Enter Id">
            <input class="btn search-btn" type="submit" value= "Search">
        </form>
    </div>
</div>

<h3 style="color:red; text-align:center;">${message}</h3>

<div class="table">
    <table>
        <caption class="table-title"> DETAILS OF USERS </caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email Id</th>
            <th>Phone Number</th>
            <th>Role</th>
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
            <td>
                <c:choose>
                <c:when test="${user.getRoleId() == 2}">
                    <option>manager</option>
                </c:when>
                <c:when test="${user.getRoleId() == 3}">
                    <option>employee</option>
                </c:when>
                </c:choose>
            </td>
            <td>${user.getCreatedDate()}</td>
        </tr>
        </c:forEach>
     </c:when>
     </c:choose>
    </table>
</div>

<p>${user}</P>

<!-- Create From -->
<div class="parent" id="parent" onclick="closeParent('parent')">
<div id="create-form" class="form">
    <form class="form-content animate" action="create-user" method="post">
    <h3 class="heading"> Create User Form </h3>

    <div class="container">
        <input type="hidden" value="create-user" name = "path">
        <label for="name">Name:</label>
            <input class="form-input" type="text" placeholder="Enter Name" name="name" required>
        <label for="email">Email ID:</label>
            <input class="form-input" type="text" placeholder="Enter Email Id" name="email" required>
        <label for="phone">Phone Number:</label>
            <input class="form-input" type="text" placeholder="Enter Phone Number" name="phone" required>
        <label for="password">Password:</label>
            <input class="form-input" type="password" placeholder="Enter Password" name="password" required>
        <label for="roles">Role:</label>
        <select class="select-role" id="roles" name ="role">
            <c:forEach items="${roles}" var="role">
                <option value="${role}">${role}</option>
            </c:forEach>
        </select>

        <div class="btndiv">
            <button class="form-btn create-btn" type="submit">Create</button>
            <input class="form-btn reset-btn" type="reset" value="Reset">
            <a href="get-users">
                <button class="form-btn close-btn" type="button" onclick="closePopUp('create-form','parent')">Cancel</button>
            </a>
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
    window.onclick = function(event) {
        if (event.target == admin) {
            admin.style.display = "none";
            par.style.display = "none";
        } 
    }
</script>
</body>
</html>