<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Finished matches</title>
</head>
<body>
<form action="/matches?${filter_by_player_name}" method="get">
    <input type="text" name="filter_by_player_name" placeholder="Поиск" value="${param.filter_by_player_name}" />
    <input type="submit" value="Search" />
</form>
<form action="/matches" method="get">
    <input type="submit" value="Refresh" />
</form>
<c:if test="${not empty param.filter_by_player_name}">
    <h1>Search results</h1>
</c:if>
<c:if test="${empty param.filter_by_player_name}">
    <h1>Finished matches</h1>
</c:if>
<ul>
    <c:forEach items="${allMatches}" var="match">
        <li>${match}</li>
    </c:forEach>
</ul>
<br>
<c:if test="${isTherePreviousPage}">
    <c:if test="${not empty param.filter_by_player_name}">
        <c:set var="previousPageUrl" value="/matches?page=${previousPage}&filter_by_player_name=${param.filter_by_player_name}"/>
    </c:if>
    <c:if test="${empty param.filter_by_player_name}">
        <c:set var="previousPageUrl" value="/matches?page=${previousPage}"/>
    </c:if>
    <a href="${previousPageUrl}">previous</a>
</c:if>
<br>
<c:if test="${isThereNextPage}">
    <c:if test="${not empty param.filter_by_player_name}">
        <c:set var="nextPageUrl" value="/matches?page=${nextPage}&filter_by_player_name=${param.filter_by_player_name}"/>
    </c:if>
    <c:if test="${empty param.filter_by_player_name}">
        <c:set var="nextPageUrl" value="/matches?page=${nextPage}"/>
    </c:if>
    <a href="${nextPageUrl}">next</a>
</c:if>
</body>
</html>