<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="loc"/>

<style>
    <%@include file="/WEB-INF/css/comments.css" %>
</style>

<div class="container">

    <h1 class="text-center"><fmt:message key="text.comments"/></h1>
    <div class="row">

        <c:forEach var="comment" items="${allComment}">
            <div class="col-sm-6">
                <div class="testimonial testimonial-default">
                    <div class="testimonial-section">
                        <c:out value="${comment.getMessage()}" />
                    </div>
                    <div class="testimonial-desc">
                        <img src="https://bootstraptema.ru/snippets/icons/2016/mia/1.png" alt=""/>
                        <div class="testimonial-you">
                            <div class="testimonial-you-name">${comment.getUserDto().getName()}</div>
                            <div class="testimonial-you-designation">${comment.getUserDto().getSurname()}</div>
                            <div class="testimonial-you-designation">${comment.getMark()}</div>
                            <div class="testimonial-you-designation">${comment.getCommentDate()}</div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
