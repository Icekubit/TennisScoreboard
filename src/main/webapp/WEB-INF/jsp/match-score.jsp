<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Match score</title>
    <link rel="stylesheet" href="/css/match-score.css">
</head>
<body>
<div class="top-menu">
    <a href="/"><button>HOME</button></a>
    <a href="/new-match"><button>NEW</button></a>
    <a href="/matches"><button>MATCHES</button></a>
</div>
    <h1>Match score</h1>
    <div class="table-container">
        <table>
            <tr>
                <th>Player</th>
                <th>Sets</th>
                <th>Games</th>
                <th>Points</th>
            </tr>
            <tr>
                <td>${firstPlayer}</td>
                <td>${match.getScore().winningSetsOfFirstPlayer}</td>
                <td>${match.getScore().winningGamesOfFirstPlayer}</td>
                <td>${match.getScore().pointsOfFirstPlayer}</td>
            </tr>
            <tr>
                <td>${secondPlayer}</td>
                <td>${match.getScore().winningSetsOfSecondPlayer}</td>
                <td>${match.getScore().winningGamesOfSecondPlayer}</td>
                <td>${match.getScore().pointsOfSecondPlayer}</td>
            </tr>
        </table>
    </div>

    <div class="button-container">
        <div class="button-left">
            <form method="post" action="/match-score?uuid=${matchId}">
                <input type="hidden" name="firstPlayer" value="${firstPlayer}">
                <input type="hidden" name="secondPlayer" value="${secondPlayer}">
                <button type="submit" name="id" value="${match.getFirstPlayerId()}">Player 1 wins point</button>
            </form>
        </div>

        <div class="button-right">
            <form method="post" action="/match-score?uuid=${matchId}">
                <input type="hidden" name="firstPlayer" value="${firstPlayer}">
                <input type="hidden" name="secondPlayer" value="${secondPlayer}">
                <button type="submit" name="id" value="${match.getSecondPlayerId()}">Player 2 wins point</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
