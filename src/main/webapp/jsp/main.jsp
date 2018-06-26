<%--
  Created by IntelliJ IDEA.
  User: admindi
  Date: 24.12.2017
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h3>Welcome</h3>
    <hr/> ${user}, hello! <hr/>
    <form name="loginForm" method="POST" action="controller">
    <input type="hidden" name="command" id="logout"/>
    <br/>
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
