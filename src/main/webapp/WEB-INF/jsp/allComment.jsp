<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title><fmt:message key="text.all_comments"/></title>
</head>
<body>
<table class="table">
    <thead>
12
<c:forEach var="comment" items="${allComment}">
    <tr>

    <td>${comment.getUserDto().getName()} ${comment.getUserDto().getSurname()}</td>
    <td>${comment.getCommentDate()}</td>
    <td>${comment.getMark()}</td>
    <td>${comment.getMessage()}</td>
    </tr>
</c:forEach>
    </thead>
</table>

</body>
</html>
