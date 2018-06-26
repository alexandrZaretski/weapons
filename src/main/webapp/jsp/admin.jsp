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
    <title>Login</title>
    <%@ include file="/jsp/common/header.jsp" %>
</head>
<body>


<ul >
    <c:forEach items="${table}" var="elem">



        <li class="col1"> ${elem} $</li>


    </c:forEach>
</ul>

<form name="adminForm" method="GET" action="/controller">
    <input type="hidden" name="command" value="admin"/>
    <input type="hidden" name="show" value="ShowAllUsers"/>
    Здесь будут USERS
    <input type="submit" name="" value="ShowAllUsers">
</form>

<form name="adminForm" method="GET" action="/controller">

    <input type="hidden" name="command" value="admin"/>
    <input type="hidden" name="show" value="deletUserById"/>
    Delete user by Id <input type="text" name="idUser" value=""/>
    <input type="submit" name="" value="deletUserById">

</form>
<form name="adminForm" method="GET" action="/controller">

    <input type="hidden" name="command" value="admin"/>
    <input type="hidden" name="show" value="ShowTransactonByDates"/>
    Show Transacton by dates
    Date start:
    <input type="text" name="DateStart" value=""/>
    Date finish
    <input type="text" name="DateFinish" value=""/>

    <input type="submit" name="" value="ShowTransactonByDates">

</form>


<form name="adminForm" method="GET" action="/controller">
    Show Transacton by user id.
    <input type="hidden" name="command" value="admin"/>
    <input type="hidden" name="show" value="ShowTransactonByUserId"/>
    id User<input type="text" name="UserId" value=""/>
    <input type="submit" name="" value="ShowTransactonByUserId">

    <f4> ${errorAdminDate}</f4>


    <c:import url="/jsp/common/footer.jsp"/>
</body>
</html>