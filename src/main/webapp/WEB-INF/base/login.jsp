<%@ page language="java" session="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <h2>Welcome to login page</h2>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="data">
                <input type="checkbox" name="valid" id="valid" />
                <label for="valid">Valid login</label>
            </div>
            <div>
                <input type="submit" value="Log In" />
            </div>
        </form>
        <p class="error">${error}</p>
    </body>
</html>