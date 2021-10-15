<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EDIT REQUEST</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">


</head>
<body>

<form action="Controller?command=requesteditbyuser" method="POST">

    <div class="mb-3">
        <label for="exampleStartAddress" class="form-label">Адрес начала поездки</label>
        <input type="text" name="startAddress" class="form-control" id="exampleStartAddress" >
    </div>
    <div class="mb-3">
        <label for="exampleEndAddress" class="form-label">Адрес назначения</label>
        <input type="text" name="endAddress" class="form-control" id="exampleEndAddress" >
    </div>
    <div class="mb-3">
        <label for="exampleDateDeparture" class="form-label">Дата поездки</label>
        <input type="datetime-local" name="dateDeparture" class="form-control" id="exampleDateDeparture" >
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
        <label for="exampleDetailsRequest" class="form-label">Дополнительные сведения</label>
        <input type="text" name="detailsRequest" class="form-control" id="exampleDetailsRequest" required>
    </div>
    <button type="submit" class="btn btn-primary">Создать</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
