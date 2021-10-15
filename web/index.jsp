<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

      <%--<%@ include file="header.jsp"%>--%>
      <jsp:include page="WEB-INF/jsp/header.jsp">
          <jsp:param name="typeTransports" value="typeTransports" />
          <jsp:param name="statusCars" value="statusCars"/>
      </jsp:include>

  </head>

  <body>

  <div id="carouselExampleFade" class="carousel slide carousel-fade" data-bs-ride="carousel">
      <div class="carousel-inner">
          <div class="carousel-item active">
              <img src="https://kartinkin.com/uploads/posts/2021-01/1611320516_27-p-krasivii-fon-dlya-avto-30.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
              <img src="https://kartinkin.net/uploads/posts/2021-07/thumbs/1625186709_25-kartinkin-com-p-fon-mashini-krasivie-foni-25.jpg" class="d-block w-100" alt="...">
          </div>
<%--          <div class="carousel-item">
              <img src="..." class="d-block w-100" alt="...">
          </div>--%>
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
<footer>
  <%@ include file="WEB-INF/jsp/footer.jsp"%>
</footer>
</html>
