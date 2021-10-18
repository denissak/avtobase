<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Все автомобили</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Водитель</th>
        <th scope="col">Марка автомобиля</th>
        <th scope="col">Модель автомобиля</th>
        <th scope="col">Дата выпуска</th>
        <th scope="col">Тип автомобиля</th>
        <th scope="col">Грузовместимость</th>
        <th scope="col">Грузоподъемность</th>
        <th scope="col">Пассажировместимость</th>
        <th scope="col">Дата допуска к движению</th>
        <th scope="col">Статус автомобиля</th>
        <th scope="col">Дополнительные сведения</th>
    </tr>
<%--    <c:forEach var="car" items="${allCar}">
        <tr>
                &lt;%&ndash;<th scope="row">$${request.getDateCreate()}</th>&ndash;%&gt;
            <td>${car.getUserDto().getPhoneNumber()}</td>
            <td>${car.getMark()}</td>
            <td>${car.getModel()}</td>
            <td>${car.getReleaseDate()}</td>
            <td>${car.getTypeTransport()}</td>
            <td>${car.getLiftingCapacity}</td>
            <td>${car.getCargoCapacity()}</td>
            <td>${car.getPassengerCapacity()}</td>
            <td>${car.getInspectionPermission()}</td>
            <td>${car.getStatusCar()}</td>
            <td>${car.getCarDescription()}</td>
            <td>
                <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                        data-bs-target=".carId_${car.getId()}">Обновить данные
                    <c:set var="carId" value="${car.getId()}"/>
                </button>
            </td>
            <td>
                <form action="Controller?command=editCar" method="post">
                    <input type="hidden" name="id" value="${car.getId()}">
                    <input type="hidden" name="method" value="delete">
                    <input class="btn btn-primary" type="submit" value="Удалить">
                </form>
            </td>
        </tr>--%>
<%--        <div class="modal fade requestId_${catId.getId()}" id="updateUserModal" tabindex="-1"
             aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel">Назначить водителя</h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>
                    <div class="modal-body"
                    <jsp:include page="editCar.jsp">
                        <jsp:param name="carId" value="${carId}"/>
                    </jsp:include>
                </div>
            </div>
        </div>--%>
<%--    </c:forEach>--%>
    </thead>
</table>

</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</html>
