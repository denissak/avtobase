<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="loc"/>
<html>
<head>
    <title><fmt:message key="text.edit"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="loc"/>

<form action="Controller?command=editcar" method="POST">
    <c:forEach var="car" items="${allCar}">
        <c:if test="${car.getId() == param.carId}">
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
            <div class="mb-3">
                <label for="exampleMark" class="form-label"><fmt:message key="text.model"/></label>
                <input type="text"
                       name="mark"
                       class="form-control"
                       id="exampleMark"
                       pattern="[А-Яа-яA-Za-z]{2,15}"
                       title="<fmt:message key="error.only_character_l_c"/>"
                       value="${car.getMark()}">
            </div>
            <div class="mb-3">
                <label for="exampleModel" class="form-label"><fmt:message key="text.mark"/></label>
                <input type="text"
                       name="model"
                       class="form-control"
                       id="exampleModel"
                       pattern="[А-Яа-яA-Za-z0-9]{2,15}"
                       title="<fmt:message key="error.only_character_l_c_numbers"/>"
                       value="${car.getModel()}">
            </div>
            <div class="mb-3">
                <label for="exampleReleaseDate" class="form-label"><fmt:message key="text.date_release"/></label>
                <input type="date"
                       name="releaseDate"
                       class="form-control"
                       id="exampleReleaseDate"
                       pattern="^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$"
                       title="<fmt:message key="error.date"/>"
                       value="${car.getReleaseDate()}">
            </div>
            <div class="mb-3">
                <label for="exampleInputTypeTransport" class="form-label"><fmt:message
                        key="text.type_transport"/></label>
                <select class="form-select" name="typeTransport" required aria-label="select example"
                        id="exampleInputTypeTransport">
                    <c:forEach var="typeTransport" items="${typeTransports}">
                        <option value="${typeTransport}" ${typeTransport == car.getTypeTransport() ? 'selected="selected"' : ''}>${typeTransport}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleLiftingCapacity" class="form-label"><fmt:message
                        key="text.lifting_capacity"/></label>
                <input type="text"
                       name="liftingCapacity"
                       class="form-control"
                       id="exampleLiftingCapacity"
                       pattern="^[0-9]\d*(\d+)?$"
                       title="<fmt:message key="error.only_positive_numbers"/>"
                       value="${car.getLiftingCapacity()}">
            </div>
            <div class="mb-3">
                <label for="exampleCargoCapacity" class="form-label"><fmt:message key="text.cargo_capacity"/></label>
                <input type="text"
                       name="cargoCapacity"
                       class="form-control"
                       id="exampleCargoCapacity"
                       pattern="^[0-9]\d*(\d+)?$"
                       title="<fmt:message key="error.only_positive_numbers"/>"
                       value="${car.getCargoCapacity()}">
            </div>
            <div class="mb-3">
                <label for="examplePassengerCapacity" class="form-label"><fmt:message
                        key="text.passenger_capacity"/></label>
                <input type="text"
                       name="passengerCapacity"
                       class="form-control"
                       id="examplePassengerCapacity"
                       pattern="^[0-9]\d*(\d+)?$"
                       title="<fmt:message key="error.only_positive_numbers"/>"
                       value="${car.getPassengerCapacity()}">
            </div>
            <div class="mb-3">
                <label for="exampleInspectionPermission" class="form-label"><fmt:message
                        key="text.date_inspection_permission"/></label>
                <input type="date"
                       name="inspectionPermission"
                       class="form-control"
                       id="exampleInspectionPermission"
                       pattern="^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$"
                       title="<fmt:message key="error.date"/>"
                       value="${car.getInspectionPermission()}">
            </div>
            <div class="mb-3">
                <label for="examplestatusCar" class="form-label"><fmt:message key="text.status_car"/></label>
                <select class="form-select" name="statusCar" required aria-label="select example" id="examplestatusCar">
                    <c:forEach var="statusCar" items="${statusCars}">
                        <option value="${statusCar}" ${statusCar == car.getStatusCar() ? 'selected="selected"' : ''}>${statusCar}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleCarDescription" class="form-label"><fmt:message key="text.details"/></label>
                <input type="text" name="carDescription" class="form-control" id="exampleCarDescription"
                       value="${car.getCarDescription()}" required>
            </div>
        </c:if>
    </c:forEach>
    <button type="submit" class="btn btn-success"><fmt:message key="text.edit"/></button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
        integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
        integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
        crossorigin="anonymous"></script>
</body>
</html>
