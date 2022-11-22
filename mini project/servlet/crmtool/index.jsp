<html>
<h1> CRM TOOL </h1>
<body>
<marquee direction ="left"><b>Plan Your PipeLine ! Close More Deals ! Sell Smarter ! Sell Your Products !</b></marquee><br><br>

<div class="leftdiv">
<p> Please Click any of those button to login:-</p>
<a href="UserDashboard">
    <button class="button">Manager</button>
</a>

<a href="userLogin.jsp" >
    <button class="button"> Employee </button>
</a><br>
</div>

<div class="rightdiv">
    <img src="images/crm.png" alt="Idea CRM">
</div>
</body>

<style>
.button {
    border: 3px solid black;
    background-color: #FFE39F;
    border-radius: 12px;
    padding: 20px 50px;
    box-shadow: 5px 5px 10px 2px rgba(0,0,0,.8);
}

button:hover {
    animation: btncolorchange 2s;
}

@keyframes btncolorchange {
    from {background-color: #FFE39F;}
    to {background-color: #DC7027;}
}

.leftdiv {
    float:left;
}

.rightdiv {
    float:right;
}

p {
    font-size:150%;
}

h1 { 
    text-align:center; 
}

marquee { 
    background-color: #DC7027;
    font-size: 150%;
    animation: colorchange 12s infinite;
}

@keyframes colorchange {
    from {background-color: #DC7027;}
    to {background-color: #90CCF4;}
}

a {
     margin: 100px;
}

body {
    background-color: #FFE39F;
}
</style>
</html>