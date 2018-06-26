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


    <f2 alig="centr">Ваш заказ будет доставлен по адресу ${user.adress} . Курер с вами свяжется</f2>

    <li>All sum Ptoducts: ${cart.priceSumm} $</li>


    <c:import url="/jsp/common/footer.jsp"/>
</body>
</html>

</body>
</html>
