<html>
<head>
<style>
* {
    margin: 0px;
    padding: 0px 0px;
}

.nav {
  background-color: #555;
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 25%;
}

.nav:hover {
    backgroound-color: #777;
}

.content {
  color: white;
  display: none;
  padding: 100px 20px;
  height: 100%;
}

#Lead {
    background-color: red;
}

#Account {
    background-color: blue;
}

#Contact {
    background-color: green;
}

#Opportunity {
    background-color: yellow;
}
</style>
</head>
<h1> Welcome ${name} </h1>
<button class="nav" onclick="openTab('Lead', this, 'red')" formaction="get-lead">Lead</button>
<button class="nav" onclick="openTab('Contact', this, 'green')">Contact</button>
<button class="nav" onclick="openTab('Account', this, 'blue')">Account</button>
<button class="nav" onclick="openTab('Opportunity', this, 'yellow')">Opportunity</button>

<div id="Lead" class="content">
    <h3>Lead</h3>
    <p> Lead details table 
        ${leads} </p>
    
</div>

<div id="Account" class="content">
    <h3>Account</h3>
    <p> Account details table </p>
</div>

<div id="Contact" class="content">
    <h3>Contact</h3>
    <p> Contact details table </p>
</div>

<div id="Opportunity" class="content">
    <h3>Opportunity</h3>
    <p>Opporunity details table </p>
</div>

<script>
function openTab(pageName,elmnt,color) {
  var i, content, nav;
  content = document.getElementsByClassName("content");
  for (i = 0; i < content.length; i++) {
    content[i].style.display = "none";
  }
  nav = document.getElementsByClassName("nav");
  for (i = 0; i < nav.length; i++) {
    nav[i].style.backgroundColor = "";
  }
  document.getElementById(pageName).style.display = "block";
  elmnt.style.backgroundColor = color;
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
</html>
