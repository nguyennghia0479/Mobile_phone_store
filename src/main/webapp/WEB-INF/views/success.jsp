<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Success</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/fontawesome/css/all.min.css"></spring:url>'>
    
    <script src='<spring:url value="/resources/js/jquery-3.3.1.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
</head>
<body>
	<div class="jumbotron text-center">
	  <h1 class="display-3">Thank You!</h1>
	  <p class="lead"><strong>Please check your email or phone</strong> for details of your order.</p>
	  <hr>
	  <p>
	    Having trouble? <a href="#">Contact us</a>
	  </p>
	  <p class="lead">
	    <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/home" role="button">Continue to homepage</a>
	  </p>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>