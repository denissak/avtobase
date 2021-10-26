<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><fmt:message key="text.my_comments"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="text.comment_date"/></th>
        <th scope="col"><fmt:message key="text.marks"/></th>
        <th scope="col"><fmt:message key="text.comment"/></th>
    </tr>
    <c:forEach var="comment" items="${commentsById}">
        <tr>
            <td>${comment.getCommentDate()}</td>
            <td>${comment.getMark()}</td>
            <td>${comment.getMessage()}</td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="1" end="${numberOfPages}" var="val">
            <li class="page-item ${val == param.page ? 'active' : ''}"><a class="page-link" href="Controller?command=allusercomment&page=${val}">${val}</a></li>
        </c:forEach>
    </ul>
</nav>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>

