<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Matches</title>
</head>
<body>
<h1>List of Matches</h1>
<ul>
    <c:forEach items="${allMatches}" var="match">
        <li>${match}</li>
    </c:forEach>
</ul>
<br>
<c:if test="${isThereNextPage}">
    <a href="/matches?page=${page}">next</a>
</form>
</c:if>
</body>
</html>