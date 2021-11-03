<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style><%@include file="/WEB-INF/css/comments.css"%></style>

<div class="container">

    <h1 class="text-center"><fmt:message key="text.comments"/></h1>
    <div class="row">

<c:forEach var="comment" items="${allComment}">
        <div class="col-sm-6">
            <div class="testimonial testimonial-default">
                <div class="testimonial-section">
                        ${comment.getMessage()}
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/1.png" alt="" />
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
       <%-- <div class="col-sm-6">
            <div class="testimonial testimonial-primary">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/2.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-info">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/3.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-success">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/4.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-warning">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/5.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-danger">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/6.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>--%>

    </div><!-- /.row -->

    <%--<div class="clearfix"></div>

    <hr/>
    <h1 class="text-center">Testimonials Background Style</h1>
    <div class="row">

        <div class="col-sm-6">
            <div class="testimonial testimonial-default-bg">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/7.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-primary-bg">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/8.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-info-bg">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/9.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-success-bg">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/10.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-warning-bg">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/11.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-6">
            <div class="testimonial testimonial-danger-bg">
                <div class="testimonial-section">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                </div>
                <div class="testimonial-desc">
                    <img src="https://bootstraptema.ru/snippets/icons/2016/mia/12.png" alt="" />
                    <div class="testimonial-you">
                        <div class="testimonial-you-name">You Name</div>
                        <div class="testimonial-you-designation">You Profile</div>
                        <a href="#" class="testimonial-you-company">You Link</a>
                    </div>
                </div>
            </div>
        </div>

    </div><!-- /.row -->--%>

</div><!-- /.container -->
