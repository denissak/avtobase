<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Создать заявку</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>

<form action="Controller?command=createrequest" method="POST">
<%--    <div class="mb-3">
        <label for="exampleDateCreate" class="form-label">Дата создания</label>
        <input type="date" name="dateCreate" class="form-control" id="exampleDateCreate" required aria-describedby="emailHelp">
    </div>--%>
    <div class="mb-3">
        <label for="exampleStartAddress" class="form-label">Адрес начала поездки</label>
        <input type="text" name="startAddress" class="form-control" id="exampleStartAddress" required>
    </div>
    <div class="mb-3">
        <label for="exampleEndAddress" class="form-label">Адрес назначения</label>
        <input type="text" name="endAddress" class="form-control" id="exampleEndAddress" required>
    </div>
    <div class="mb-3">
        <label for="exampleDateDeparture" class="form-label">Дата поездки</label>
        <input type="datetime-local" name="dateDeparture" class="form-control" id="exampleDateDeparture" required>
    </div>
<%--    <div class="mb-3">
        <label for="exampleStatusRequest" class="form-label">Статус заказа</label>
        <input type="text" name="statusRequest" class="form-control" id="exampleStatusRequest" required>
    </div>--%>
    <div class="mb-3">
        <label for="exampleInputTypeTransport" class="form-label">Тип транспорта</label>
        <select class="form-select" name="typeTransport" required aria-label="select example" id="exampleInputTypeTransport">
            <option value="">Укажите тип транспорта</option>
            <c:forEach var="typeTransport" items="${typeTransports}">
                            <%--<th scope="row">$${request.getDateCreate()}</th>--%>
                        <%--<td>${typeTransport.getDateCreate()}</td>--%>
                        <option value="${typeTransport}">${typeTransport}</option>
            </c:forEach>

        <%--            <option value="1">Один</option>
            <option value="2">Два</option>--%>
        </select>
        <%--<div class="invalid-feedback">Пример обратной связи неверного выбора </div>--%>
    </div>
<%--    <div class="mb-3">
        &lt;%&ndash;<label for="exampleInputTypeTransport" class="form-label">Тип транспорта</label>&ndash;%&gt;
        &lt;%&ndash;<input type="text" name="typeTransport" class="form-control" id="exampleInputTypeTransport" required>&ndash;%&gt;
        <select class="form-select" required aria-label="select example" id="exampleInputTypeTransport>
            <option value="">Укажите тип транспорта</option>
            <option value="1">Один</option>
            <option value="2">Два</option>
        </select>
    </div>--%>
    <div class="mb-3">
        <label for="exampleDetailsRequest" class="form-label">Дополнительные сведения</label>
        <input type="text" name="detailsRequest" class="form-control" id="exampleDetailsRequest" required>
    </div>
    <button type="submit" class="btn btn-success">Создать</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
