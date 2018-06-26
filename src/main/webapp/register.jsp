<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<%@ page isELIgnored="false" %>
<fmt:setBundle basename="locale"/>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>">
    <title>Sign up</title>
    <%@ include file="/jsp/common/header.jsp" %>
</head>
<body>
<h4><b><fmt:message key="jsp.register.registration"/> </b></h4>
<hr/>
<form name="signForm" method="POST" action="/controller">

    <input type="hidden" name="command" value="sign_up"/>
    <fmt:message key="jsp.register.firstname"/><br/>
    <label>
        <input type="text" name="first_name" value="" required pattern="\w+"/>
    </label>
    phone
    <label>
        <input type="text" name="phone" value="" required pattern="\w+"/>
    </label>
    adress
    <label>
        <input type="text" name="adress" value=""/>
    </label>


    <br/><fmt:message key="jsp.register.email"/><br/>
    <label>
        <input type="text" name="email" value="" required pattern="^([a-z0-9_.-]+)@([a-z0-9_.-]+)\.([a-z.]{2,6})$"/>
    </label>

    <br/><fmt:message key="jsp.register.password"/><br/>
    <label>
        <input type="password" name="password" value="" required pattern="\w+"/>
    </label>
    <br/>

    <br/>
    <lable>
        <input type="submit" value="<fmt:message key = "jsp.login.submit" />">
    </lable>
    <br/>
    ${errorLoginPassMessage} <br/> ${wrongAction} <br/> ${nullPage} <br/>
</form>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>