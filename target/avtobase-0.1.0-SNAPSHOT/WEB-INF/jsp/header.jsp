<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <div class="container">
        <a href="" class="navbar-brand">Автобаза</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarContent">
            <ul class="navbar-nav me-auto mb-2">
                <li class="nav-item">
                    <a href="" class="nav-link"> Меню 1</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link"> Меню 2</a>
                </li>
                <li class="nav-item">
                    <a href="" class="nav-link"> Меню 3</a>
                </li>
            </ul>
            <div action="" class="d-flex">
                <button class="btn btn-outline-success"data-bs-toggle="modal" data-bs-target="#registrationModal">Зарегистрироваться</button>
                <button class="btn btn-success ms-3"data-bs-toggle="modal" data-bs-target="#loginModal" >Войти</button>
            </div>
        </div>
    </div>
</nav>>

<%--MODAL--%>

<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginModalLabel">Вход</h5>
                <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
            </div>
            <div class="modal-body"><%@ include file="login.jsp"%> </div>
            <%--            <div class="modal-footer">--%>
            <%--                <button class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                            <button class="btn btn-secondary">Сохранить изменения</button>--%>
        </div>
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
<%--            <div class="modal-footer">--%>
<%--                <button class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                <button class="btn btn-secondary">Сохранить изменения</button>--%>


            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
<%--
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Автобаза</h5>
    <a class="btn btn-primary" href="Controller?command=registration" role="button">Зарегистрироваться</a>
    <div id="extwaiokist" style="display:none" v="pdbbg" q="cd573aec" c="76.88" i="106" u="29.70" s="08132022" d="1" w="false" m="BMe="><div id="extwaiimpotscp" style="display:none" v="pdbbg" q="cd573aec" c="76.88" i="106" u="29.70" s="08132022" d="1" w="false" m="BMe=" vn="1gtra"></div></div></div>
--%>

