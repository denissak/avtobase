<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <jsp:include page="WEB-INF/jsp/header.jsp">
        <jsp:param name="typeTransports" value="typeTransports"/>
        <jsp:param name="statusCars" value="statusCars"/>
    </jsp:include>

</head>

<body>

<div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://s1.1zoom.ru/big0/780/Trucks_FAW_Jiefang_J7_Eagle_6x4_Tractor_2017-2020_588483_1280x792.jpg"
                 class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://s1.1zoom.ru/big0/206/BMW_X3_xDrive30i_M_Sport_(China_)_(G08)_2021_White_607978_1280x853.jpg"
                 class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>


</body>
<footer id="footer" class="footer navbar-fixed-bottom">
    <div class="position-absolute">
        <%@ include file="WEB-INF/jsp/footer.jsp" %>
    </div>

</footer>
</html>
