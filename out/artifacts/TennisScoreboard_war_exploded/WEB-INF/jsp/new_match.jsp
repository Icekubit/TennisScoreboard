<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>New match</title>
        <link rel="stylesheet" href="/css/new-match-style.css">
    </head>
    <body>
        <div class="top-menu">
            <a class="top-menu-link" href="/">HOME</a>
            <a class="top-menu-link" href="/new-match">NEW</a>
            <a class="top-menu-link" href="/matches">MATCHES</a>
        </div>
        <div class="page-content">
            <h1 class="page-content-title">Enter the names of players</h1>
            <form method="post" action="/new-match">
                <div class="label-with-input">
                    <label for="player1">Player 1:</label>
                    <input type="text" id="player1" name="player1" required>
                    <c:if test="${isTheSameNames}">
                        <span style="color: red;">The names should be different</span>
                    </c:if>
                </div>
                <div class="label-with-input">
                    <label for="player2">Player 2:</label>
                    <input type="text" id="player2" name="player2" required>
                    <c:if test="${isTheSameNames}">
                        <span style="color: red;">The names should be different</span>
                    </c:if>
                </div>
                <input class="submit-button" type="submit" value="Start">
            </form>
        </div>
    </body>
</html>