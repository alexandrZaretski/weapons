<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>

    <title>header</title>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/login.jsp">Main Page</a>
        </div>
        <ul class="nav navbar-nav">

            <li><a href="/jsp/common/contacts.jsp">Contact</a></li>
            <li><a href="/jsp/common/about.jsp">About</a></li>
            <li><a href="${cartJsp}">${messagesCart}</a></li>
            <li>
            ${Logout}
            <li>
            <li><h4 style="color: red">${userName} </h4>
            <li>


        </ul>

    </div>


    <%--<select class="select-lang" name="locale_language" onchange="this.form.submit()">--%>
    <%--<option value="en_US" selected="">Language</option>--%>
    <%--<option value="en_US">English</option>--%>
    <%--<option value="ru_RU">Русский</option>--%>
    <%--</select>--%>


</nav>
</body>
</html>
