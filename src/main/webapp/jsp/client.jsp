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
   <%--<link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>">--%>
      <%-- <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700" rel="stylesheet">
       <link href="css/demo.css" rel="stylesheet">
       <link href="css/style.css" rel="stylesheet">--%>
    <title>Product</title>
   <%-- <%@ include file="/jsp/common/header.jsp" %>--%>
       <%@ include file="/jsp/common/header.jsp" %>
</head>
<body>
<%
   // List<Product> clients =(List<Product>) session.getAttribute("Products");%>
<div class="wrapper">
    <form name="loginForm" method="POST" action="/controller">
        <input type="hidden" name="command" value="cart"/>

<c:forEach items="${Products}" var="client" >
    <ul >
        <li><img src="/images/${client.id}.jpg" alt=""></li>
    <li>id: ${client.id}</li>
    <li>name: ${client.name}</li>
    <li>cost: ${client.price} $</li>
    <li>Add to cart <input type="checkbox" name="idProduct" value="${client.id}" id="client.id"/></li>
    </ul>


</c:forEach>
        <h5 style="color: red"> ${errorNotPuy}</h5>
    <div class="buttons">

        <span class="button"><input type="submit" value="buy">buy and go to cart</span>
    </div>

    </form>

</div>


<c:import url="/jsp/common/footer.jsp" />
</body>
</html>
