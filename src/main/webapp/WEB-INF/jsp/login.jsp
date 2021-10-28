<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="button.log_in"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>

<form action="Controller?command=login" method="POST">
    <div class="mb-3">
        <label for="exampleInputLogin" class="form-label"><fmt:message key="text.login"/></label>
        <input type="text"
               name="login"
               class="form-control"
               id="exampleInputLogin"
               value="${param.login}"
               aria-describedby="emailHelp"
               required>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword" class="form-label"><fmt:message key="text.password"/></label>
        <input type="password"
               name="password"
               class="form-control"
               id="exampleInputPassword"
               required>
    </div>
    <button type="submit" class="btn btn-primary"><fmt:message key="button.log_in"/></button>
    <c:if test="${param.error != null}">
        <%--        <div>
                    <span>Login or Password is not correct</span>
                </div>--%>

    </c:if>

</form>

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
</html>
