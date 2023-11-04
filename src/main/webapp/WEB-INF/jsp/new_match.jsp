<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Форма для нового матча</title>
</head>
<body>
<form method="post" action="/new-match">
    <label for="player1">Имя игрока 1:</label>
    <input type="text" id="player1" name="player1" required>
    <c:if test="${isTheSameNames}">
        <span style="color: red;">The names should be different</span>
    </c:if>
    <br>

    <label for="player2">Имя игрока 2:</label>
    <input type="text" id="player2" name="player2" required>
    <c:if test="${isTheSameNames}">
        <span style="color: red;">The names should be different</span>
    </c:if>
    <br>

    <input type="submit" value="Начать">
</form>
</body>
</html>