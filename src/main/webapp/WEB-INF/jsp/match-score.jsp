<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Форма для нового матча</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Счёт: ${match.getScore()}</h1>--%>
<%--<br>--%>
<%--<h1>Игрок 1: ${firstPlayer}</h1>--%>
<%--<br>--%>
<%--<h1>Игрок 2: ${secondPlayer}</h1>--%>
<%--    <form method="post" action="/match-score?uuid=${matchId}">--%>
<%--        <input type="hidden" name="firstPlayer" value="${firstPlayer}">--%>
<%--        <input type="hidden" name="secondPlayer" value="${secondPlayer}">--%>
<%--        <button type="submit" name="id" value=${match.getFirstPlayerId()}>Кнопка 1 (id=1)</button>--%>
<%--    </form>--%>

<%--    <form method="post" action="/match-score?uuid=${matchId}">--%>
<%--        <input type="hidden" name="firstPlayer" value="${firstPlayer}">--%>
<%--        <input type="hidden" name="secondPlayer" value="${secondPlayer}">--%>
<%--        <button type="submit" name="id" value=${match.getSecondPlayerId()}>Кнопка 2 (id=2)</button>--%>
<%--    </form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Форма для нового матча</title>
</head>
<body>
<h1>Счёт: ${match.getScore().winningSetsOfFirstPlayer}:${match.getScore().winningSetsOfSecondPlayer}</h1>
<h2>Геймы: ${match.getScore().winningGamesOfFirstPlayer}-${match.getScore().winningGamesOfSecondPlayer}</h2>
<h3>Очки: ${match.getScore().pointsOfFirstPlayer}-${match.getScore().pointsOfSecondPlayer}</h3>
<br>
<h1>Игрок 1: ${firstPlayer}</h1>
<h2>Геймы: ${match.getScore().winningGamesOfFirstPlayer}</h2>
<h3>Очки: ${match.getScore().pointsOfFirstPlayer}</h3>
<br>
<h1>Игрок 2: ${secondPlayer}</h1>
<h2>Геймы: ${match.getScore().winningGamesOfSecondPlayer}</h2>
<h3>Очки: ${match.getScore().pointsOfSecondPlayer}</h3>
<form method="post" action="/match-score?uuid=${matchId}">
    <input type="hidden" name="firstPlayer" value="${firstPlayer}">
    <input type="hidden" name="secondPlayer" value="${secondPlayer}">
    <button type="submit" name="id" value="${match.getFirstPlayerId()}">Кнопка 1 (id=1)</button>
</form>

<form method="post" action="/match-score?uuid=${matchId}">
    <input type="hidden" name="firstPlayer" value="${firstPlayer}">
    <input type="hidden" name="secondPlayer" value="${secondPlayer}">
    <button type="submit" name="id" value="${match.getSecondPlayerId()}">Кнопка 2 (id=2)</button>
</form>
</body>
</html>
