<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="loc"/>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a href="/" class="navbar-brand"><fmt:message key="text.avtobase"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <ul class="navbar-nav me-auto mb-2">
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success" data-bs-toggle="modal"
                                data-bs-target="#registrationModal"><fmt:message key="button.register"/>
                        </button>
                        <button class="btn btn-success ms-3" data-bs-toggle="modal" data-bs-target="#loginModal">
                            <fmt:message key="button.log_in"/>
                        </button>
                    </div>
                </c:when>
                <c:when test="${user.getRole().equals('admin')}">
                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=alluser&page=1" class="nav-link"><fmt:message
                                    key="text.all_users"/></a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allcar" class="nav-link"><fmt:message key="text.all_cars"/></a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allrequest" class="nav-link"><fmt:message
                                    key="text.all_requests"/></a>
                        </li>
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target="#createCarModal"><fmt:message key="button.create_car"/>
                        </button>
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3"><fmt:message key="button.log_out"/></button>
                        </form>
                    </div>
                </c:when>

                <c:when test="${user.getRole().equals('dispatcher')}">
                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=allcar" class="nav-link"><fmt:message key="text.all_cars"/></a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allrequest" class="nav-link"><fmt:message
                                    key="text.all_requests"/></a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=alldriver" class="nav-link"><fmt:message
                                    key="text.all_driver"/></a>
                        </li>
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success " data-bs-toggle="modal"
                                data-bs-target="#createCarModal"><fmt:message key="button.create_car"/>
                        </button>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target="#createRequestModal"><fmt:message key="button.create_request"/>
                        </button>
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3"><fmt:message key="button.log_out"/></button>
                        </form>
                    </div>
                </c:when>

                <c:when test="${user.getRole().equals('driver')}">
                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=allrequestbydriver" class="nav-link"><fmt:message
                                    key="text.my_requests"/></a>
                        </li>
                    </ul>
                    <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                            data-bs-target="#changeStatusCar"><fmt:message key="button.status_car"/>
                    </button>
                    <div action="" class="d-flex">
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3"><fmt:message key="button.log_out"/></button>
                        </form>
                    </div>
                </c:when>

                <c:when test="${user.getRole().equals('user')}">
                    <ul class="navbar-nav me-auto mb-2">
                        <li class="nav-item">
                            <a href="Controller?command=alluserrequest" class="nav-link"><fmt:message
                                    key="text.my_requests"/></a>
                        </li>
                        <li class="nav-item">
                            <a href="Controller?command=allusercomment" class="nav-link"><fmt:message
                                    key="text.my_comments"/></a>
                        </li>
                    </ul>
                    <div action="" class="d-flex">
                        <button class="btn btn-outline-success " data-bs-toggle="modal"
                                data-bs-target="#createRequestModal"><fmt:message key="button.create_request"/>
                        </button>
                        <button class="btn btn-outline-success ms-3 " data-bs-toggle="modal"
                                data-bs-target="#createCommentModal"><fmt:message key="text.send_comment"/>
                        </button>
                        <form action="Controller?command=logout" method="POST">
                            <button class="btn btn-outline-danger ms-3"><fmt:message key="button.log_out"/></button>
                        </form>
                    </div>
                </c:when>

            </c:choose>
        </div>
    </div>
    <div class="btn-group" aria-label="Basic outlined example">
        <form action="Controller?command=language" method="POST">
            <button class="btn btn-outline-primary" name="lang" value="ru_RU">RU</button>
            <button class="btn btn-outline-primary" name="lang" value="en_US">EN</button>
        </form>
    </div>
</nav>

<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel"><fmt:message key="button.log_in"/></h5>
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
                <h5 class="modal-title" id="createRequestModalLabel"><fmt:message key="button.create_request"/></h5>
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

<div class="modal fade" id="changeStatusCar" tabindex="-1" aria-labelledby="changeStatusCarLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="changeStatusCarLabel"><fmt:message key="text.edit_status_car"/></h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body">
                <jsp:include page="editStatusCar.jsp">
                    <jsp:param name="statusCar" value="statusCar"/>
                </jsp:include>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createCarModal" tabindex="-1" aria-labelledby="createCarModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="createCarModalLabel"><fmt:message key="button.create_car"/></h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
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
                <h5 class="modal-title" id="registrationModalLabel"><fmt:message key="text.registration"/></h5>
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
                <h5 class="modal-title" id="createCommentModalLabel"><fmt:message key="text.create_your_comment"/></h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body">
                <%@ include file="createComment.jsp" %>
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


