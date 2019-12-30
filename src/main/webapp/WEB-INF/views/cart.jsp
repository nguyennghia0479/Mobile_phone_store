<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href='<spring:url value="/resources/css/bootstrap.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/fontawesome/css/all.min.css"></spring:url>'>
    <link rel="stylesheet" href='<spring:url value="/resources/css/cart.css"></spring:url>'>
    
    <script src='<spring:url value="/resources/js/jquery-3.3.1.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/bootstrap.min.js"></spring:url>'></script>
    <script src='<spring:url value="/resources/js/cart.js"></spring:url>'></script>
    
</head>
<body>
   	<jsp:include page="jumbotron.jsp"/>
    <div class="container-fluid">
        <div class="card shopping-cart">
            <div class="card-header bg-dark text-light">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i> Shipping cart
                <a href="${pageContext.request.contextPath}/home" class="btn btn-outline-info btn-sm fa-pull-right">Continue shopping</a>
                <div class="clearfix"></div>
            </div>
            <div class="card-body scrollable">
            	<c:choose>
            		<c:when test="${!empty cartItems}">
            			<c:forEach items="${cartItems}" var="item">
			           		<div class="row" id="cartItems">
			                    <div class="col-12 col-sm-12 col-md-2 text-center">
			                        <img class="img-responsive" src="data:image/jpeg;base64,${item.productInfo.base64}" alt="${item.productInfo.productName}" width="120px" height="120px">
			                    </div>
			                    <div class="col-12 text-sm-center col-sm-12 text-md-left col-md-6">
			                        <h5 class="product-name"><strong>${item.productInfo.productName}</strong></h5>
			                    </div>
			                    <div class="col-12 col-sm-12 text-sm-center col-md-4 text-md-right row">
			                        <div class="col-3 col-sm-3 col-md-6 text-md-right" style="padding-top: 5px">
			                            <h6><b><fmt:formatNumber value="${item.productInfo.productPrice}" type="number" maxFractionDigits="3"/> VND <span class="text-muted">x</span></b></h6>
			                        </div>
			                        <div class="col-4 col-sm-4 col-md-4">
			                            <div class="quantity">
			                            	<input type="hidden" class="productId" value="${item.productInfo.productId}">
			                                <input type="number" step="1" max="99" min="1" value="${item.quantity}" title="quantity" class="qty quantityChange number">
			                            </div>
			                        </div>
			                        <div class="col-2 col-sm-2 col-md-2 text-right">
			                        	<form method="post" action="${pageContext.request.contextPath}/remove-item">
			                        		<input type="hidden" name="productId" value="${item.productInfo.productId}">
			                        		<button type="submit" class="btn btn-outline-danger btn-xs remove-item">
				                          		<i class="fa fa-trash" aria-hidden="true"></i>
				                           	</button>
			                        	</form>
			                        </div>
			                    </div>
			                </div>
			                <hr>
			           	</c:forEach>
            		</c:when>
            		<c:otherwise>
            			<div class="text-center">
            				<h5>Your cart is <b>empty</b></h5>
            			</div>
            		</c:otherwise>
            	</c:choose>
            </div>
            <div class="card-footer">
                <div class="fa-pull-right" style="margin: 10px">
                	<c:if test="${!empty cartItems}">
                		<a href="checkout" class="btn btn-success pull-right"><i class="fas fa-check"></i> Checkout</a>
                	</c:if>
                    <div class="fa-pull-left" style="margin: 5px">
                        Total price: <b id="totalPrice"><fmt:formatNumber value="${totalPrice}" type="number" maxFractionDigits="3"/> VND</b>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <jsp:include page="footer.jsp"/>
</body>
</html>