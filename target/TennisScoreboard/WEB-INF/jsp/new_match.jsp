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
    <input type="text" id="player1" name="player1" required><br>

    <label for="player2">Имя игрока 2:</label>
    <input type="text" id="player2" name="player2" required><br>

    <input type="submit" value="Начать">
</form>
</body>
</html>