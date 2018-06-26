<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.05.2018
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>


<%@ page import="java.util.List" %>
<%@ page import="model.entity.Product" %>


<%@ page isELIgnored="false" %>
<fmt:setBundle basename="locale"/>

<!DOCTYPE html>

<head>

    <title>Product</title>
    <%-- <%@ include file="/jsp/common/header.jsp" %>--%>
    <%@ include file="/jsp/common/header.jsp" %>
</head>
<body>

<div class="wrapper">
    <form name="loginForm" method="POST" action="/controller">
        <input type="hidden" name="command" value="bought"/>

        <c:forEach items="${cart.list}" var="product">
            <ul>


                <li>Ptoduct: ${product} $</li>

            </ul>


        </c:forEach>
        <ul>

            <li>All sum Ptoducts: ${cart.priceSumm} $</li>

        </ul>
        <div class="buttons">

            <span class="button"><input type="submit" value="buy">buy ....</span>
        </div>

    </form>

</div>

<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>

</body>
</html>
