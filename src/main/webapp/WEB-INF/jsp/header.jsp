<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
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
            <%--<div class="collapse navbar-collapse" id="navbarContent">
                <ul class="navbar-nav me-auto mb-2">

                    <div action="" class="d-flex">--%>
            <c:choose>

                <c:when test="${empty sessionScope.user}">

                    <ul class="navbar-nav me-auto mb-2">
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success" data-bs-toggle="modal"
                                data-bs-target="#registrationModal">Зарегистрироваться
                        </button>
                        <button class="btn btn-success ms-3" data-bs-toggle="modal" data-bs-target="#loginModal">
                            Войти
                        </button>
                    </div>

                </c:when>

                <c:when test="${user.getRole().equals('admin')}">

                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=alluser" class="nav-link"> Все пользователи</a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allcar" class="nav-link"> Все автомобили</a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allrequest" class="nav-link"> Все заявки</a>
                        </li>
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target="#createCarModal">Создать авто
                        </button>
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3">Выйти</button>
                        </form>
                    </div>
                </c:when>

                <c:when test="${user.getRole().equals('dispatcher')}">
                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=allcar" class="nav-link"> Все автомобили</a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allrequest" class="nav-link"> Все заявки</a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=alldriver" class="nav-link"> Все водители</a>
                        </li>
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success " data-bs-toggle="modal"
                                data-bs-target="#createCarModal">Создать авто
                        </button>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target="#createRequestModal">Создать заявку
                        </button>
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3">Выйти</button>
                        </form>
                    </div>
                </c:when>

                <c:when test="${user.getRole().equals('driver')}">
                    <ul class="navbar-nav me-auto mb-2">
                    </ul>
                    <div action="" class="d-flex">
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3">Выйти</button>
                        </form>
                    </div>
                </c:when>

                <c:when test="${user.getRole().equals('user')}">
                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=alluserrequest" class="nav-link"> Мои заявки</a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allusercomment" class="nav-link"> Мои комментарии</a>
                        </li>
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success " data-bs-toggle="modal"
                                data-bs-target="#createRequestModal">Создать заявку
                        </button>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target="#createCommentModal">Оставить комментарий
                        </button>
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3">Выйти</button>
                        </form>
                    </div>
                </c:when>
            </c:choose>
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
            <div class="modal-body">
                <%@ include file="login.jsp" %>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createRequestModal" tabindex="-1" aria-labelledby="createRequestModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createRequestModalLabel">Создание заявки</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body">
                <jsp:include page="createUserRequest.jsp">
                    <jsp:param name="typeTransports" value="typeTransports"/>
                </jsp:include>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createCarModal" tabindex="-1" aria-labelledby="createCarModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createCarModalLabel">Создание автомобиля</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <%--<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>--%>
            <div class="modal-body">
                <jsp:include page="createCar.jsp">
                    <jsp:param name="typeTransports" value="typeTransports"/>

                    <jsp:param name="statusCar" value="statusCar"/>
                </jsp:include>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="registrationModal" tabindex="-1" aria-labelledby="registrationModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registrationModalLabel">Регистрация</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body">
                <%@ include file="registration.jsp" %>
            </div>

        </div>
    </div>
</div>


<div class="modal fade" id="createCommentModal" tabindex="-1" aria-labelledby="createCommentModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createCommentModalLabel">Напишите ваш комментарий</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body">
                <%@ include file="createComment.jsp" %>
            </div>

        </div>
    </div>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
        integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
        integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
        crossorigin="anonymous"></script>
</body>


