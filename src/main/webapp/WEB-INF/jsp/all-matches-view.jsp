<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Finished matches</title>
        <link rel="stylesheet" href="/css/all-matches-view-style.css">
    </head>
    <body>
        <div class="top-menu">
            <a class="top-menu-link" href="/">HOME</a>
            <a class="top-menu-link" href="/new-match">NEW</a>
            <a class="top-menu-link" href="/matches">MATCHES</a>
        </div>
        <div class="page-content">
            <c:if test="${not empty param.filter_by_player_name}">
                <h1>Search results</h1>
            </c:if>
            <c:if test="${empty param.filter_by_player_name}">
                <h1>Finished matches</h1>
            </c:if>

            <div class="table-container">
                <div class="search-container">
                    <p class="search-container-item-paragraph">Name: </p>
                    <form action="/matches?${filter_by_player_name}" method="get">
                        <input class="search-container-input-text" type="text" name="filter_by_player_name" value="${param.filter_by_player_name}" />
                        <input class="search-container-item" type="submit" value="Search" />
                    </form>
                    <a class="search-container-item-anchor" class="refresh-button" href="/matches">Refresh</a>
                </div>
                <c:if test="${empty allMatches}">
                    <h1>No results for ${param.filter_by_player_name}</h1>
                </c:if>
                <c:if test="${not empty allMatches}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Player 1</th>
                                <th>Player 2</th>
                                <th>Winner</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${allMatches}" var="match">
                                <tr>
                                    <td>${match.getId()}</td>
                                    <td>${match.getPlayer1().getName()}</td>
                                    <td>${match.getPlayer2().getName()}</td>
                                    <td>${match.getWinner().getName()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div>
                        <c:if test="${isTherePreviousPage}">
                            <c:if test="${not empty param.filter_by_player_name}">
                                <c:set var="previousPageUrl" value="/matches?page=${previousPage}&filter_by_player_name=${param.filter_by_player_name}"/>
                            </c:if>
                            <c:if test="${empty param.filter_by_player_name}">
                                <c:set var="previousPageUrl" value="/matches?page=${previousPage}"/>
                            </c:if>
                            <a class="previous-page-link" href="${previousPageUrl}">previous</a>
                        </c:if>
                        <c:if test="${isThereNextPage}">
                            <c:if test="${not empty param.filter_by_player_name}">
                                <c:set var="nextPageUrl" value="/matches?page=${nextPage}&filter_by_player_name=${param.filter_by_player_name}"/>
                            </c:if>
                            <c:if test="${empty param.filter_by_player_name}">
                                <c:set var="nextPageUrl" value="/matches?page=${nextPage}"/>
                            </c:if>
                            <a class="next-page-link" href="${nextPageUrl}">next</a>
                        </c:if>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>