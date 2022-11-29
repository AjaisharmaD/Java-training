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
    background-color: #FBEAEB;
}

.nav {
    background-color: #FFD132;
    color: black;
    font-weight: bold;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    width: 25%;
}

a {
    text-decoration: none;
    color: black;
}

.nav:hover {
    background-color: #2F3C7E;
    color: white;
}

.content {
    color: white;
    display: none;
    padding: 100px 20px;
    height: 100%;
}

#Lead {
    background-color: #FBEAEB;
    color: black; 
}

#Account {   
    background-color: #FBEAEB;
    color: black; 
}

#Contact {
    background-color: #FBEAEB;
    color: black; 
}

#Opportunity {
    background-color: #FBEAEB;
    color: black; 
}

table {
    padding: 5% 10%;
    width:100%;
}

th {
    background-color: #89CFF0;
}

td {
    text-align: center;
    height: 30px;
}
</style>
</head>
<body>
<h1> Welcome ${name} </h1>
<button class="nav" id="navbar" onclick="openTab('Lead', this, '#2F3C7E')">Lead</button>
<button class="nav" id="navbar" onclick="openTab('Contact', this, '#2F3C7E')">Contact</button>
<button class="nav" onclick="openTab('Account', this, '#2F3C7E')">Account</button>
<button class="nav" onclick="openTab('Opportunity', this, '#2F3C7E')">Opportunity</button>

<div id="Lead" class="content">
    <h3>Details of the Leads</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email Id</th>
        <th>Phone Number</th>
        <th>Company name</th>
        <th>Status</th>
    </tr>
<c:forEach var="lead" items="${leads}">
    <tr>
        <td><c:out value='${lead.getId()}'/></td>
        <td>${lead.getName()}</td>
        <td>${lead.getEmailId()}</td>
        <td>${lead.getPhoneNumber()}</td>
        <td>${lead.getCompanyName()}</td>
        <td>${lead.getStatus()}</td>
    </tr>
</c:forEach>
</table>
</div>

<div id="Account" class="content">
    <h3>Account</h3>
    <p> Account details table</p>
</div>

<div id="Contact" class="content">
    <h3>Contact</h3>
    <p> Contact details table </p>
</div>

<div id="Opportunity" class="content">
    <h3>Opportunity</h3>
    <p>Opporunity details table </p>
</div>
<script src = "https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function openTab(pageName, elmnt, color) {
  var i, content, nav;
  content = document.getElementsByClassName("content");
  console.log(content);
  for (i = 0; i < content.length; i++) {
    content[i].style.display = "none";
  }
  nav = document.getElementsByClassName("nav");
  for (i = 0; i < nav.length; i++) {
    nav[i].style.backgroundColor = "";
  }

  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
  elmnt.style.color = "White" 
if (pageName=='Lead') {
       ajaxCall();
}

}

function ajaxCall() {
$.ajax ({
    url : 'leads',
    type: 'GET',
    
    success: function (data) {
        var x = JSON.stringify(data);
        console.log(x);
    }
});
}
</script>
</body>

</html>
