<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><fmt:message key="text.all_driver"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
</head>

<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="text.login"/></th>
        <th scope="col"><fmt:message key="text.role"/></th>
        <th scope="col"><fmt:message key="text.name"/></th>
        <th scope="col"><fmt:message key="text.surname"/></th>
        <th scope="col"><fmt:message key="text.phone_number"/></th>
    </tr>
    <c:forEach var="driver" items="${allDriver}">
        <tr>
            <td>${driver.getLogin()}</td>
            <td>${driver.getRole()}</td>
            <td>${driver.getName()}</td>
            <td>${driver.getSurname()}</td>
            <td>${driver.getPhoneNumber()}</td>
        </tr>
    </c:forEach>
    </thead>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="1" end="${numberOfPages}" var="val">
            <li class="page-item ${val == param.page ? 'active' : ''}"><a class="page-link"
                                                                          href="Controller?command=alldriver&page=${val}">${val}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</html>