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

<form action="Controller?command=setdriveroncar" method="POST">
    <c:forEach var="car" items="${allCar}">
        <c:if test="${car.getId() == param.carId}">
            <div style="display: none" class="mb-3">
                <input type="text"
                       readonly="readonly"
                       name="carId"
                       class="form-control"
                       id="exampleInputId"
                       value="${param.carId}"
                >
            </div>
            <div class="mb-3">
                <label for="exampleInputDriver" class="form-label"><fmt:message key="text.driver"/></label>
                <select class="form-select" name="driver" required aria-label="select example" id="exampleInputDriver">
                    <option value=""><fmt:message key="text.make_driver"/></option>
                    <c:forEach var="userDriver" items="${userDrivers}">
                        <option value="${userDriver.getId()}">${userDriver.getName()}</option>
                    </c:forEach>
                </select>
            </div>
        </c:if>
    </c:forEach>
    <button type="submit" class="btn btn-success"><fmt:message key="text.make_driver"/></button>
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

