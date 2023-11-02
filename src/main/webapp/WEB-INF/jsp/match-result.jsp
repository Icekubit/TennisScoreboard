<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Победитель</title>
</head>
<body>
<h1>${winner} победил!</h1>
<br>
<h1>Счёт: ${match.getScore()}</h1>
<br>
<h5>Игрок 1: ${firstPlayer}</h5>
<br>
<h5>Игрок 2: ${secondPlayer}</h5>
</body>
</html>
