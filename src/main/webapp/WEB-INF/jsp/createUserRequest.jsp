<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="loc"/>
<html>
<head>
    <title><fmt:message key="button.create_request"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>

<form action="Controller?command=createrequest" method="POST">

    <div class="mb-3">
        <label for="exampleStartAddress" class="form-label"><fmt:message key="text.start_address"/></label>
        <input type="text"
               name="startAddress"
               class="form-control"
               id="exampleStartAddress"
               required pattern="[А-Яа-яA-Za-z0-9]{5,50}"
               title="<fmt:message key="error.only_character_l_c_numbers"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleEndAddress" class="form-label"><fmt:message key="text.end_address"/></label>
        <input type="text"
               name="endAddress"
               class="form-control"
               id="exampleEndAddress"
               required pattern="[А-Яа-яA-Za-z0-9]{5,50}"
               title="<fmt:message key="error.only_character_l_c_numbers"/>"
        >
    </div>
    <div class="mb-3">
        <label for="exampleDateDeparture" class="form-label"><fmt:message key="text.date_departure"/></label>
        <input type="date"
               name="dateDeparture"
               class="form-control"
               id="exampleDateDeparture"
               required>
    </div>
    <div class="mb-3">
        <label for="exampleInputTypeTransport" class="form-label"><fmt:message key="text.type_transport"/></label>
        <select class="form-select" name="typeTransport" required aria-label="select example" id="exampleInputTypeTransport">
            <option value="">Укажите тип транспорта</option>
            <c:forEach var="typeTransport" items="${typeTransports}">
                        <option value="${typeTransport}">${typeTransport}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleDetailsRequest" class="form-label"><fmt:message key="text.details"/></label>
        <input type="text"
               name="detailsRequest"
               class="form-control"
               id="exampleDetailsRequest"
               required>
    </div>
    <button type="submit" class="btn btn-success"><fmt:message key="button.create"/></button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
