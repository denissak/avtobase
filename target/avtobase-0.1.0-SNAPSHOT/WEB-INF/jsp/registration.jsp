<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%--<link href="avtobase.css">--%>
</head>
<body>

<form action="Controller?command=registration" method="POST">
    <div class="mb-3">
        <label for="exampleInputLogin" class="form-label">Login</label>
        <input type="text" name="login" class="form-control" id="exampleInputLogin" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword">
    </div>
    <div class="mb-3">
        <label for="exampleInputName" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="exampleInputName">
    </div>
    <div class="mb-3">
        <label for="exampleInputSurname" class="form-label">Surname</label>
        <input type="text" name="surname" class="form-control" id="exampleInputSurname">
    </div>
    <div class="mb-3">
        <label for="exampleInputPhoneNumber" class="form-label">PhoneNumber</label>
        <input type="text" name="phoneNumber" class="form-control" id="exampleInputPhoneNumber">
    </div>
    <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
</body>
</html>
