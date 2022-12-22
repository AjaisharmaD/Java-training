<!-- Employee Dashboard of the CRM Tool -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
    margin: 0;
    padding: 0 0;
}

/* --------- Navigation bar ------------- */
.nav {
    background-color: #FFD132;
    font-weight: bold;
    display: flex;
    align-items: center;
    position: fixed;
    width: 100%;
}

.head-bar {
    background-color: #FFD132;
    font-weight: bold;
    display: inline-flex;
    align-items: center;
    width: 100%;
    padding-top: 5%;
}

.nav-left {

}
.nav-right {
    margin-right: 20px;
}

a {
    text-decoration: none;
    color: black;
    width: 15%;
    padding: 1%;
    text-align: center;
    font-size: 20px;
}

a:hover {
    background-color: #2F3C7E;
    color: white;
}

.title {
    margin: auto;
}

/* --------- Table -----------*/
.table-title {
    font-weight: bold;
    margin: auto;
    padding-top: 5%;
    font-size: 25px;
    width: 14%;
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

</style>
<div class="nav">
    <a href="get-leads" class="">Lead</a>
    <a href="get-accounts">Account</a>
    <h1 class="title">Employee Dashboard</h1>
    <a href="get-contacts">Contact</a>
    <a href="get-opportunity">Opportunity</a>
</div>
</head>
<body>
<!-- Navigation bar -->

<c:choose>
    <c:when test="${path == '/get-leads'}">
        <script>
            document.getElementById('lead-dashboard').style.disply = "block";
        </script>
    </c:when>
    <c:when test="${path == '/get-accounts'}">
        <script>
            document.getElementById('account-dashboard').style.disply = "block";
        </script>
    </c:when>
    <c:when test="${path == '/get-contacts'}">
        <script>
            document.getElementById('contact-dashboard').style.disply = "block";
        </script>
    </c:when>
    <c:when test="${path == '/get-opportunities'}">
        <script>
            document.getElementById('opportunity-dashboard').style.disply = "block";
        </script>
    </c:when>
</c:choose>

    <div class = "head-bar">    
        <div class="nav-left">    
            <a href="index.jsp"><buton class="btn">HOME</button></a>
            <a href="get-profile">
            <button class="btn" onclick="popUp('parent','create-form')">CREATE USER</button>
            </a>
        </div>
        <div class="title">
            <h1> Details of Leads </h1>
        </div>
        <div class="nav-right">  
            <form action = "search-user" name = "searchForm" id = "search_form" method="GET"> 
                <input type="hidden" value="search-user" name = "path">
                <input class="search-box" type="text" name="id" id = "id" placeholder="Enter Id">
                <input class="btn search-btn" type="submit" value= "Search">
            </form>
        </div>
    </div>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email Id</th>
            <th>Phone Number</th>
        </tr>
     <c:choose>
     <c:when test = "${not empty leads}">
        <c:forEach items="${leads}" var="lead">
        <tr>
            <td>${lead.getId()}</td>
            <td>${lead.getName()}</td>
            <td>${lead.getEmailId()}</td>
            <td>${lead.getPhoneNumber()}</td>
        </tr>
        </c:forEach>
     </c:when>
     </c:choose>
    </table>
</body>
</html>
