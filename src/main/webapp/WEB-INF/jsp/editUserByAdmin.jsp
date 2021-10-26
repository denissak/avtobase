<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="loc"/>
<html>
<head>
    <title><fmt:message key="text.edit"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%--<link href="avtobase.css">--%>
</head>
<body>

<form action="Controller?command=edituserbyadmin" method="POST">
<%--    <p><c:out value="${param.userId}" /></p>--%>
    <c:forEach var="user" items="${allUser}">
        <c:if test="${user.getId() == param.userId}">
            <div style="display: none" class="mb-3">
                <label for="exampleInputId" class="form-label"><fmt:message key="text.edit"/></label>
                <input type="text"
                       readonly="readonly"
                       name="id"
                       class="form-control"
                       id="exampleInputId"
                       value="${user.getId()}"
                >
            </div>
            <div class="mb-3">
                <label for="exampleInputLogin" class="form-label"><fmt:message key="text.login"/></label>
                <input type="text"
                       name="login"
                       class="form-control"
                       id="exampleInputLogin"
                       aria-describedby="emailHelp"
                       required pattern="[a-z]{5,15}"
                       title="Имя пользователя должно состоять из не менее 5 символов и не более 15, а также включать в себя только латинские символы"
                       value="${user.getLogin()}"
                >

            </div>
            <div class="mb-3">
                <label for="exampleInputPassword" class="form-label"><fmt:message key="text.password"/></label>
                <input type="password"
                       name="password"
                       class="form-control"
                       id="exampleInputPassword"
                       pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{5,25}"
                       title="Пароль должен состоять из не менее 5 символов и не более 15. Должен включать в себя латинские символы верхнего и нижнего регистра, а также как минимум 1 цифру."
                >
            </div>
            <div class="mb-3">
                <label for="exampleInputRole" class="form-label"><fmt:message key="text.role"/></label>
                <select class="form-select" name="role" required aria-label="select example" id="exampleInputRole">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.getId()}" ${user.getRole() == role.getName() ? 'selected="selected"' : ''}>${role.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleInputName" class="form-label"><fmt:message key="text.name"/></label>
                <input type="text"
                       name="name"
                       class="form-control"
                       id="exampleInputName"
                       required pattern="[А-Яа-я]{2,15}"
                       title="Имя должно состоять из кириллических букв."
                       value="${user.getName()}"
                >

            </div>
            <div class="mb-3">
                <label for="exampleInputSurname" class="form-label"><fmt:message key="text.surname"/></label>
                <input type="text"
                       name="surname"
                       class="form-control"
                       id="exampleInputSurname"
                       required pattern="[А-Яа-я]{2,30}"
                       title="Фамилия должно состоять из кириллических букв."
                       value="${user.getSurname()}"
                >
            </div>
            <div class="mb-3">
                <label for="exampleInputPhoneNumber" class="form-label"><fmt:message key="text.phone_number"/></label>
                <input type="text"
                       name="phoneNumber"
                       placeholder="+375XXXXXXXXX"
                       class="form-control"
                       id="exampleInputPhoneNumber"
                       required pattern="^\+375(17|29|33|44)[0-9]{7}$"
                       title="Формат вводимого номера должен быть +375XXXXXXXXX"
                       value="${user.getPhoneNumber()}"
                >
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
