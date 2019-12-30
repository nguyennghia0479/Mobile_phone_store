<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Mobile Online</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/fontawesome/css/all.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/jquery-ui.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/home.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/search_product.css"></spring:url>'>
    
    <script src='<spring:url value="/resources/js/jquery-3.3.1.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/jquery-ui.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/add_cart.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/sort.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/search_product.js"></spring:url>'></script>
    
</head>

<body>
   	<jsp:include page="jumbotron.jsp"/>
 	<jsp:include page="menu_navbar.jsp"/>
    <div class="container-fluid">
        <div class="row">
            <jsp:include page="menu_sidebar.jsp"/>
            <c:set var="pagedListHolder" value="${pagedListHolder}" scope="session" /> 	
            <div class="col-sm-9">
                <div class="row">
                	<c:forEach items="${pagedListHolder.pageList}" var="product">
                		<div class="col-sm-4 product">
                        <br>
                        <div class="card" style="width: 18rem;">
                            <a href="${pageContext.request.contextPath}/${product.productNameURL}">
                                <img src="data:image/jpeg;base64,${product.base64}" class="card-img-top" alt="${product.productName}">
                            </a>
                            <div class="card-body">
                                <h5 class="card-title"><a href="product_details.html">${product.productName}</a></h5>
                                <p class="card-text"><b><fmt:formatNumber value="${product.productPrice}" type="number" maxFractionDigits="3"/> VND</b></p>
                                <input type="hidden" class="productId" value="${product.productId}">
                                <button class="btn btn-outline-primary add-cart"><i class="far fa-plus-square"></i> Add cart</button>
                            </div>
                        </div>
                    </div>
                	</c:forEach>
                </div>
                <br>
                <jsp:include page="paging.jsp"/>
            </div>
        </div>
    </div>
 	<jsp:include page="footer.jsp"/>
</body>
</html>