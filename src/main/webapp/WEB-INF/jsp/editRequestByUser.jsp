<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="loc"/>
<html>
<head>
    <title><fmt:message key="text.edit"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">


</head>
<body>

<form action="Controller?command=editrequestbyuser" method="POST">
<%--        <p><c:out value="${param.requestId}" /></p>--%>
<c:forEach var="request" items="${allRequest}">
    <c:if test="${request.getId() == param.requestId}">
<%--        <p><c:out value="${request.getStartAddress()}" /></p>--%>
        <div style="display: none" class="mb-3">
            <label for="exampleInputId" class="form-label">Login</label>
            <input type="text"
                   readonly="readonly"
                   name="id"
                   class="form-control"
                   id="exampleInputId"
                   value="${param.requestId}"
            >
        </div>
        <div style="display: none" class="mb-3">
            <label for="exampleStatusRequest" class="form-label">Login</label>
            <input type="text"
                   readonly="readonly"
                   name="statusRequest"
                   class="form-control"
                   id="exampleStatusRequest"
                   value="${request.getStatusRequest().name()}"
            >
        </div>
        <div class="mb-3">
        <label for="exampleStartAddress" class="form-label"><fmt:message key="text.start_address"/></label>
        <input type="text" name="startAddress" class="form-control" id="exampleStartAddress" value="${request.getStartAddress()}" >
    </div>
    <div class="mb-3">
        <label for="exampleEndAddress" class="form-label"><fmt:message key="text.end_address"/></label>
        <input type="text" name="endAddress" class="form-control" id="exampleEndAddress" value="${request.getEndAddress()}">
    </div>
    <div class="mb-3">
        <label for="exampleDateDeparture" class="form-label"><fmt:message key="text.date_departure"/></label>
        <input type="date" name="dateDeparture" class="form-control" id="exampleDateDeparture" value="${request.getDateDeparture()}">
    </div>
    <div class="mb-3">
        <label for="exampleInputTypeTransport" class="form-label"><fmt:message key="text.type_transport"/></label>
        <select class="form-select" name="typeTransport" required aria-label="select example" id="exampleInputTypeTransport">
            <c:forEach var="typeTransport" items="${typeTransports}">
                <option value="${typeTransport}" ${typeTransport == request.getTypeTransport() ? 'selected="selected"' : ''}>${typeTransport}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-3">
        <label for="exampleDetailsRequest" class="form-label"><fmt:message key="text.request_details"/></label>
        <input type="text" name="detailsRequest" class="form-control" id="exampleDetailsRequest" value="${request.getDetailsRequest()}" required>
    </div>
    </c:if>
</c:forEach>
    <button type="submit" class="btn btn-success"><fmt:message key="text.edit"/></button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
