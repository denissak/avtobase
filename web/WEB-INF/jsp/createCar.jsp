<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Создать автомобиль</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>

<form action="Controller?command=gotocreatecar" method="POST">

    <div class="mb-3">
        <label for="examplemark" class="form-label">Марка автомобиля</label>
        <input type="text" name="mark" class="form-control" id="examplemark" required>
    </div>
    <div class="mb-3">
        <label for="exampleModel" class="form-label">Модель автомобиля</label>
        <input type="text" name="model" class="form-control" id="exampleModel" required>
    </div>
    <div class="mb-3">
        <label for="exampleReleaseDate" class="form-label">Дата выпуска</label>
        <input type="datetime-local" name="releaseDate" class="form-control" id="exampleReleaseDate" required>
    </div>
    <div class="mb-3">
        <label for="exampleInputTypeTransport" class="form-label">Тип транспорта</label>
        <select class="form-select" name="typeTransport" required aria-label="select example" id="exampleInputTypeTransport">
            <option value="">Укажите тип транспорта</option>
            <c:forEach var="typeTransport" items="${typeTransports}">
                <option value="${typeTransport}">${typeTransport}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleLiftingCapacity" class="form-label">Грузовместимость</label>
        <input type="text" name="liftingCapacity" class="form-control" id="exampleLiftingCapacity">
    </div>
    <div class="mb-3">
        <label for="exampleCargoCapacity" class="form-label">Грузоподъемность</label>
        <input type="text" name="cargoCapacity" class="form-control" id="exampleCargoCapacity">
    </div>
    <div class="mb-3">
        <label for="examplePassengerCapacity" class="form-label">Пассажировместимость</label>
        <input type="text" name="passengerCapacity" class="form-control" id="examplePassengerCapacity">
    </div>
    <div class="mb-3">
        <label for="exampleInspectionPermission" class="form-label">Дата допуска к движению</label>
        <input type="datetime-local" name="inspectionPermission" class="form-control" id="exampleInspectionPermission" required>
    </div>
    <div class="mb-3">
        <label for="exampleInputStatusCar" class="form-label">Статус автомобиля</label>
        <select class="form-select" name="statusCar" <%--required--%> aria-label="select example" id="exampleInputStatusCar">
            <option value="">Укажите статус автомобиля</option>
            <c:forEach var="statusCar" items="${statusCars}">
                <option value="${statusCar}">${statusCar}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleCarDescription" class="form-label">Дополнительные сведения</label>
        <input type="text" name="carDescription" class="form-control" id="exampleCarDescription" required>
    </div>
    <button type="submit" class="btn btn-success">Создать</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>

