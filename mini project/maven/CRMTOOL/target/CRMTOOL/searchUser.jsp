<!-- Search page which contains Update and Delete operations -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
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

.form-btn {
    border: none;
    background-color: #FFD132;
    color: black;
    padding: 10px;
    margin-top: 20px;
    font-weight: bold;
    border-radius: 8px;
    width:100%;
}

.btn:hover {
    background-color: #2F3C7E;
    color: white;
}

.form-btn:hover {
    background-color: #2F3C7E;
    color: white;
}

.delete-btn {
    border: none;
    background-color: #2F3C7E;
    color: white;
    padding: 10px;
    font-weight: bold;
    border-radius: 8px;
}

.delete-btn:hover {
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

.form-content {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
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
    padding: 50px;
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

<c:choose>
<c:when test="${path == '/search-user'}">
<div class="nav">
    <div class="nav-left">    
        <a href="get-users"><button class="btn">back</button></a>
    </div>
    <div class="title">
        <h1> Search Dashboard </h1>
    </div>
    <div class="nav-right">
        <form action="delete-user">
            <input type="hidden" value="${user.getId()}" name="id">
            <button class="btn delete-btn" type="submit">Delete</button>
        </form>
    </div>
</div>

<div id="update-form" class="form">
    <form class="form-content animate" action="update-user" method="post">
    <h3 class="heading"> Update User Form </h3>

    <div class="container">
        <input type="hidden" value="update-user" name = "path">
        <label for="id">Id:</label>
            <input class="form-input" type="text" value="${user.getId()}" name="id" readonly>
        <label for="name">Name:</label>
            <input class="form-input" type="text" value="${user.getName()}" name="name" required>
        <label for="email">Email ID:</label>
            <input class="form-input" type="text" value="${user.getEmailId()}" name="email" required>
        <label for="phone">Phone Number:</label>
            <input class="form-input" type="text" value="${user.getPhoneNumber()}" name="phone" required>
        <label for="roles">Role:</label>
        <select class="select-role" id="roles" name ="role">
            <c:choose>
            <c:when test="${user.getRoleId() == 2}">
                <option selected>manager</option>
            </c:when>
            <c:when test="${user.getRoleId() == 3}">
                <option selected>employee</option>
            </c:when>
            </c:choose>
            <c:forEach items="${roles}" var="role">
                <option value="${role}">${role}</option>
            </c:forEach>
        </select>

        <div class="btndiv">
            <button class="form-btn update-btn" type="submit">Update</button>
        </div>
    <h3 style="color:red; text-align:center; ">${message}</h3>
    </div>
    </form>
</div>
</c:when>
<c:when test="${path == '/search-employee'}">
<div class="nav">
    <div class="nav-left">    
        <a href="get-employees"><button class="btn">back</button></a>
    </div>
    <div class="title">
        <h1> Search Dashboard </h1>
    </div>
    <div class="nav-right">
        <form action="delete-employee">
            <input type="hidden" value="${user.getId()}" name="id">
            <button class="btn delete-btn" type="submit">Delete</button>
        </form>
    </div>
</div>

<div id="update-form" class="form">
    <form class="form-content animate" action="update-user" method="post">
    <h3 class="heading"> Update User Form </h3>

    <div class="container">
        <input type="hidden" value="update-employee" name = "path">
        <label for="id">Id:</label>
            <input class="form-input" type="text" value="${user.getId()}" name="id" readonly>
        <label for="name">Name:</label>
            <input class="form-input" type="text" value="${user.getName()}" name="name" required>
        <label for="email">Email ID:</label>
            <input class="form-input" type="text" value="${user.getEmailId()}" name="email" required>
        <label for="phone">Phone Number:</label>
            <input class="form-input" type="text" value="${user.getPhoneNumber()}" name="phone" required>
        <label for="roles">Role:</label>
        <select class="select-role" id="roles" name ="role">
            <c:choose>
            <c:when test="${user.getRoleId() == 2}">
                <option>manager</option>
            </c:when>
            <c:when test="${user.getRoleId() == 3}">
                <option>employee</option>
            </c:when>
            </c:choose>
            <c:forEach items="${roles}" var="role">
                <option value="${role}">${role}</option>
            </c:forEach>
        </select>

        <div class="btndiv">
            <button class="form-btn update-btn" type="submit">Update</button>
        </div>
    <h3 style="color:red; text-align:center; ">${message}</h3>
    </div>
    </form>
</div>
</c:when>
</c:choose>

<!-- A script to pop up the Form on to the Screen -->
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
</script>
</body>
</html>