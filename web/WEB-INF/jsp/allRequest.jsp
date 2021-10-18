<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Все заявки</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Кто составил</th>
        <th scope="col">Дата заявки</th>
        <th scope="col">Начальный маршрут</th>
        <th scope="col">Конечный маршрут</th>
        <th scope="col">Дата отправки</th>
        <th scope="col">Статус заказа</th>
        <th scope="col">Тип транспорта</th>
        <th scope="col">Детали заказа</th>
    </tr>
    <c:forEach var="request" items="${allRequest}">
        <tr>
                <%--<th scope="row">$${request.getDateCreate()}</th>--%>
            <td>${request.getUserDto().getPhoneNumber()}</td>
            <td>${request.getDateCreate()}</td>
            <td>${request.getStartAddress()}</td>
            <td>${request.getEndAddress()}</td>
            <td>${request.getDateDeparture()}</td>
            <td>${request.getStatusRequest()}</td>
            <td>${request.getTypeTransport()}</td>
            <td>${request.getDetailsRequest()}</td>
            <td>
                <button class="btn btn-outline-warning ms-3 "data-bs-toggle="modal" data-bs-target=".requestId_${request.getId()}">Изменить
                    <c:set var = "requestId" value = "${request.getId()}"/>
                </button>
            </td>
            <td>
                <form action="Controller?command=requesteditbyuser" method="post">
                    <input type="hidden" name="id" value="${request.getId()}">
                    <input type="hidden" name="method" value="delete">
                    <input class="btn btn-danger" type="submit" value="Удалить">
                </form>
            </td>
        </tr>
        <div class="modal fade requestId_${request.getId()}" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel">Редактировать статус заказа</h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>
                    <div class="modal-body"
                        <jsp:include page="processRequest.jsp">
                            <jsp:param name="requestId" value="${requestId}" />
                        </jsp:include>
                     </div>
                </div>
            </div>
        </div>
    </c:forEach>
    </thead>
</table>

</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>
