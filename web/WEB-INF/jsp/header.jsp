<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <div class="container">
        <a href="/" class="navbar-brand">Автобаза</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav me-auto mb-2">
                <li class="nav-item">
                    <a href="Controller?command=gotoalluserpage" class="nav-link"> Все пользователи</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link"> Изменить пользователя</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link"> Меню 3</a>
                </li>
            </ul>
            <div action="" class="d-flex">
                <c:if test="${empty sessionScope.user}">
                    <button class="btn btn-outline-success"data-bs-toggle="modal" data-bs-target="#registrationModal">Зарегистрироваться</button>
                    <button class="btn btn-success ms-3"data-bs-toggle="modal" data-bs-target="#loginModal" >Войти</button>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                    <button class="btn btn-outline-success "data-bs-toggle="modal" data-bs-target="#createRequestModal">Создать заявку</button>
                    <button class="btn btn-outline-success ms-3 "data-bs-toggle="modal" data-bs-target="#updateUserModal">Обновить юзера</button>
                    <form action="Controller?command=logout" method="POST">
                        <button class="btn btn-outline-danger ms-3">Выйти</button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</nav>

<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Вход</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body"><%@ include file="login.jsp"%> </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createRequestModal" tabindex="-1" aria-labelledby="createRequestModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createRequestModalLabel">Вход</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <%--<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>--%>
            <div class="modal-body">
                <jsp:include page="createUserRequest.jsp">
                    <jsp:param name="typeTransports" value="typeTransports" />
                </jsp:include><%--<%@ include file="createUserRequest.jsp"%>--%> <%--<jsp:include page="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"--%> </div>
        </div>
    </div>
</div>


<div class="modal fade" id="registrationModal" tabindex="-1" aria-labelledby="registrationModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registrationModalLabel">Регистрация</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body"><%@ include file="registration.jsp"%> </div>

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateUserModalLabel">Редактировать пользователя</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <%--<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>--%>
            <div class="modal-body"><<%@ include file="userEditByAdmin.jsp"%>>
<%--<%@ include file="createUserRequest.jsp"%>--%> <%--<jsp:include page="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"--%> </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>


