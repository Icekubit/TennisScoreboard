<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String score = (String) request.getAttribute("score"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Форма для нового матча</title>
</head>
<body>
<h1>Счёт: <%= score %></h1>
<form method="post" action="/match-score">
    <form method="post" action="your-servlet-url">
        <button type="submit" name="id" value="1">Кнопка 1 (id=1)</button>
    </form>

    <form method="post" action="your-servlet-url">
        <button type="submit" name="id" value="1">Кнопка 1 (id=1)</button>
    </form>
</form>
</body>
</html>
