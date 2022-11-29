<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<title>Error</title>
<style>
p {
    color: red;
}

h3 {
    font-weight: bold;
}
</style>

<body>
<h3> The entered User id is not present </h3>
<p>
    Error: <%=exception.toString()%> 
</p>
</body>
</html>
