<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><fmt:message key="text.all_requests"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="text.who_created"/></th>
        <th scope="col"><fmt:message key="text.start_address"/></th>
        <th scope="col"><fmt:message key="text.end_address"/></th>
        <th scope="col"><fmt:message key="text.date_departure"/></th>
        <th scope="col"><fmt:message key="text.status_request"/></th>
        <th scope="col"><fmt:message key="text.type_transport"/></th>
        <th scope="col"><fmt:message key="text.request_details"/></th>
    </tr>
    <c:forEach var="request" items="${allRequestByDriver}">

        <div style="display: none" class="mb-3">
            <input type="text"
                   readonly="readonly"
                   name="requestId"
                   class="form-control"
                   id="exampleInputId"
                   value="${param.requestId}"
            >
        </div>
        <tr ${request.getStatusRequest() == 'COMPLETE' ? 'class="table-success"' : ''}
            ${request.getStatusRequest() == 'CREATED' ? 'class="table-warning"' : ''}
            ${request.getStatusRequest() == 'INWORK' ? 'class="table-info"' : ''}
            ${request.getStatusRequest() == 'CANCELED' ? 'class="table-danger"' : ''}
            ${request.getStatusRequest() == 'PROCESSING' ? 'class="table-primary"' : ''}
        >

            <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
            <td>${request.getStartAddress()}</td>
            <td>${request.getEndAddress()}</td>
            <td>${request.getDateDeparture()}</td>
            <td>${request.getStatusRequest()}</td>
            <td>${request.getTypeTransport()}</td>
            <td>${request.getDetailsRequest()}</td>
            <td>
                <form action="Controller?command=editstatusrequestbydriver" method="post">
                    <input style="display: none" readonly="readonly" name="requestId" value="${request.getId()}">
                    <input style="display: none" readonly="readonly" name="statusRequest"
                           value="${request.getStatusRequest()}">
                    <button type="submit" class="btn btn-primary" name="status" value="INWORK"><fmt:message
                            key="button.confirm"/></button>
                    <button type="submit" class="btn btn-primary" name="status" value="CANCELED"><fmt:message
                            key="button.canceled"/></button>
                    <button type="submit" class="btn btn-primary" name="status" value="COMPLETE"><fmt:message
                            key="button.completed"/></button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="1" end="${numberOfPages}" var="val">
            <li class="page-item ${val == param.page ? 'active' : ''}"><a class="page-link"
                                                                          href="Controller?command=allrequestbydriver&page=${val}">${val}</a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</html>
