<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><fmt:message key="text.all_requests"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="text.date_request"/></th>
        <th scope="col"><fmt:message key="text.start_address"/></th>
        <th scope="col"><fmt:message key="text.end_address"/></th>
        <th scope="col"><fmt:message key="text.date_departure"/></th>
        <th scope="col"><fmt:message key="text.status_request"/></th>
        <th scope="col"><fmt:message key="text.type_transport"/></th>
        <th scope="col"><fmt:message key="text.request_details"/></th>
    </tr>
    <c:forEach var="request" items="${requestsById}">
        <tr>
                <%--<th scope="row">$${request.getDateCreate()}</th>--%>
            <td>${request.getDateCreate()}</td>
            <td>${request.getStartAddress()}</td>
            <td>${request.getEndAddress()}</td>
            <td>${request.getDateDeparture()}</td>
            <td>${request.getStatusRequest()}</td>
            <td>${request.getTypeTransport()}</td>
            <td>${request.getDetailsRequest()}</td>
                    <td>
                        <button class="btn btn-outline-warning ms-3 "data-bs-toggle="modal" data-bs-target=".requestId_${request.getId()}"><fmt:message key="text.edit"/>
                            <c:set var = "requestId" value = "${request.getId()}"/>
                        </button>
                    </td>
                    <td>
                        <form action="Controller?command=editrequestbyuser" method="post">
                            <input type="hidden" name="id" value="${request.getId()}">
                            <input type="hidden" name="method" value="delete">
                            <input class="btn btn-danger" type="submit" value="Удалить">
                        </form>
                    </td>
        </tr>
        <div class="modal fade requestId_${request.getId()}" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel"><fmt:message key="text.edit"/></h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>
                        <%--<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>--%>
                    <div class="modal-body"><%--<<%@ include file="editUserByAdmin.jsp"%>>--%>
                            <%--                            <jsp:param name="type1" value="${user}" />--%>
                        <jsp:include page="editRequestByUser.jsp">
                            <jsp:param name="requestId" value="${requestId}" />
                        </jsp:include>
                            <%--                <c:redirect url="Controller?command=usereditbyadmin"/>--%>
                            <%--<%@ include file="createUserRequest.jsp"%>--%> <%--<jsp:include page="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"--%> </div>
                </div>
            </div>
        </div>
    </c:forEach>
    </thead>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="1" end="${numberOfPages}" var="val">
            <li class="page-item ${val == param.page ? 'active' : ''}"><a class="page-link" href="Controller?command=alluserrequest&page=${val}">${val}</a></li>
        </c:forEach>
    </ul>
</nav>
</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>

