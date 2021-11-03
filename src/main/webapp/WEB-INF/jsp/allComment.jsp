<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />

<style>
    .testimonial{
        margin-bottom: 10px;
    }

    .testimonial-section {
        width: 100%;
        height: auto;
        padding: 15px;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
        border-radius: 5px;
        position: relative;
        border: 1px solid #fff;
    }
    .testimonial-section:after {
        top: 100%;
        left: 50px;
        border: solid transparent;
        content: " ";
        position: absolute;
        border-top-color: #fff;
        border-width: 15px;
        margin-left: -15px;
    }

    .testimonial-desc {
        margin-top: 20px;
        text-align:left;
        padding-left: 15px;
    }
    .testimonial-desc img {
        border: 1px solid #f5f5f5;
        border-radius: 150px;
        height: 70px;
        padding: 3px;
        width: 70px;
        display:inline-block;
        vertical-align: top;
    }

    .testimonial-you{
        display: inline-block;
        vertical-align: top;
        padding-left: 10px;
    }

    .testimonial-you-name{
        font-weight: bold;
    }

    .testimonial-you-designation{
        font-size: 85%;
    }

    .testimonial-you-company{
        font-size: 85%;
    }

    /*- Testimonials Transparent Style -*/
    .testimonial.testimonial-default{

    }
    .testimonial.testimonial-default .testimonial-section{
        border-color: #777;
    }

    .testimonial.testimonial-default .testimonial-section:after{
        border-top-color: #777;
    }

    .testimonial.testimonial-default .testimonial-desc{

    }

    .testimonial.testimonial-default .testimonial-desc img{
        border-color: #777;
    }

    .testimonial.testimonial-default .testimonial-you-name{
        color: #777;
    }

    .testimonial.testimonial-primary{

    }
    .testimonial.testimonial-primary .testimonial-section{
        border-color: #337AB7;
        color: #286090;
        background-color: rgba(51, 122, 183, 0.1);
    }

    .testimonial.testimonial-primary .testimonial-section:after{
        border-top-color: #337AB7;
    }

    .testimonial.testimonial-primary .testimonial-desc{

    }

    .testimonial.testimonial-primary .testimonial-desc img{
        border-color: #337AB7;
    }

    .testimonial.testimonial-primary .testimonial-you-name{
        color: #337AB7;
    }

    .testimonial.testimonial-info{

    }
    .testimonial.testimonial-info .testimonial-section{
        border-color: #5BC0DE;
        color: #31b0d5;
        background-color: rgba(91, 192, 222, 0.1);
    }

    .testimonial.testimonial-info .testimonial-section:after{
        border-top-color: #5BC0DE;
    }

    .testimonial.testimonial-info .testimonial-desc{

    }

    .testimonial.testimonial-info .testimonial-desc img{
        border-color: #5BC0DE;
    }

    .testimonial.testimonial-info .testimonial-you-name{
        color: #5BC0DE;
    }


    .testimonial.testimonial-success{

    }
    .testimonial.testimonial-success .testimonial-section{
        border-color: #5CB85C;
        color: #449d44;
        background-color: rgba(92, 184, 92, 0.1);
    }

    .testimonial.testimonial-success .testimonial-section:after{
        border-top-color: #5CB85C;
    }

    .testimonial.testimonial-success .testimonial-desc{

    }

    .testimonial.testimonial-success .testimonial-desc img{
        border-color: #5CB85C;
    }

    .testimonial.testimonial-success .testimonial-you-name{
        color: #5CB85C;
    }

    .testimonial.testimonial-warning{

    }
    .testimonial.testimonial-warning .testimonial-section{
        border-color: #F0AD4E;
        color: #d58512;
        background-color: rgba(240, 173, 78, 0.1);
    }

    .testimonial.testimonial-warning .testimonial-section:after{
        border-top-color: #F0AD4E;
    }

    .testimonial.testimonial-warning .testimonial-desc{

    }

    .testimonial.testimonial-warning .testimonial-desc img{
        border-color: #F0AD4E;
    }

    .testimonial.testimonial-warning .testimonial-you-name{
        color: #F0AD4E;
    }

    .testimonial.testimonial-danger{

    }
    .testimonial.testimonial-danger .testimonial-section{
        border-color: #D9534F;
        color: #c9302c;
        background-color: rgba(217, 83, 79, 0.1);
    }

    .testimonial.testimonial-danger .testimonial-section:after{
        border-top-color: #D9534F;
    }

    .testimonial.testimonial-danger .testimonial-desc{

    }

    .testimonial.testimonial-danger .testimonial-desc img{
        border-color: #D9534F;
    }

    .testimonial.testimonial-danger .testimonial-you-name{
        color: #D9534F;
    }

    /*- Testimonials Background Style -*/
    .testimonial.testimonial-default-bg{

    }
    .testimonial.testimonial-default-bg .testimonial-section{
        color: #fff;
        border-color: #777;
        background-color: #777;
    }

    .testimonial.testimonial-default-bg .testimonial-section:after{
        border-top-color: #777;
    }

    .testimonial.testimonial-default-bg .testimonial-desc{

    }

    .testimonial.testimonial-default-bg .testimonial-desc img{
        border-color: #777;
        background-color: #777;
    }

    .testimonial.testimonial-default-bg .testimonial-you-name{
        color: #777;
    }

    .testimonial.testimonial-primary-bg{

    }
    .testimonial.testimonial-primary-bg .testimonial-section{
        color: #fff;
        background-color: #337ab7;
        border-color: #2e6da4;
    }

    .testimonial.testimonial-primary-bg .testimonial-section:after{
        border-top-color: #337AB7;
    }

    .testimonial.testimonial-primary-bg .testimonial-desc{

    }

    .testimonial.testimonial-primary-bg .testimonial-desc img{
        border-color: #2e6da4;
        background-color: #337ab7;
    }

    .testimonial.testimonial-primary-bg .testimonial-you-name{
        color: #337AB7;
    }

    .testimonial.testimonial-info-bg{

    }
    .testimonial.testimonial-info-bg .testimonial-section{
        color: #fff;
        background-color: #5bc0de;
        border-color: #46b8da;
    }

    .testimonial.testimonial-info-bg .testimonial-section:after{
        border-top-color: #5BC0DE;
    }

    .testimonial.testimonial-info-bg .testimonial-desc{

    }

    .testimonial.testimonial-info-bg .testimonial-desc img{
        border-color: #46b8da;
        background-color: #5bc0de;
    }

    .testimonial.testimonial-info-bg .testimonial-you-name{
        color: #5BC0DE;
    }


    .testimonial.testimonial-success-bg{

    }
    .testimonial.testimonial-success-bg .testimonial-section{
        color: #fff;
        background-color: #5cb85c;
        border-color: #4cae4c;
    }

    .testimonial.testimonial-success-bg .testimonial-section:after{
        border-top-color: #5CB85C;
    }

    .testimonial.testimonial-success-bg .testimonial-desc{

    }

    .testimonial.testimonial-success-bg .testimonial-desc img{
        border-color: #4cae4c;
        background-color: #5cb85c;
    }

    .testimonial.testimonial-success-bg .testimonial-you-name{
        color: #5CB85C;
    }

    .testimonial.testimonial-warning-bg{

    }
    .testimonial.testimonial-warning-bg .testimonial-section{
        color: #fff;
        background-color: #f0ad4e;
        border-color: #eea236;
    }

    .testimonial.testimonial-warning-bg .testimonial-section:after{
        border-top-color: #F0AD4E;
    }

    .testimonial.testimonial-warning-bg .testimonial-desc{

    }

    .testimonial.testimonial-warning-bg .testimonial-desc img{
        border-color: #eea236;
        background-color: #f0ad4e;
    }

    .testimonial.testimonial-warning-bg .testimonial-you-name{
        color: #F0AD4E;
    }

    .testimonial.testimonial-danger-bg{

    }
    .testimonial.testimonial-danger-bg .testimonial-section{
        color: #fff;
        background-color: #d9534f;
        border-color: #d43f3a;
    }

    .testimonial.testimonial-danger-bg .testimonial-section:after{
        border-top-color: #D9534F;
    }

    .testimonial.testimonial-danger-bg .testimonial-desc{

    }

    .testimonial.testimonial-danger-bg .testimonial-desc img{
        border-color: #d43f3a;
        background-color: #D9534F;
    }

    .testimonial.testimonial-danger-bg .testimonial-you-name{
        color: #D9534F;
    }
</style>

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
