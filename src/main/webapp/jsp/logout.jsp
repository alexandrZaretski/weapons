
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<%@ page isELIgnored="false" %>
<fmt:setBundle basename="locale"/>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%session.invalidate(); %>

<jsp:forward page="/login.jsp"/>
</body>
</html>
