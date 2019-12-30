<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/fontawesome/css/all.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/login.css"></spring:url>'>
    
    <script src='<spring:url value="/resources/js/jquery-3.3.1.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
</head>
<body>
	<div class="container register">
        <div class="row">
            <div class="col-md-12">
                <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Login Form</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Register Form</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active text-align form-new" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <h3 class="register-heading">Login Form</h3>
                        <div class="row register-form">
                            <div class="col-md-12">
                                <form action="${pageContext.request.contextPath}/actionLogin" method="post">
                                    <div class="form-group">
                                        <input type="text" name="username" class="form-control" placeholder="Your Email *" required/>
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password" class="form-control" placeholder="Your Password *" required />
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btnContactSubmit btn btn-outline-primary" value="Login" />
                                    </div>
                                    <div class="form-group">
                                        <a href="#" class="btnForgetPwd">Forget Password ?</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade show text-align form-new" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                        <h3 class="register-heading">Register Form</h3>
                        <div class="row register-form">
                            <div class="col-md-12">
                                <form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="account">
                                	<form:input path="accountId" type="hidden"/>
                                    <div class="form-group">
                                        <form:input path="fullName" type="text" name="fullName" class="form-control" placeholder="Your Full Name *"/>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="phoneNumber" type="text" name="phoneNumber" class="form-control" placeholder="Your Phone Number *"/>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="email" type="email" name="email" class="form-control" placeholder="Your Email *"/>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="username" type="text" name="username" class="form-control" placeholder="Your Username *"/>
                                    </div>
                                    <div class="form-group">
                                        <form:input path="password" type="password" name="password" class="form-control" placeholder="Your Password *"/>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btnContactSubmit btn btn-outline-primary" value="Register" />
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>