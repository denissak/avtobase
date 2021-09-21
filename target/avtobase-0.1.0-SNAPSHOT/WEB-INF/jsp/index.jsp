<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>$Title$</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
  </head>

  <body>




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
