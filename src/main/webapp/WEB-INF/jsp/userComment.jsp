<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Мои комментарии</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <%@ include file="header.jsp"%>
</head>

<body>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Дата комментария</th>
        <th scope="col">Оценка</th>
        <th scope="col">Комментарий</th>
    </tr>
    <c:forEach var="comment" items="${commentsById}">
        <tr>
                <%--<th scope="row">$${request.getDateCreate()}</th>--%>
            <td>${comment.getCommentDate()}</td>
            <td>${comment.getMark()}</td>
            <td>${comment.getMessage()}</td>
<%--            <td>
                <button class="btn btn-outline-warning ms-3 "data-bs-toggle="modal" data-bs-target=".commentId_${comment.getId()}">Редактировать
                    <c:set var = "requestId" value = "${request.getId()}"/>
                </button>
            </td>
            <td>
                <form action="Controller?command=requesteditbyuser" method="post">
                    <input type="hidden" name="id" value="${request.getId()}">
                    <input type="hidden" name="method" value="delete">
                    <input class="btn btn-danger" type="submit" value="Удалить">
                </form>
            </td>--%>
        </tr>
 <%--       <div class="modal fade requestId_${request.getId()}" id="updateUserModal" tabindex="-1" aria-labelledby="updateUserModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="updateUserModalLabel">Редактировать заявку</h5>
                        <button class="btn-close" data-bs-dismiss="modal" aria-bs-label="close"></button>
                    </div>
                        &lt;%&ndash;<div class="modal-body"> <a href="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"></a></div>&ndash;%&gt;
                    <div class="modal-body">&lt;%&ndash;<<%@ include file="userEditByAdmin.jsp"%>>&ndash;%&gt;
                            &lt;%&ndash;                            <jsp:param name="type1" value="${user}" />&ndash;%&gt;
                        <jsp:include page="requestEditByUser.jsp">
                            <jsp:param name="requestId" value="${requestId}" />
                        </jsp:include>
                            &lt;%&ndash;                <c:redirect url="Controller?command=usereditbyadmin"/>&ndash;%&gt;
                            &lt;%&ndash;<%@ include file="createUserRequest.jsp"%>&ndash;%&gt; &lt;%&ndash;<jsp:include page="${pageContext.request.contextPath}/Controller?command=gotocreaterequest"&ndash;%&gt; </div>
                </div>
            </div>
        </div>--%>
    </c:forEach>
    </thead>
</table>

</body>
<footer>
    <%@ include file="footer.jsp"%>
</footer>
</html>

