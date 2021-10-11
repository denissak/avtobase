<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <%--<th scope="col">Номер</th>--%>
        <th scope="col">Логин</th>
        <%--<th scope="col">Пароль</th>--%>
        <th scope="col">Роль</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Номер телефона</th>
    </tr>
    <c:forEach var="user" items="${allUser}">
        <tr>
                <%--<th scope="row">$${request.getDateCreate()}</th>--%>
            <%--<td>${user.getId()}</td>--%>
            <td>${user.getLogin()}</td>
            <td>${user.getRole()}</td>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getPhoneNumber()}</td>
        </tr>
    </c:forEach>
    </thead>
</table>

</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>