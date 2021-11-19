<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><fmt:message key="text.all_users"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp" %>

</head>

<body>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="loc"/>

<table class="table">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="text.login"/></th>
        <th scope="col"><fmt:message key="text.role"/></th>
        <th scope="col"><fmt:message key="text.name"/></th>
        <th scope="col"><fmt:message key="text.surname"/></th>
        <th scope="col"><fmt:message key="text.phone_number"/></th>
    </tr>
    <c:forEach var="user" items="${usersDisplay}">
        <tr>
            <td>${user.getLogin()}</td>
            <td>${user.getRole()}</td>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getPhoneNumber()}</td>
            <td>
                <button class="btn btn-outline-warning ms-3 " data-bs-toggle="modal"
                        data-bs-target=".${user.getLogin()}"><fmt:message key="text.edit"/>
                    <c:set var="userId" value="${user.getId()}"/>
                </button>
            </td>
            <td>
                <form action="Controller?command=edituserbyadmin" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="hidden" name="method" value="delete">
                    <input class="btn btn-danger" type="submit" value="Удалить">
                </form>
            </td>

        </tr>
        <div class="modal fade ${user.getLogin()}" id="updateUserModal" tabindex="-1"
             aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel"><fmt:message key="text.edit"/></h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>

                    <div class="modal-body">

                        <jsp:include page="editUserByAdmin.jsp">
                            <jsp:param name="userId" value="${userId}"/>
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
                                                                          href="Controller?command=alluser&page=${val}">${val}</a>
            </li>
        </c:forEach>
    </ul>
</nav>


</body>
<footer>
    <%@ include file="footer.jsp" %>
</footer>
</html>