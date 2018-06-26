<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="locale" var="var"/>
<html>
<head>
    <title>About</title>
    <style>
        @import "/css/about.css";
    </style>

    <%@ include file="/jsp/common/header.jsp" %>
    <link rel="icon" href="/document/edit_background.jpeg" type="images/jpg">
</head>
<body>
<div class="centerTable">
    <h1>Gun shop</h1>
    <p>
        <fmt:message key="label.informationA" bundle="${var}"/>
    </p>
    <p>


</div>
<c:import url="/jsp/common/footer.jsp"/>
</body>
</html>