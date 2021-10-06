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
        <th scope="col">Дата заявки</th>
        <th scope="col">Начальный маршрут</th>
        <th scope="col">Конечный маршрут</th>
        <th scope="col">Статус заказа</th>
        <th scope="col">Тип транспорта</th>
        <th scope="col">Детали заказа</th>
    </tr>
    </thead>
</table>
<c:forEach var="request" items="${requestsById}">

    <table class="table">
        <tbody>
        <tr>
            <%--<th scope="row">$${request.getDateCreate()}</th>--%>
            <td>${request.getDateCreate()}</td>
            <td>${request.getStartAddress()}</td>
            <td>${request.getEndAddress()}</td>
            <td>${request.getStatusRequest()}</td>
            <td>${request.getTypeTransport()}</td>
            <td>${request.getDetailsRequest()}</td>
        </tr>
        </tbody>
    </table>
</c:forEach>

</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>

