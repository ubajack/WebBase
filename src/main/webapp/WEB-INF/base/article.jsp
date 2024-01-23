<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Dashboard</title>
        <link href="css/article.css" rel="stylesheet">
    </head>
    <body>
        <h2>You are connected</h2>
        <form action="${pageContext.request.contextPath}/article" method="post" enctype="multipart/form-data">
            <div class="data">
                <label for="image">Please, choose an image:</label>
                <input type="file" id="image" name="image" accept="image/png, image/jpeg" />
            </div>
            <p class="error">${error}</p>
            <div class="data">
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" value="${description}" placeholder="Super article..." />
            </div>
            <img width="200" src="img/${imageName}" onerror="this.src='img/default-image.jpg'" />
            <div>
                <input type="submit" value="Upload" />
            </div>
        </form>
    </body>
</html>