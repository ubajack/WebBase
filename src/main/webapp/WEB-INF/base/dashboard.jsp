<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dashboard</title>
        <link href="css/dashboard.css" rel="stylesheet">
    </head>
    <body>
        <h2>You are connected</h2>

        <button>
            <a href="${pageContext.request.contextPath}/logout">Disconnect</a>
        </button>
    </body>
</html>