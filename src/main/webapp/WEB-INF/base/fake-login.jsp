<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Fake Login</title>
        <link href="css/login.css" rel="stylesheet">
    </head>
    <body>
        <h2>Login</h2>
        <form action="${pageContext.request.contextPath}/fake" method="post">
            <div class="data">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="jean.bon@email.com" />
            </div>
            <div class="data">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="jambon+beurre" />
            </div>
            <div class="data">
                <label for="remember">Remember me</label>
                <input type="checkbox" name="remember" id="remember">
            </div>
            <div>
                <input type="submit" value="Login" />
            </div>
        </form>
    </body>
</html>