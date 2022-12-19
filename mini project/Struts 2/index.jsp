<%@ taglib uri="/struts-tags" prefix="s" %>  
<html>
<s:form action="Login">  
<s:textfield name="id" label="Email Id"></s:textfield>  
<s:textfield name="first_name" label="First Name"></s:textfield>  
<s:textfield name="password" label="Password"></s:textfield>  
<s:submit value="save"></s:submit>  
</s:form>  
</html>