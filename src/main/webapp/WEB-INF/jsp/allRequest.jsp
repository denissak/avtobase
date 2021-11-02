<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="loc"/>
<html>
<head>
    <title><fmt:message key="text.all_requests"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp" %>
</head>

<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="text.who_created"/></th>
        <th scope="col"><fmt:message key="text.date_request"/></th>
        <th scope="col"><fmt:message key="text.start_address"/></th>
        <th scope="col"><fmt:message key="text.end_address"/></th>
        <th scope="col"><fmt:message key="text.date_departure"/></th>
        <th scope="col"><fmt:message key="text.status_request"/></th>
        <th scope="col"><fmt:message key="text.type_transport"/></th>
        <th scope="col"><fmt:message key="text.request_details"/></th>
    </tr>
    <c:forEach var="request" items="${allRequest}">
        <c:choose>
            <c:when test="${request.getStatusRequest().equals('COMPLETE')}">
                <tr class="table-success">
                    <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
                    <td>${request.getDateCreate()}</td>
                    <td>${request.getStartAddress()}</td>
                    <td>${request.getEndAddress()}</td>
                    <td>${request.getDateDeparture()}</td>
                    <td>${request.getStatusRequest()}</td>
                    <td>${request.getTypeTransport()}</td>
                    <td>${request.getDetailsRequest()}</td>
                    <td>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestId_${request.getId()}">Обработать
                            <c:set var="requestId" value="${request.getId()}"/>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestIdEdit_${request.getId()}"><fmt:message key="text.edit"/>
                            <c:set var="requestId" value="${request.getId()}"/>
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
            </c:when>
            <c:when test="${request.getStatusRequest().equals('CANCELED')}">
                <tr class="table-danger">
                    <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
                    <td>${request.getDateCreate()}</td>
                    <td>${request.getStartAddress()}</td>
                    <td>${request.getEndAddress()}</td>
                    <td>${request.getDateDeparture()}</td>
                    <td>${request.getStatusRequest()}</td>
                    <td>${request.getTypeTransport()}</td>
                    <td>${request.getDetailsRequest()}</td>
                    <td>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestId_${request.getId()}">Обработать
                            <c:set var="requestId" value="${request.getId()}"/>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestIdEdit_${request.getId()}"><fmt:message key="text.edit"/>
                            <c:set var="requestId" value="${request.getId()}"/>
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
            </c:when>
            <c:when test="${request.getStatusRequest().equals('CREATED')}">
                <tr class="table-warning">
                    <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
                    <td>${request.getDateCreate()}</td>
                    <td>${request.getStartAddress()}</td>
                    <td>${request.getEndAddress()}</td>
                    <td>${request.getDateDeparture()}</td>
                    <td>${request.getStatusRequest()}</td>
                    <td>${request.getTypeTransport()}</td>
                    <td>${request.getDetailsRequest()}</td>
                    <td>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestId_${request.getId()}">Обработать
                            <c:set var="requestId" value="${request.getId()}"/>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestIdEdit_${request.getId()}"><fmt:message key="text.edit"/>
                            <c:set var="requestId" value="${request.getId()}"/>
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
            </c:when>
            <c:when test="${request.getStatusRequest().equals('INWORK')}">
                <tr class="table-info">
                    <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
                    <td>${request.getDateCreate()}</td>
                    <td>${request.getStartAddress()}</td>
                    <td>${request.getEndAddress()}</td>
                    <td>${request.getDateDeparture()}</td>
                    <td>${request.getStatusRequest()}</td>
                    <td>${request.getTypeTransport()}</td>
                    <td>${request.getDetailsRequest()}</td>
                    <td>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestId_${request.getId()}">Обработать
                            <c:set var="requestId" value="${request.getId()}"/>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestIdEdit_${request.getId()}"><fmt:message key="text.edit"/>
                            <c:set var="requestId" value="${request.getId()}"/>
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
            </c:when>
            <c:when test="${request.getStatusRequest().equals('PROCESSING')}">
                <tr class="table-primary">
                    <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
                    <td>${request.getDateCreate()}</td>
                    <td>${request.getStartAddress()}</td>
                    <td>${request.getEndAddress()}</td>
                    <td>${request.getDateDeparture()}</td>
                    <td>${request.getStatusRequest()}</td>
                    <td>${request.getTypeTransport()}</td>
                    <td>${request.getDetailsRequest()}</td>
                    <td>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestId_${request.getId()}">Обработать
                            <c:set var="requestId" value="${request.getId()}"/>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                                data-bs-target=".requestIdEdit_${request.getId()}"><fmt:message key="text.edit"/>
                            <c:set var="requestId" value="${request.getId()}"/>
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
            </c:when>
        </c:choose>

              <tr>
                  <td>${request.getUserDto().getName()} ${request.getUserDto().getSurname()} ${request.getUserDto().getPhoneNumber()}</td>
                  <td>${request.getDateCreate()}</td>
                  <td>${request.getStartAddress()}</td>
                  <td>${request.getEndAddress()}</td>
                  <td>${request.getDateDeparture()}</td>
                  <td>${request.getStatusRequest()}</td>
                  <td>${request.getTypeTransport()}</td>
                  <td>${request.getDetailsRequest()}</td>
                  <td>
                      <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                              data-bs-target=".requestId_${request.getId()}">Обработать
                          <c:set var="requestId" value="${request.getId()}"/>
                      </button>
                  </td>
                  <td>
                      <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                              data-bs-target=".requestIdEdit_${request.getId()}"><fmt:message key="text.edit"/>
                          <c:set var="requestId" value="${request.getId()}"/>
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
        <div class="modal fade requestId_${request.getId()}" id="updateUserModal" tabindex="-1"
             aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel"><fmt:message
                                key="button.change_status_request"/></h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>
                    <div class="modal-body">
                        <jsp:include page="processRequest.jsp">
                            <jsp:param name="requestId" value="${requestId}"/>
                        </jsp:include>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade requestIdEdit_${request.getId()}" id="updateCarModal" tabindex="-1"
             aria-labelledby="updateCarModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateCarModalLabel"><fmt:message key="text.edit"/></h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>

                    <div class="modal-body">
                        <jsp:include page="editRequestByUser.jsp">
                            <jsp:param name="requestId" value="${requestId}"/>
                        </jsp:include>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    </thead>
</table>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="1" end="${numberOfPages}" var="val">
            <li class="page-item ${val == param.page ? 'active' : ''}"><a class="page-link"
                                                                          href="Controller?command=allrequest&page=${val}">${val}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</html>
