<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="locale" var="var"/>
<html>
<head>
    <title>Guns store</title>
    <style>
        @import "/css/contacts.css";
    </style>
    <%@ include file="/jsp/common/header.jsp" %>
</head>
<body>
<div class="centerTable">
    <h1><fmt:message key="label.headerContacts" bundle="${var}"/></h1>
    <img src="/document/picture.JPG" width="270" height="280"
         align="left" vspace="10" hspace="10">
    <p>
    <h3><fmt:message key="label.contactAddress" bundle="${var}"/></h3>
    <fmt:message key="label.contactAddressInfo" bundle="${var}"/>
    </p>
    <p>
    <h3><fmt:message key="label.contactTelephone" bundle="${var}"/></h3>
    <fmt:message key="label.telephone" bundle="${var}"/>
    </p>
    <p>
    <h3><fmt:message key="label.contactTime" bundle="${var}"/></h3>
    <fmt:message key="label.contactMnFr" bundle="${var}"/><br>
    <fmt:message key="label.contactSt" bundle="${var}"/><br>
    <fmt:message key="label.contactSn" bundle="${var}"/>
    </p>
    <p>
        </h3><fmt:message key="label.email" bundle="${var}"/>:</h3><br>
        <fmt:message key="label.emailinfo" bundle="${var}"/>
    </p>
</div>
<c:import url="/jsp/common/footer.jsp" />
</body>
</html>