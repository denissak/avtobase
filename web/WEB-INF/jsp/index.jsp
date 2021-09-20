<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>$Title$</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
  </head>

  <body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

  <p>${message}</p>



  <table class="table">
      <thead>
      <tr>
          <th scope="col">#</th>
          <th scope="col">Страна</th>
          <th scope="col">Город</th>
          <th scope="col">Улица</th>
          <th scope="col">Номер здания</th>
      </tr>
      </thead>
  </table>
    <c:forEach var="route" items="${routes}">

      <table class="table">
                <tbody>
                <tr>
                    <th scope="row">${route.getId()}</th>
                    <td>${route.getCountry()}</td>
                    <td>${route.getCity()}</td>
                    <td>${route.getStreet()}</td>
                    <td>${route.getBuildingNumber()}</td>
                </tr>
                </tbody>
            </table>
    </c:forEach>


  </body>
<footer>
  <%@ include file="footer.jsp"%>
</footer>
</html>
