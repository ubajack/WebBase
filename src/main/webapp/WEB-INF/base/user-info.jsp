<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>User infos</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <h2>Your informations</h2>
        <p>Email: ${email}</p>
        <p>Password: ${password}</p>
        <p>Generated token: ${token}</p>

        <button>
            <a href="${pageContext.request.contextPath}/">Home</a>
        </button>
    </body>
</html>