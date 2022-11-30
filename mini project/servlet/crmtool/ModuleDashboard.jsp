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
    width: 18%;
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
    background-color: red;
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
<a class="nav" href="get-leads">Lead</a>
<a class="nav" href="get-contacts">Contact</a>
<a class="nav" href="get-accounts">Account</a>
<a class="nav" href="get-opportunities">Opportunity</a>
</body>
</html>
