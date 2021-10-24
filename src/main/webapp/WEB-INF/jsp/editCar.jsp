<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EDIT CAR</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">


</head>
<body>

<form action="Controller?command=editcar" method="POST">
            <p><c:out value="${param.requestId}" /></p>
    <c:forEach var="car" items="${allCar}">
        <c:if test="${car.getId() == param.carId}">
            <%--        <p><c:out value="${request.getStartAddress()}" /></p>--%>
            <div style="display: none" class="mb-3">
                <label for="exampleInputId" class="form-label">Login</label>
                <input type="text"
                       readonly="readonly"
                       name="carId"
                       class="form-control"
                       id="exampleInputId"
                       value="${param.carId}"
                >
            </div>
<%--            <div style="display: none" class="mb-3">
                <label for="exampleStatusRequest" class="form-label">Login</label>
                <input type="text"
                       readonly="readonly"
                       name="statusRequest"
                       class="form-control"
                       id="exampleStatusRequest"
                       value="${car.getStatusRequest().name()}"
                >
            </div>--%>
            <div class="mb-3">
                <label for="exampleMark" class="form-label">Модель</label>
                <input type="text" name="mark" class="form-control" id="exampleMark" value="${car.getMark()}" >
            </div>
            <div class="mb-3">
                <label for="exampleModel" class="form-label">Марка</label>
                <input type="text" name="model" class="form-control" id="exampleModel" value="${car.getModel()}">
            </div>
            <div class="mb-3">
                <label for="exampleReleaseDate" class="form-label">Дата выпуска</label>
                <input type="date" name="releaseDate" class="form-control" id="exampleReleaseDate" value="${car.getReleaseDate()}">
            </div>
            <div class="mb-3">
                <label for="exampleInputTypeTransport" class="form-label">Тип транспорта</label>
                <select class="form-select" name="typeTransport" required aria-label="select example" id="exampleInputTypeTransport">
                    <c:forEach var="typeTransport" items="${typeTransports}">
                        <option value="${typeTransport}" ${typeTransport == car.getTypeTransport() ? 'selected="selected"' : ''}>${typeTransport}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleLiftingCapacity" class="form-label">Грузовместимость</label>
                <input type="text" name="liftingCapacity" class="form-control" id="exampleLiftingCapacity" value="${car.getLiftingCapacity()}">
            </div>
            <div class="mb-3">
                <label for="exampleCargoCapacity" class="form-label">Грузоподъемность</label>
                <input type="text" name="cargoCapacity" class="form-control" id="exampleCargoCapacity" value="${car.getCargoCapacity()}">
            </div>
            <div class="mb-3">
                <label for="examplePassengerCapacity" class="form-label">Пассажировместимость</label>
                <input type="text" name="passengerCapacity" class="form-control" id="examplePassengerCapacity" value="${car.getPassengerCapacity()}">
            </div>
            <div class="mb-3">
                <label for="exampleInspectionPermission" class="form-label">Дата допуска к движению</label>
                <input type="date" name="inspectionPermission" class="form-control" id="exampleInspectionPermission" value="${car.getInspectionPermission()}">
            </div>
            <div class="mb-3">
                <label for="examplestatusCar" class="form-label">Статус автомобиля</label>
                <select class="form-select" name="statusCar" required aria-label="select example" id="examplestatusCar">
                    <c:forEach var="statusCar" items="${statusCars}">
                        <option value="${statusCar}" ${statusCar == car.getStatusCar() ? 'selected="selected"' : ''}>${statusCar}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleCarDescription" class="form-label">Дополнительные сведения</label>
                <input type="text" name="carDescription" class="form-control" id="exampleCarDescription" value="${car.getCarDescription()}" required>
            </div>
        </c:if>
    </c:forEach>
    <button type="submit" class="btn btn-success">Обновить</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
