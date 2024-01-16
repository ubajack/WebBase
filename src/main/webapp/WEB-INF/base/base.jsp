<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link href="css/base.css" rel="stylesheet">
    </head>
    <body>
        <h2>Animals</h2>`
        <p>Here is a list of animals:</p>
        <ul class="animals">
            <c:forEach var="item" items="${animals}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </body>
</html>