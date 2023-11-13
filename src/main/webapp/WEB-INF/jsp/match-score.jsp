<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Match score</title>
        <link rel="stylesheet" href="/css/match-score-style.css">
    </head>
    <body>
        <div class="top-menu">
            <a class="top-menu-link" href="/">HOME</a>
            <a class="top-menu-link" href="/new-match">NEW</a>
            <a class="top-menu-link" href="/matches">MATCHES</a>
        </div>
        <div class="page-content">
            <h1>Match score</h1>
            <div class="table-container">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Player</th>
                            <th>Sets</th>
                            <th>Games</th>
                            <th>Points</th>
                        </tr>
                    </thead>
                    <tbody>
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
                    </tbody>
                </table>
                <div class="player-one-button">
                    <form method="post" action="/match-score?uuid=${matchId}">
                        <input type="hidden" name="firstPlayer" value="${firstPlayer}">
                        <input type="hidden" name="secondPlayer" value="${secondPlayer}">
                        <button type="submit" name="pointHandler" value="firstPlayer">Player 1 wins point</button>
                    </form>
                </div>
                <div class="player-two-button">
                    <form method="post" action="/match-score?uuid=${matchId}">
                        <input type="hidden" name="firstPlayer" value="${firstPlayer}">
                        <input type="hidden" name="secondPlayer" value="${secondPlayer}">
                        <button type="submit" name="pointHandler" value="secondPlayer">Player 2 wins point</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
