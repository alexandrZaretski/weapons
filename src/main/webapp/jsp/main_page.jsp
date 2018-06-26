<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.Statement" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/home.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Contact directory:</title>
    <%@ include file="common/header.jsp" %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3 msf-title">
            <h1><strong>Contacts</strong></h1>
        </div>
    </div>

    <c:choose>

        <c:otherwise>
            <form method="post" action="/main/delete" name="deleteForm" id="main-form">
                <table class="table table-margin">
                    <thead>
                    <tr>
                        <th></th>
                        <th><strong class="lab">Name</strong></th>
                        <th><strong class="letter">Date</strong></th>
                        <th><strong class="letter">Address</strong></th>
                        <th><strong class="letter">Work Place</strong></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${contactsList}" var="contact">
                        <tr>
                            <td><input type="checkbox" name="selectedContacts" value="${contact.id}"></td>
                            <td><a href="/main/edit?contact=${contact.id}"><strong class="lab"><c:out
                                    value="${contact.name} "/><c:out
                                    value="${contact.surname}"/></strong></a></td>
                            <td><strong class="letter"><c:out value="${contact.date}"/></strong></td>
                            <td><strong class="letter"><c:out value="${contact.address}"/></strong></td>
                            <td><strong class="letter"><c:out value="${contact.workPlace}"/></strong></td>
                            <td><input type="button" class="btn2" value="Edit" name="${contact.id}"
                                       onclick="document.location.href='/main/edit?contact=${contact.id}'"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="row">
                    <div class="col-md-offset-3 col-md-4">
                        <input type="button" name="button" class="btn1" value="Delete"
                               onclick="setDeleteAction(${flag})"/>
                    </div>
                    <div class="col-md-4"><input type="button" class="btn1" name="button1" value="Send"
                                                 onclick="setSendAction()"/>
                    </div>
                </div>
            </form>
            <div class="row">
                <div class="col-md-3">
                    <ul class="pagination">

                        <li><a href="/main/info?page=${page+1}&search=true" value=""><c:out value="${page+1}"/></a>

                        <li><a href="/main/info?page=${page+1}" value=""><c:out value="${page+1}"/></a>

                    </ul>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>


</body>

</html>
