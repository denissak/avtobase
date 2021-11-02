<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="loc"/>
<html>
<head>
    <title><fmt:message key="button.create_car"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>

<form action="Controller?command=createcar" method="POST">

    <div class="mb-3">
        <label for="examplemark" class="form-label"><fmt:message key="text.mark"/></label>
        <input type="text"
               name="mark"
               class="form-control"
               id="examplemark"
               required pattern="[А-Яа-яA-Za-z]{2,15}"
               title="<fmt:message key="error.only_character_l_c"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleModel" class="form-label"><fmt:message key="text.model"/></label>
        <input type="text"
               name="model"
               class="form-control"
               id="exampleModel"
               required pattern="[А-Яа-яA-Za-z0-9]{2,15}"
               title="<fmt:message key="error.only_character_l_c_numbers"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleReleaseDate" class="form-label"><fmt:message key="text.date_release"/></label>
        <input type="date"
               name="releaseDate"
               class="form-control"
               id="exampleReleaseDate"
               required
               pattern="^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$"
               title="<fmt:message key="error.date"/>"
        >

    </div>
    <div class="mb-3">
        <label for="exampleInputTypeTransport" class="form-label"><fmt:message key="text.type_transport"/></label>
        <select class="form-select" name="typeTransport" required aria-label="select example"
                id="exampleInputTypeTransport">
            <option value=""><fmt:message key="text.type_transport"/></option>
            <c:forEach var="typeTransport" items="${typeTransports}">
                <option value="${typeTransport}">${typeTransport}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleLiftingCapacity" class="form-label"><fmt:message key="text.lifting_capacity"/></label>
        <input type="text"
               name="liftingCapacity"
               class="form-control"
               id="exampleLiftingCapacity"
               pattern="^[0-9]\d*(\d+)?$"
               title="<fmt:message key="error.only_positive_numbers"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleCargoCapacity" class="form-label"><fmt:message key="text.cargo_capacity"/></label>
        <input type="text"
               name="cargoCapacity"
               class="form-control"
               id="exampleCargoCapacity"
               pattern="^[0-9]\d*(\d+)?$"
               title="<fmt:message key="error.only_positive_numbers"/>"
        >
    </div>
    <div class="mb-3">
        <label for="examplePassengerCapacity" class="form-label"><fmt:message key="text.passenger_capacity"/></label>
        <input type="text"
               name="passengerCapacity"
               class="form-control"
               id="examplePassengerCapacity"
               pattern=^[0-9]\d*(\d+)?$"
               title="<fmt:message key="error.only_positive_numbers"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleInspectionPermission" class="form-label"><fmt:message
                key="text.date_inspection_permission"/></label>
        <input type="date"
               name="inspectionPermission"
               class="form-control"
               id="exampleInspectionPermission"
               required
               pattern="^([0-9]{4}[-/]?((0[13-9]|1[012])[-/]?(0[1-9]|[12][0-9]|30)|(0[13578]|1[02])[-/]?31|02[-/]?(0[1-9]|1[0-9]|2[0-8]))|([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00)[-/]?02[-/]?29)$"
               title="<fmt:message key="error.date"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleInputStatusCar" class="form-label"><fmt:message key="text.status_car"/></label>
        <select class="form-select"
                name="statusCar"
                aria-label="select example"
                id="exampleInputStatusCar"
                required
        >
            <option value=""><fmt:message key="text.status_car"/></option>
            <c:forEach var="statusCar" items="${statusCars}">
                <option value="${statusCar}">${statusCar}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleCarDescription" class="form-label"><fmt:message key="text.details"/></label>
        <input type="text"
               name="carDescription"
               class="form-control"
               id="exampleCarDescription"
        >
    </div>
    <button type="submit" class="btn btn-success"><fmt:message key="button.create"/></button>
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

