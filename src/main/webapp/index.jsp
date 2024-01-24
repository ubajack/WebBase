<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h2>Hello World!</h2>
    <a href="${pageContext.request.contextPath}/base">JSP example</a>
    <br>
    <a href="${pageContext.request.contextPath}/login">Login page</a>
    <br>
    <a href="${pageContext.request.contextPath}/article">Article</a>
    <br>
    <a href="${pageContext.request.contextPath}/fake">Fake login</a>
    </body>
</html>