<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
    <%-- <jsp:include page="header.jsp">
         <jsp:param name="type1" value="12" />
     </jsp:include>--%>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <%--<th scope="col">Номер</th>--%>
        <th scope="col">Логин</th>
        <%--<th scope="col">Пароль</th>--%>
        <th scope="col">Роль</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Номер телефона</th>
    </tr>
    <c:forEach var="user" items="${allUser}">
        <tr>
                <%--<th scope="row">$${request.getDateCreate()}</th>--%>
                <%--<td>${user.getId()}</td>--%>
            <td>${user.getLogin()}</td>
            <td>${user.getRole()}</td>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getPhoneNumber()}</td>
            <td>
                <button class="btn btn-outline-success ms-3 "data-bs-toggle="modal" data-bs-target=".${user.getLogin()}">Обновить юзера
                    <c:set var = "userId" value = "${user.getId()}"/>
                </button>
            </td>

        </tr>
        <div class="modal fade ${user.getLogin()}" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel">Редактировать пользователя</h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>
                        <%--<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>--%>
                    <div class="modal-body"><%--<<%@ include file="userEditByAdmin.jsp"%>>--%>
                            <%--                            <jsp:param name="type1" value="${user}" />--%>
                        <jsp:include page="userEditByAdmin.jsp">
                            <jsp:param name="userId" value="${userId}" />
                        </jsp:include>
                            <%--                <c:redirect url="Controller?command=usereditbyadmin"/>--%>
                            <%--<%@ include file="createUserRequest.jsp"%>--%> <%--<jsp:include page="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"--%> </div>
                </div>
            </div>
        </div>
    </c:forEach>
    </thead>
</table>


<%--<div class="modal fade" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateUserModalLabel">Редактировать пользователя</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            &lt;%&ndash;<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>&ndash;%&gt;
            <div class="modal-body">&lt;%&ndash;<<%@ include file="userEditByAdmin.jsp"%>>&ndash;%&gt;
                <jsp:include page="userEditByAdmin.jsp">
                    <jsp:param name="type1" value="${user}" />
                </jsp:include>
                &lt;%&ndash;                <c:redirect url="Controller?command=usereditbyadmin"/>&ndash;%&gt;
                &lt;%&ndash;<%@ include file="createUserRequest.jsp"%>&ndash;%&gt; &lt;%&ndash;<jsp:include page="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"&ndash;%&gt; </div>
        </div>
    </div>
</div>--%>


</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>