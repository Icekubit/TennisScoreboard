<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--    <head>--%>
<%--        <meta charset="UTF-8">--%>
<%--        <title>Match score</title>--%>
<%--        <link rel="stylesheet" href="/css/match-score-style.css">--%>
<%--    </head>--%>
<%--    <body>--%>
<%--        <div class="top-menu">--%>
<%--            <a class="top-menu-link" href="/">HOME</a>--%>
<%--            <a class="top-menu-link" href="/new-match">NEW</a>--%>
<%--            <a class="top-menu-link" href="/matches">MATCHES</a>--%>
<%--        </div>--%>
<%--        <div class="page-content">--%>
<%--            <h1>Match score</h1>--%>
<%--            <div class="table-container">--%>
<%--                <table class="table">--%>
<%--                    <thead>--%>
<%--                        <tr>--%>
<%--                            <th>Player</th>--%>
<%--                            <th>Sets</th>--%>
<%--                            <th>Games</th>--%>
<%--                            <th>Points</th>--%>
<%--                        </tr>--%>
<%--                    </thead>--%>
<%--                    <tbody>--%>
<%--                        <tr>--%>
<%--                            <td>${match.getFirstPlayerName()}</td>--%>
<%--                            <td>${match.getMatchScore().getPlayerScore(0)}</td>--%>
<%--                            <td>${match.getMatchScore().getCurrentSet().getPlayerScore(0)}</td>--%>
<%--                            <td>${match.getMatchScore().getCurrentSet().getCurrentGame().getPlayerScore(0).getPointCode()}</td>--%>
<%--                        </tr>--%>
<%--                        <tr>--%>
<%--                            <td>${match.getSecondPlayerName()}</td>--%>
<%--                            <td>${match.getMatchScore().getPlayerScore(1)}</td>--%>
<%--                            <td>${match.getMatchScore().getCurrentSet().getPlayerScore(1)}</td>--%>
<%--                            <td>${match.getMatchScore().getCurrentSet().getCurrentGame().getPlayerScore(1).getPointCode()}</td>--%>
<%--                        </tr>--%>
<%--                    </tbody>--%>
<%--                </table>--%>
<%--                <form method="post" action="/match-score?uuid=${param.uuid}">--%>
<%--                    <button class="player-one-button" type="submit" name="pointHandler" value="0">Player 1 wins point</button>--%>
<%--                    <button class="player-two-button" type="submit" name="pointHandler" value="1">Player 2 wins point</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </body>--%>
<%--</html>--%>

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
                <td>${match.getFirstPlayerName()}</td>
                <td>${match.getWinningSetsOfFirstPlayer()}</td>
                <td>${match.getWinningGamesOfFirstPlayer()}</td>
                <td>${match.getPointsOfFirstPlayer()}</td>
            </tr>
            <tr>
                <td>${match.getSecondPlayerName()}</td>
                <td>${match.getWinningSetsOfSecondPlayer()}</td>
                <td>${match.getWinningGamesOfSecondPlayer()}</td>
                <td>${match.getPointsOfSecondPlayer()}</td>
            </tr>
            </tbody>
        </table>
        <form method="post" action="/match-score?uuid=${param.uuid}">
            <button class="player-one-button" type="submit" name="pointHandler" value="0">Player 1 wins point</button>
            <button class="player-two-button" type="submit" name="pointHandler" value="1">Player 2 wins point</button>
        </form>
    </div>
</div>
</body>
</html>
