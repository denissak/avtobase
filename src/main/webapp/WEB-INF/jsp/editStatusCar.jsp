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

<form action="Controller?command=editstatuscar" method="POST">
<c:forEach var="car" items="${allCar}">
    <c:if test="${user.getId() == car.getUserDto().getId()}">
    <div style="display: none" class="mb-3">
        <label for="exampleInputId" class="form-label"><fmt:message key="text.edit"/></label>
        <input type="text"
               readonly="readonly"
               name="carId"
               class="form-control"
               id="exampleInputId"
               value="${car.getId()}"
        >
    </div>
<%--</c:if>
</c:forEach>--%>

    <div class="mb-3">
        <label for="exampleInputStatusCar" class="form-label"><fmt:message key="text.status_car"/></label>
        <select class="form-select" name="statusCar" aria-label="select example"
                id="exampleInputStatusCar">
            <c:forEach var="statusCar" items="${statusCars}">
                <option value="${statusCar}" ${statusCar == car.getStatusCar() ? 'selected="selected"' : ''}>${statusCar}</option>
            </c:forEach>
        </select>
    </div>
        <button type="submit" class="btn btn-success"><fmt:message key="button.create"/></button>
    </c:if>
    </c:forEach>
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

