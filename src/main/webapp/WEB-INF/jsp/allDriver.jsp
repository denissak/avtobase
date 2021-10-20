<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список водителей</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Логин</th>
        <th scope="col">Роль</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Номер телефона</th>
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

</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>